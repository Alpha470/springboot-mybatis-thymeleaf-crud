
$(function () {
    var title = $("#title");
    var mdContent = $("#mdContent");
    var summary = $("#summary");
    var state = $("#state");

    $("#sb").click(function () {

        if (title.val() === null || title.val() === "") {
            alert("请填写标题~");
            return;
        }
        if (mdContent.val() === null || mdContent.val() === "") {
            alert("请填写内容~");
            return;
        }
        if (summary.val() === null || summary.val() === "") {
            alert("请填写概述~");
            return;
        }
        $("form").submit();
    });

    $("#back").click(function () {
        history.back(-1);
    })
});