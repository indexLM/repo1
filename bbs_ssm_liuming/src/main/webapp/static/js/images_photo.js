//图片上传预览
function user_previewImage(file) {
    var MAXWIDTH = 90;
    var MAXHEIGHT = 90;
    var div = document.getElementById('user_preview');
    div.innerHTML = '<img style="position: relative;width: 100%;height: 100%;" id=user_imghead onclick=$("#user_previewImg").click()>';
    var img = document.getElementById('user_imghead');
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