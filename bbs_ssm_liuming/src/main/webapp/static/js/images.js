//图片上传预览
function f_previewImage(file) {
    var MAXWIDTH = 90;
    var MAXHEIGHT = 90;
    var div = document.getElementById('f_preview');
    //获取文件路径    
    var filePath = document.getElementById('f_previewImg').value;
    //获取最后一个.的位置
    var index = filePath.lastIndexOf(".");
    //获取后缀
    var ext = filePath.substr(index);
    if (ext.endsWith('.mp4') || ext.endsWith('.avi')) {	//视频文件
        div.innerHTML = '<video style="position: relative;width: 100%;height: 100%;" id=f_imghead onclick=$("#f_previewImg").click()></video>';
    } else {	//图片文件
        div.innerHTML = '<img style="position: relative;width: 100%;height: 100%;" id=f_imghead onclick=$("#f_previewImg").click()>';
    }
    var img = document.getElementById('f_imghead');
    img.onload = function () {
        var rect = clacImgZoomParam(MAXWIDTH, MAXHEIGHT, img.offsetWidth, img.offsetHeight);
        img.width = rect.width;
        img.height = rect.height;
        img.style.marginTop = rect.top + 'px';
    }
    var reader = new FileReader();
    reader.onload = function (evt) {
        img.src = evt.target.result;
    }
    reader.readAsDataURL(file.files[0]);
}

function clacImgZoomParam(maxWidth, maxHeight, width, height) {
    var param = {top: 0, left: 0, width: width, height: height};

    return param;
}