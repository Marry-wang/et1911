<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>参数传递</title>
	</head>
	<body>
		<form enctype="application/x-www-form-urlencoded"
		action="${pageContext.request.contextPath}/complex/array"
		method="post">
			爱好
			<input type="checkbox" name="hobby" value="踢球">踢球
			<input type="checkbox" name="hobby" value="听歌">听歌
			<input type="checkbox" name="hobby" value="看书">看书
			<input type="checkbox" name="hobby" value="游泳">游泳
			<br>
			<input type="submit" value="提交">
		</form>
		
		<hr >
		
		<form enctype="application/x-www-form-urlencoded"
		action="${pageContext.request.contextPath}/complex/list"
		method="post">
			爱好
			<input type="checkbox" name="hobbyList" value="踢球">踢球
			<input type="checkbox" name="hobbyList" value="听歌">听歌
			<input type="checkbox" name="hobbyList" value="看书">看书
			<input type="checkbox" name="hobbyList" value="游泳">游泳
			<br>
			<input type="submit" value="提交">
		</form>
		
		<hr>
		<button id="testMap" type="button">测试Map传值</button>
		
		<hr>
		<button onclick="jsonToMap()" type="button">测试JsonToMap传值</button>
		
		<hr>
		<button onclick="jsonToList()" type="button">测试JsonToList传值</button>
		
		<hr>
		<button onclick="jsonToBean()" type="button">测试JsonToBean传值</button>
		
		<script 
		src="${pageContext.request.contextPath}/static/js/jquery.min.js"
		type="text/javascript"></script>
		
		<script type="text/javascript">
			const path="${pageContext.request.contextPath}"
			$(function(){
				$('#testMap').click(()=>{
					$.ajax({
						url:path+'/complex/map',
						type:'post',
						dataType:'text',
						data:"stuMap['id']=1&stuMap['name']=zhangsan",
						success:function(data){
							alert(data);
						}
					})
				});
			})
			
			function jsonToMap(){
				let obj ={id:1,name:'et1911'};
				$.ajax({
					url:path+'/json/jsonToMap',
					type:'post',
					data:JSON.stringify(obj),
					dataType:'json',
					contentType:'application/json;charset=UTF-8',
					success:function(data){
						alert(data.msg);
					}
				})
			}
			function jsonToList(){
				let array=[{id:2,name:"et1910",age:20}];
				let user={id:1,name:"et1911",age:20};
				array.push(user);
				$.ajax({
					url:path+'/json/jsonToList',
					type:'post',
					data:JSON.stringify(array),
					dataType:'json',
					contentType:'application/json;charset=UTF-8',
					success:function(data){
						alert(data.msg+":"+data.code);
					}
				})
			}
			function jsonToBean(){
				let obj={id:1,name:"et1911",age:20,
						hobbyList:['看书','踢球'],stuMap:{id:2,score:200}};
				$.ajax({
					url:path+'/json/jsonToBean',
					type:'post',
					data:JSON.stringify(obj),
					dataType:'json',
					contentType:'application/json;charset=UTF-8',
					success:function(data){
						alert(data.core+":"+data.msg);
					}
				})
			}
		</script>
	</body>
</html>