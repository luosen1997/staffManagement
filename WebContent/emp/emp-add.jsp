<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <base href="${pageContext.request.contextPath}/">
    <title>添加员工</title>
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
    <div class="layui-form-item">
        <label class="layui-form-label required">员工姓名</label>
        <div class="layui-input-inline">
            <input type="text" name="empname" lay-verify="required" lay-reqtext="姓名不能为空" placeholder="请输入姓名" value="" class="layui-input">
        </div>

        <label class="layui-form-label required">身份证号码</label>
        <div class="layui-input-inline">
            <input type="text" name="cardid" lay-verify="required" lay-reqtext="身份证号码不能为空" placeholder="请输入身份证号码" value="" class="layui-input">
        </div>

    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">性别</label>
        <div class="layui-input-inline">
            <select name="empsex">
            <option value="">--请选择性别--</option>
                <option value="1">男</option>
                <option value="2">女</option>
            </select>
        </div>
        <label class="layui-form-label required">职位</label>
        <div class="layui-input-inline">
            <select name="jobid">
            <option value="">--请选择职位--</option>
                <c:forEach items="${jobs }" var="job">
                    <option value="${job.id }">${job.jobname }</option>
                </c:forEach>
            </select>
        </div>

    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">学历</label>
        <div class="layui-input-inline">
            <input type="text" name="empedu"  lay-reqtext="学历不能为空" placeholder="请输入学历" value="" class="layui-input">
        </div>

        <label class="layui-form-label required">邮箱</label>
        <div class="layui-input-inline">
            <input type="text" name="empemail"  lay-reqtext="邮箱不能为空" placeholder="请输入邮箱" value="" class="layui-input">
        </div>

    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">手机号码</label>
        <div class="layui-input-inline">
            <input type="text" name="empphone"  lay-reqtext="手机号码不能为空" placeholder="请输入手机号码" value="" class="layui-input">
        </div>
        <label class="layui-form-label required">电话号码</label>
        <div class="layui-input-inline">
            <input type="text" name="emptel"  lay-reqtext="电话电话不能为空" placeholder="请输入电话号码" value="" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
    <label class="layui-form-label required">政治面貌</label>
    <div class="layui-input-inline">
        <input type="text" name="empparty"  lay-reqtext="政治面貌不能为空" placeholder="请输入政治面貌" value="" class="layui-input">
    </div>
    <label class="layui-form-label required">QQ号</label>
    <div class="layui-input-inline">
        <input type="text" name="qqnum"  lay-reqtext="qq号码不能为空" placeholder="请输入QQ号" value="" class="layui-input">
    </div>
  </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">联系地址</label>
        <div class="layui-input-inline">
            <input type="text" name="empaddress" lay-reqtext="联系地址不能为空" placeholder="请输入联系地址" value="" class="layui-input">
        </div>
        <label class="layui-form-label required">邮政编码</label>
        <div class="layui-input-inline">
            <input type="text" name="postcode"  lay-reqtext="邮政编码不能为空" placeholder="请输入邮政编码" value="" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">出生日期</label>
        <div class="layui-input-inline">
            <input type="text" name="empbirthday"  lay-reqtext="出生日期不能为空" placeholder="格式为××××/××/××" value="" class="layui-input">
        </div>
        <label class="layui-form-label required">民族</label>
        <div class="layui-input-inline">
            <input type="text" name="emprace"  lay-reqtext="民族不能为空" placeholder="请输入民族" value="" class="layui-input">
        </div>
    </div>
    
    <div class="layui-form-item">
        <label class="layui-form-label required">所学专业</label>
        <div class="layui-input-inline">
            <input type="text" name="empmajor"  lay-reqtext="所学专业不能为空" placeholder="请输入所学专业" value="" class="layui-input">
        </div>
        <label class="layui-form-label required">爱好</label>
        <div class="layui-input-inline">
            <input type="text" name="emphobby"  lay-reqtext="爱好不能为空" placeholder="请输入爱好" value="" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <label class="layui-form-label required">备注</label>
        <div class="layui-input-inline">
            <input type="text" name="empremark"  lay-reqtext="备注不能为空" placeholder="请输入备注" value="" class="layui-input">
    	</div>
        <label class="layui-form-label required">所属部门</label>
        	<div class="layui-input-inline">
                <select name="deptid">
                <option value="">--请选择部门--</option>
                    <c:forEach items="${depts }" var="dept">
                        <option value="${dept.id }">${dept.deptname }</option>
                    </c:forEach>
                </select>
            </div>
	</div>
	
	<div class="layui-form-item">
        <label class="layui-form-label"></label>
        <div class="layui-input-inline">
            <button class="layui-btn layui-btn-normal" lay-submit lay-filter="saveBtn">确认新增</button>
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
           /* var index = layer.alert(JSON.stringify(data.field), {
                title: '最终的提交信息'
            }, function () {

                //关闭弹出层
                layer.close(index);

                var iframeIndex = parent.layer.getFrameIndex(window.name);
                parent.layer.close(iframeIndex);

            });*/
            //ajax提交
            $.ajax({
                type: "POST",
                url: "emp/empAdd",
                data: data.field,
                dataType: "json",
                success: function (data) {
                    if(data.code=="1001"){
                        layer.msg('新增成功',{icon: 1},function () {
                             location.reload();
                            //window.location = 'user/user-list.jsp';
                           // location.reload();//刷新页面
                        });
                    }else{
                        layer.msg('新增失败',{icon: 2})
                    }
                },
                error:function () {
                    layer.msg("系统异常",{icon: 2})
                }
            });
            return false;
        });

    });
</script>
</body>
</html>
