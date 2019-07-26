package com.lm.controller;

import com.lm.bean.Article;
import com.lm.bean.Article2;
import com.lm.bean.Comment;
import com.lm.service.ArticleService;
import com.lm.service.CollectService;
import com.lm.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequestMapping("/articleController")
@SessionAttributes(value = {"article_Edit", "article_Show"})
@Controller
public class ArticleController {
    @Autowired
    ArticleService articleService;
    @Autowired
    CommentService commentService;
    @Autowired
    CommentController commentController;
    @Autowired
    CollectService collectService;

    /**
     * 向数据库插入发帖信息（包括图片）
     *
     * @param file
     * @param article2
     * @return
     * @throws IOException
     */
    @RequestMapping("/setArticle")
    //有MultipartFile file的时候不能有 Article article，因为Article中包含了文件（file）????!!!
    public String setArticle(@RequestParam("photo") MultipartFile file, Article2 article2, HttpSession session, HttpServletRequest request)
            throws IOException {

        //文件（图片）路径  /static/upload/article
        String filePath = request.getServletContext().getRealPath("/static/upload/article/");
        //用于存放新生成的文件名字(不重复)
        String newFileName = null;
        String username = (String) session.getAttribute("username");
        //用户登录情况下才可发帖
        if (username != null) {
            //当其中没有值时"int userid=null"报错(肯定报错啊，int=null???)
            int userid = (Integer) session.getAttribute("userid");
            // 获取上传图片的文件名及其后缀(获取原始图片的拓展名)
            String fileName = file.getOriginalFilename();

            if (!fileName.equals("")) {
                //生成新的文件名字(不重复)
                newFileName = UUID.randomUUID() + fileName;
                // 封装上传文件位置的全路径
                File targetFile = new File(filePath, newFileName);
                // 把本地文件上传到封装上传文件位置
                file.transferTo(targetFile);
            }

            // 将article2和photo整合到article中
            Article article = new Article(article2, newFileName);
            article.setUserid(userid);
            article.setUsername(username);
            article.setStatus(0);
            // 将article保存到数据库
            articleService.setArticle(article);
        }
        //重定向
        return "redirect:/index.jsp";
    }

    /**
     * 查询发帖表信息（无条件）
     *
     * @param map
     */
    public void getArticle(Map<Object, Object> map) {

        List<Article> listArticle = articleService.getArticle();
        map.put("listArticle", listArticle);

    }

    /**
     * 按帖子标题模糊查询（搜索框搜索）
     *
     * @param articleTitle
     * @param map
     */
    public void getArticleTitle(String articleTitle, Map<Object, Object> map) {

        List<Article> listArticle = articleService.getArticleTitle(articleTitle);
        map.put("listArticle", listArticle);
    }

    /**
     * 按帖子板块查询出帖子
     *
     * @param bname
     * @param map
     */
    public void getArticleBname(String bname, Map<Object, Object> map) {

        List<Article> listArticle = articleService.getArticleBname(bname);
        map.put("listArticle", listArticle);
    }


    /**
     * 按fid删除帖子
     *
     * @param article
     * @return
     * @throws IOException
     */
    @RequestMapping("/deleteArticle")
    public ModelAndView deleteArticle(Article article, HttpServletRequest request) throws IOException {

        int fid = article.getFid();
        int count = commentService.getCommentFid(fid).size();

        //不能将commentService.getCommentFid(fid).size();
        for (int i = 0; i < count; i++) {
            //因为每一次commentService.deleteComment(pid)都会删除一条记录，总记录就会少一条，自然之前的get(1)就变成了现在的get(0)
            int pid = commentService.getCommentFid(fid).get(0).getPid();
            //删除帖子下对应的评论（注意：先删评论再删帖子！！）
            commentService.deleteComment(pid);
        }

        //调用删除帖子对应图片的方法
        articlePhotoDelete(fid, request);
        //删除帖子(数据库)
        articleService.deleteArticle(fid);

        //删除有该帖子id的收藏信息
        collectService.deleteCollectFid(fid);

        //删除该用户对应的收藏信息(按userid)
        collectService.deleteCollectFid(fid);

        //重定向到getMyself这个方法
        return new ModelAndView("redirect:/userController/getMyself");
    }

    /**
     * 获取mycontent.jsp页面传来的数据，并将其保存在map("article")中，以便articleEdit.jsp页面使用
     *
     * @param article
     * @param map
     * @return
     */
    @RequestMapping("/getUpdateArticle")
    public String getUpdateArticle(Article article, Map<Object, Object> map) {

        map.put("article_Edit", article);

        return "redirect:/content/articleEdits.jsp";
    }

    /**
     * 修改帖子表
     *
     * @param
     * @return
     * @throws IOException
     */
    @RequestMapping("/updateArticle")
    public ModelAndView updateArticle(@RequestParam("photo") MultipartFile file, Article2 article2, HttpServletRequest request) throws IOException {
        //文件（图片）路径
        String filePath = request.getServletContext().getRealPath("/static/upload/article/");
        int fid = article2.getFid();

        // 获取上传图片的文件名及其后缀(获取原始图片的拓展名)
        String fileName = file.getOriginalFilename();
        String newFileName =null;
        if (fileName != null && !"".equals(fileName)) {
            // 生成新的文件名字(不重复)
            newFileName = UUID.randomUUID() + fileName;
            // 封装上传文件位置的全路径
            File targetFile = new File(filePath, newFileName);
            // 把本地文件上传到封装上传文件位置的全路径
            file.transferTo(targetFile);
            //调用删除帖子对应图片的方法
            articlePhotoDelete(fid, request);
        }
        // 将article2和photo整合到article中
        Article article = new Article(article2, newFileName);
        //修改帖子表（数据库）
        articleService.updateArticle(article);

        //重定向到getMyself这个方法
        return new ModelAndView("redirect:/userController/getMyself");
    }


    /**
     * 删除帖子对应的图片
     *
     * @throws IOException
     */
    public void articlePhotoDelete(int fid, HttpServletRequest request) throws IOException {

        //文件（图片）路径
        String filePath = request.getServletContext().getRealPath("/static/upload/article/");
        // 获取取要删除帖子对应的图片的文件名（通过fid获取帖子信息）
        String fileName = articleService.getArticleKey(fid).getPhoto();
        // 封装上传文件位置的全路径
        File targetFile = new File(filePath, fileName);
        //删除帖子对应的图片（实际删除）
        targetFile.delete();
    }

    /**
     * 修改article表的status属性（修改审核状态）
     *
     * @return
     */
    @RequestMapping("/articleStatus")
    public String articleStatus(Article article) {
        articleService.updateArticleStatus(article);
        return "redirect:/admin/index.jsp";
    }

    /**
     * 按fid查询帖子信息（帖子展示）
     *
     * @return
     */
    @RequestMapping("/getArticleFid")
    public String getArticleFid(Map<Object, Object> map,HttpServletRequest request) {
        int fid = Integer.parseInt(request.getParameter("fid"));
        Article article = articleService.getArticleKey(fid);
        map.put("article_Show", article);
        //再通过每一个帖子的id查找出对应的评论信息
        commentController.getCommentFid(fid, map);
        //将上一步查出的对应的评论信息存放到listComment里
        List<Comment> listComment =  (List<Comment>) map.get("listComment");
        //将帖子下对应的所有评论存入map中
        map.put("comments", listComment);
        System.out.println("---"+map.get("comments"));
        return "forward:/content/articleShow.jsp";
    }
}
