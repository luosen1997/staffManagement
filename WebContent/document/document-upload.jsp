<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <base href="${pageContext.request.contextPath}/">
    <title>上传文档</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" href="lib/layui-v2.6.3/css/layui.css" media="all">
    <link rel="stylesheet" href="css/public.css" media="all">
    <style>
        body {
            background-color: #ffffff;
        }
    </style>
</head>
<body>
<form class="layui-form" action="document/documentUpload" enctype="multipart/form-data" method="post">

    <input type="hidden" name="documentPeople" value="${sess_user.username}">
    <div class="layui-form-item">
        <label class="layui-form-label required">文档标题</label>
        <div class="layui-input-inline">
            <input type="text" name="documentTitle" lay-verify="required" lay-reqtext="文档标题不能为空"  value="" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">文档描述</label>
        <div class="layui-input-inline">
            <textarea name="documentRemark" type="text/plain" style="width:99%;height:250px"></textarea>
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">文档</label>
        <div class="layui-input-inline">
        <input type="file" name="docFile" id="file" lay-verify="required"  size="30"/>
        </div>
    </div>


    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="saveBtn">上传</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>
<script src="lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form'], function () {
        var form = layui.form,
            layer = layui.layer,
            $ = layui.$;

        //监听提交
        form.on('submit(saveBtn)', function (data) {


            layer.msg('上传成功',{icon: 1});
           /* var index = layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            }, function () {

                //关闭弹出层
                layer.close(index);

                var iframeIndex = parent.layer.getFrameIndex(window.name);
                parent.layer.close(iframeIndex);

            });*/
            //ajax提交
        //     $.ajax({
        //         type: "POST",
        //         url: "document/documentUpload",
        //         data: data.field,
        //         dataType: "json",
        //         success: function (data) {
        //             if(data.code=="1001"){
        //                 layer.msg('上传成功',{icon: 1},function () {
        //                      location.reload();
        //                     //window.location = 'dept/dept-list.jsp';
        //                 });
        //             }else{
        //                 layer.msg('上传失败',{icon: 2})
        //             }
        //         },
        //         error:function () {
        //             layer.msg("系统异常",{icon: 2})
        //         }
        //     });
        //     return false;
         });

    });
</script>
</body>
</html>
