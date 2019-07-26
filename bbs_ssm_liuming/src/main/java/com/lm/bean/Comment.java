package com.lm.bean;

public class Comment {
    //评论编号
    private Integer pid;
    //评论内容
    private String pcontent;
    //评论用户
    private Integer userid;
    //评论帖子id
    private Integer fid;
    //评论时间
    private String time;

    //用户名
    private String name;

    public Comment() {
        super();
    }

    public Comment(Integer pid, String pcontent, Integer userid, Integer fid, String time) {
        super();
        this.pid = pid;
        this.pcontent = pcontent;
        this.userid = userid;
        this.fid = fid;
        this.time = time;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getPcontent() {
        return pcontent;
    }

    public void setPcontent(String pcontent) {
        this.pcontent = pcontent == null ? null : pcontent.trim();
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getFid() {
        return fid;
    }

    public void setFid(Integer fid) {
        this.fid = fid;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time.substring(0,time.length()-2);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Comment [pid=" + pid + ", pcontent=" + pcontent + ", userid=" + userid + ", fid=" + fid + ", time="
                + time + ", name=" + name + "]";
    }

}
