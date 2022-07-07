<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <base href="${pageContext.request.contextPath}/">
    <title>文档查询</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="css/public.css" media="all">
</head>
<body>
<div class="layuimini-container">
    <div class="layuimini-main">

        <fieldset class="table-search-fieldset">
            <legend>搜索信息</legend>
            <div style="margin: 10px 10px 10px 10px">
                <form class="layui-form layui-form-pane" action="">
                    <div class="layui-form-item">
                        <div class="layui-inline">
                            <label class="layui-form-label">文档标题</label>
                            <div class="layui-input-inline">
                                <input type="text" name="documentTitle" autocomplete="off" class="layui-input">
                            </div>
                        </div>

                        <div class="layui-inline">
                            <button type="submit" class="layui-btn layui-btn-primary"  lay-submit lay-filter="data-search-btn"><i class="layui-icon"></i> 搜 索</button>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>

        <script type="text/html" id="toolbarDemo">
            <div class="layui-btn-container">
                <button class="layui-btn layui-btn-normal layui-btn-sm data-add-btn" lay-event="add"> 添加 </button>
                <button class="layui-btn layui-btn-sm layui-btn-danger data-delete-btn" lay-event="delete"> 删除 </button>
            </div>
        </script>

        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter">


        </table>

        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">下载</a>
        </script>

    </div>
</div>
<script src="lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        table.render({
            elem: '#currentTableId',
            url: 'document/getDocumentList',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            cols: [[
                {type: "checkbox", width: 50},
                {field: 'documentTitle', width: 200, title: '标题'},
                {field: 'createDate', width: 200, title: '创建时间'},
                {field: 'documentPeople', width: 100, title: '创建人'},
                {field: 'documentRemark', width: 250, title: '描述'},
                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100], //这个是前端选择分页的选项下拉框
            limit: 10,                         //默认分页数
            page: true,
            skin: 'line'
        });

        // 监听搜索操作
        form.on('submit(data-search-btn)', function (data) {
            var result = JSON.stringify(data.field);
            // layer.alert(result, {
            //     title: '最终的搜索信息'
            // });

            //执行搜索重载
            table.reload('currentTableId', {
                page: {
                    curr: 1
                }
                , where: {
                    searchParams: result
                }
            }, 'data');

            return false;
        });

        /**
         * toolbar监听事件
         */
        table.on('toolbar(currentTableFilter)', function (obj) {
            if (obj.event === 'add') {  // 监听添加操作
                var index = layer.open({
                    title: '添加文档',
                    type: 2,
                    shade: 0.2,
                    maxmin:true,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: 'document/document-upload.jsp',
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            } else if (obj.event === 'delete') {  // 监听删除操作
                var checkStatus = table.checkStatus('currentTableId')
                    , data = checkStatus.data;
                //不需要所有数据
                //layer.alert(JSON.stringify(data));

                //只要id就行
                var ids=$.map(data,function (obj) { //取出数组对象
                    return obj.documentId;
                });

                //ajax提交
                $.ajax({
                    type: "POST",
                    url: "document/documentDelete",
                    data: {"ids" : ids.join(",")},
                    dataType: "json",
                    success: function (data) {
                        if(data.code=="1001"){
                            layer.msg('删除成功',{icon: 1});
                        }else{
                            layer.msg('删除失败',{icon: 2})
                        }
                    },
                    error:function () {
                        layer.msg("系统异常",{icon: 2})
                    }
                });

            }
        });

        //监听表格复选框选择
        table.on('checkbox(currentTableFilter)', function (obj) {
            console.log(obj)
        });

        table.on('tool(currentTableFilter)', function (obj) {
            var data = obj.data; //获取一行数据
          //  console.log(data)
            if (obj.event === 'edit') {

                var index = layer.open({
                    title: '编辑公告',
                    type: 2,
                    shade: 0.2,
                    maxmin:true,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: 'document/showDocument?id='+data.documentId,   //跳转页面，并携带id参数
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
                return false;
            } else if (obj.event === 'delete') { //这是文件下载操作

                var ids=data.documentId;
                console.log(ids);

                location.href="document/documentDownLoad?id="+ids;
                // var index = layer.open({
                //     title: '文件下载',
                //     type: 2,
                //     shade: 0.2,
                //     maxmin:true,
                //     shadeClose: true,
                //     area: ['100%', '100%'],
                //     content: 'document/documentDownLoad?id='+ids,   //跳转页面，并携带id参数
                // });
                // $(window).on("resize", function () {
                //     layer.full(index);
                // });
                return false;
            }
        });

    });
</script>

</body>
</html>
