<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <base href="${pageContext.request.contextPath}/">
    <title>员工管理</title>
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
                            <label class="layui-form-label">职位</label>
                            <div class="layui-input-inline">
                            	<select name="jobid">
                                	<option value="">--请选择职位--</option>
					    			<c:forEach items="${jobs }" var="job">
                                    	<option value="${job.id }">${job.jobname }</option>
                                	</c:forEach>
                                </select>
                            </div>
                        </div>
                         <div class="layui-inline">
                            <label class="layui-form-label">员工姓名</label>
                            <div class="layui-input-inline">
                            	<input type="text" name="empname" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">身份证号码</label>
                            <div class="layui-input-inline">
                            	<input type="text" name="cardid" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">性别</label>
                            <div class="layui-input-inline">
                                <select name="empsex">
                                	<option value="">--请选择性别--</option>
                                	<option value="1">男</option>
                                	<option value="2">女</option>
                                </select>
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">手机号</label>
                            <div class="layui-input-inline">
                            	<input type="text" name="empphone" autocomplete="off" class="layui-input">
                            </div>
                        </div>
                        <div class="layui-inline">
                            <label class="layui-form-label">所属部门</label>
                            <div class="layui-input-inline">
                            	<select  name="deptid">
								   <option value="">--请选择部门--</option>
								   	<c:forEach items="${depts }" var="dept">
					    				<option value="${dept.id }">${dept.deptname }</option>
					    			</c:forEach>
								</select>
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

        <table class="layui-hide" id="currentTableId" lay-filter="currentTableFilter"></table>

        <script type="text/html" id="currentTableBar">
            <a class="layui-btn layui-btn-normal layui-btn-xs data-count-edit" lay-event="edit">编辑</a>
            <a class="layui-btn layui-btn-xs layui-btn-danger data-count-delete" lay-event="delete">删除</a>
        </script>

    </div>
</div>
<script src="lib/layui-v2.6.3/layui.js" charset="utf-8"></script>

<script type="text/html" id="empsexTpl">
  {{#  if(d.empsex == 1){ }}
  	男
  {{#  } else { }}
    女
  {{#  } }}
</script>

<script type="text/html" id="jobidTpl">
<c:forEach items="${jobs }" var="job">
  {{#  if(d.jobid == ${job.id }){ }}
  	${job.jobname}
  {{#  }}}
</c:forEach>
</script>

<script type="text/html" id="deptidTpl">
<c:forEach items="${depts }" var="dept">
  {{#  if(d.deptid == ${dept.id }){ }}
  	${dept.deptname}
  {{#  }}}
</c:forEach>
</script>

<script>
    layui.use(['form', 'table'], function () {
        var $ = layui.jquery,
            form = layui.form,
            table = layui.table;

        table.render({
            elem: '#currentTableId',
            url: 'emp/getEmpList',
            toolbar: '#toolbarDemo',
            defaultToolbar: ['filter', 'exports', 'print', {
                title: '提示',
                layEvent: 'LAYTABLE_TIPS',
                icon: 'layui-icon-tips'
            }],
            cols: [[
                {type: "checkbox", width: 50},
                {field: 'empname', width: 90, title: '姓名'},
                {field: 'empsex', width: 60, title: '性别', templet: '#empsexTpl'},
                {field: 'empphone', width: 120, title: '手机号码'},
                {field: 'jobid', width: 80, title: '职位', templet: '#jobidTpl'},
                {field: 'empedu', width: 80, title: '学历'},
                {field: 'cardid', width: 120, title: '身份证号码'},
                {field: 'deptid', width: 80, title: '部门', templet: '#deptidTpl'},
                {field: 'empaddress', width: 150, title: '联系地址'},
                {field: 'createdate', width: 140, title: '建档日期'},
                {title: '操作', minWidth: 150, toolbar: '#currentTableBar', align: "center"}
            ]],
            limits: [10, 15, 20, 25, 50, 100],
            limit: 10,
            page: true,
            skin: 'line'
        });

        // 监听搜索操作
        form.on('submit(data-search-btn)', function (data) {
            var result = JSON.stringify(data.field);
            /* layer.alert(result, {
                title: '最终的搜索信息'
            }); */

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
                    title: '添加用户',
                    type: 2,
                    shade: 0.2,
                    maxmin:true,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: 'page/table/add.html',
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
            } else if (obj.event === 'delete') {  // 监听删除操作
                var checkStatus = table.checkStatus('currentTableId')
                    , data = checkStatus.data;
                //layer.alert(JSON.stringify(data));
                var ids = $.map(data,function(obj){  //[1,3,5]
                	return obj.id;
                });
                
                $.ajax({
    				type : "POST",
    				url : "emp/empDelete",
    				data : {"ids" : ids.join(",")}, //1,3,5
                    dataType: "json",
    				success : function(data) {
    					if(data.code=="1001"){
    						layer.msg('删除成功', {icon: 1},function(){
    							location.reload();
    						});
    					}else{
    						layer.msg('删除失败', {icon: 2});
    					}			
    				},
    				error: function(){
    					layer.msg('系统异常', {icon: 2});
    				}
    			}); 
                
        
                
                
            }
        });

        //监听表格复选框选择
        table.on('checkbox(currentTableFilter)', function (obj) {
            console.log(obj)
        });

        table.on('tool(currentTableFilter)', function (obj) {
            var data = obj.data;
            if (obj.event === 'edit') {

                var index = layer.open({
                    title: '编辑用户',
                    type: 2,
                    shade: 0.2,
                    maxmin:true,
                    shadeClose: true,
                    area: ['100%', '100%'],
                    content: 'emp/showEmp?id='+data.id,
                });
                $(window).on("resize", function () {
                    layer.full(index);
                });
                return false;
            } else if (obj.event === 'delete') {
                layer.confirm('真的删除行么', function (index) {
                    obj.del();
                    layer.close(index);
                });
            }
        });

    });
</script>

</body>
</html>