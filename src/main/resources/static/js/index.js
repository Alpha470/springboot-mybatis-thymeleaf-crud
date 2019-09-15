$(function () {
    var search = $("#search-btn");
    search.click(function () {
        var name = $("#title");
        if (name.val() === null || name.val() === '') {
            alert("请输入~");
            return;
        }
        console.log(search);
        search.submit();
    })
});