<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <base href="${pageContext.request.contextPath}/">
    <title>编辑部门</title>
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
<div class="layui-form layuimini-form">

    <input type="hidden" name="id" value="${dept.id }">
    <div class="layui-form-item">
        <label class="layui-form-label required">部门名称</label>
        <div class="layui-input-inline">
            <input type="text" name="deptname" lay-verify="required" lay-reqtext="部门名称不能为空" placeholder="请输入部门名称" value="${dept.deptname }" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">详细描述</label>
        <div class="layui-input-inline">
            <input type="text" name="deptremark" lay-verify="required" lay-reqtext="详细描述不能为空" placeholder="请输入详细描述" value="${dept.deptremark }" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
       <label class="layui-form-label"></label>
        <div class="layui-input-inline">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认修改</button>
        </div>
    </div>
</div>
<script src="lib/layui-v2.6.3/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form'], function () {
        var form = layui.form,
            layer = layui.layer,
            $ = layui.$;

        //监听提交
        form.on('submit(saveBtn)', function (data) {
            
            $.ajax({
				type : "POST",
				url : "dept/deptUpdate",
				data : data.field, //{loginname:"",password:""}
                dataType: "json",
				success : function(data) {
					if(data.code=="1001"){
						layer.msg('修改成功', {icon: 1},function(){
							// 修改成功，关闭弹出层
							var iframeIndex = parent.layer.getFrameIndex(window.name);
			                parent.location.reload();//刷新父页面
							parent.layer.close(iframeIndex);
						});
					}else{
						layer.msg('修改失败', {icon: 2});
					}			
				},
				error: function(){
					layer.msg('系统异常', {icon: 2});
				}
			}); 
            

            return false;
        });

    });
</script>
</body>
</html>