<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>课堂笔记</title>
	<style type="text/css">
	div{
		float: left;
		width: 100%;
	}
	</style>
  </head>
  
  <body>
    <div>
    	<div>
    		<span style="display:table-cell;height:28px;font-size:20px;vertical-align:middle;"><input type="image" src="images/add.png" onclick="addClassNote()"></span>
    		<span style="display:table-cell;height:28px;font-size:20px;vertical-align:middle;">&nbsp;&nbsp;</span>
    		<span style="display:table-cell;height:28px;font-size:20px;vertical-align:middle;">课堂笔记<font id="fontCName" color="red" size="16px"></font> </span>	
    		<span style="display:table-cell;height:28px;font-size:20px;vertical-align:middle;">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
    		<span style="display:table-cell;height:28px;font-size:20px;vertical-align:middle;"><input type="image" src="images/exit.png" onclick="CloseDiv('MyDiv3','fade3')"></span>
    	</div>
    	<div id="class-note">
    		
    	</div>
    </div>
  </body>
  <script type="text/javascript">
  	function addClassNote(){
  		$.ajax({  
			type: "POST",  
			url: "addClassNote.action",  
			data: {"CId":CIdx},  //CIdx是自定义全局变量
			dataType: "json",  
			success: function(data) {
				$.ajax({  
					type: "POST",  
					url: "selectClassNote.action",  
					data: {"CId":CIdx},  
					dataType: "json",  
					success: function(data) {
						$("#class-note").html("");	
				      	for(var i=0;i<data.classNotes.length;i++){
				      		$("#class-note").append("<div>");
				      		$("#class-note").append("<span style='display:table-cell;height:28px;vertical-align:middle;'><input type='image' src='images/delet.png' onclick='deleteClassNote("+data.classNotes[i].noId+")'></span>");
				      		$("#class-note").append("<span style='display:table-cell;height:28px;vertical-align:middle;'><input type='button' value='保存' onclick='updateClassNote("+data.classNotes[i].noId+",this)'></span>");
				      		$("#class-note").append("<span style='display:table-cell;height:28px;vertical-align:middle;'>&nbsp;</span>");
				      		$("#class-note").append("<span style='display:table-cell;height:28px;vertical-align:middle;'><input type='text' value='"+data.classNotes[i].noContent+"'></span>");
				      		$("#class-note").append("<span style='display:table-cell;height:28px;vertical-align:middle;'>"+data.classNotes[i].noDate+"</span>");
				      		$("#class-note").append("</div>");
				      	}
				      	ShownoteDiv();
				      	
					},  
					error: function() {  
						alert("错误");
					}  
			 });  
			},  
			error: function() {  
				alert("错误");
			}  
	 });   

  	}
  	function deleteClassNote(noid){
  		$.ajax({  
			type: "POST",  
			url: "deleteClassNote.action",  
			data: {"noId":noid},  
			dataType: "json",  
			success: function(data) {
				$.ajax({  
					type: "POST",  
					url: "selectClassNote.action",  
					data: {"CId":CIdx},  
					dataType: "json",  
					success: function(data) {
						$("#class-note").html("");	
				      	for(var i=0;i<data.classNotes.length;i++){
				      		$("#class-note").append("<div>");
				      		$("#class-note").append("<span style='display:table-cell;height:28px;vertical-align:middle;'><input type='image' src='images/delet.png' onclick='deleteClassNote("+data.classNotes[i].noId+")'></span>");
				      		$("#class-note").append("<span style='display:table-cell;height:28px;vertical-align:middle;'><input type='button' value='保存' onclick='updateClassNote("+data.classNotes[i].noId+",this)'></span>");
				      		$("#class-note").append("<span style='display:table-cell;height:28px;vertical-align:middle;'>&nbsp;</span>");
				      		$("#class-note").append("<span style='display:table-cell;height:28px;vertical-align:middle;'><input type='text' value='"+data.classNotes[i].noContent+"'></span>");
				      		$("#class-note").append("<span style='display:table-cell;height:28px;vertical-align:middle;'>"+data.classNotes[i].noDate+"</span>");
				      		$("#class-note").append("</div>");
				      	}
				      	ShownoteDiv();
				      	
					},  
					error: function() {  
						alert("错误");
					}  
			 });  
			},  
			error: function() {  
				alert("错误");
			}  
	 });   	
  	}
  	function updateClassNote(noid,obj){
  		//获取文本笔记内容
  		//alert(obj.parentNode.nextSibling.nextSibling.children[0].value);
  		$.ajax({  
			type: "POST",  
			url: "updateClassNote.action",  
			data: {"noId":noid,"noContent":obj.parentNode.nextSibling.nextSibling.children[0].value},  
			dataType: "json",  
			success: function(data) {
				$.ajax({  
					type: "POST",  
					url: "selectClassNote.action",  
					data: {"CId":CIdx},  
					dataType: "json",  
					success: function(data) {
						$("#class-note").html("");	
				      	for(var i=0;i<data.classNotes.length;i++){
				      		$("#class-note").append("<div>");
				      		$("#class-note").append("<span style='display:table-cell;height:28px;vertical-align:middle;'><input type='image' src='images/delet.png' onclick='deleteClassNote("+data.classNotes[i].noId+")'></span>");
				      		$("#class-note").append("<span style='display:table-cell;height:28px;vertical-align:middle;'><input type='button' value='保存' onclick='updateClassNote("+data.classNotes[i].noId+",this)'></span>");
				      		$("#class-note").append("<span style='display:table-cell;height:28px;vertical-align:middle;'>&nbsp;</span>");
				      		$("#class-note").append("<span style='display:table-cell;height:28px;vertical-align:middle;'><input type='text' value='"+data.classNotes[i].noContent+"'></span>");
				      		$("#class-note").append("<span style='display:table-cell;height:28px;vertical-align:middle;'>"+data.classNotes[i].noDate+"</span>");
				      		$("#class-note").append("</div>");
				      	}
				      	ShownoteDiv();
				      	
					},  
					error: function() {  
						alert("错误");
					}  
			 });  
			},  
			error: function() {  
				alert("错误");
			}  
	 });   	
  	}
  </script>
</html>
