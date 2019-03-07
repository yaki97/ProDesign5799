<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>星级评分插件</title>
    <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
    <style type="text/css">
      div{
      	width: 100%;
      	height: auto;
      	float:left;
      	text-align: center;
      }
      .cell{
      	width:auto;
      	display:table-cell;
      	height:28px;
      	font-size:20px;
      	vertical-align:middle;
      	text-align: center;
      }
      li{
        list-style: none;
      }
      .rating{
        width:300px;
        height:48px;
        display:inline-block
      }
      .rating-item{
        float: left;
        width:47px;
        height:47px;
        background:url(images/icon.png) no-repeat;
        cursor: pointer;
      }
    </style>
</head>
<body>
<p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p><p>&nbsp;</p>
	<div><h3 id="cnameCE"></h3></div>
	<div>
		<span class="cell">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		<span class="cell">评价内容：</span>
		<span class="cell">
			<textarea id="CContent" rows="3" cols="40"></textarea>
		</span>
	</div>
	<div>
		<span class="cell">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		<span class="cell">评价星级：</span>
		<span class="cell">
			 <ul id = "rating" class="rating">
      		 <li class="rating-item" title="很不好"></li>
      		 <li class="rating-item" title="不好"></li>
     		 <li class="rating-item" title="一般"></li>
     		 <li class="rating-item" title="好"></li>
     		 <li class="rating-item" title="很好"></li>
   	   		 </ul>
   		</span>
   	</div>
   	<div>
   	    <button id="baocun"><h4>保存</h4></button><button onclick="CloseDiv('MyDiv','fade')"><h4>取消</h4></button>
	</div>
<input id="TGrade" value="0" style="display: none">
<input id="cid" style="display: none">
<script type="text/javascript" src="js/star2addCE.js"></script>
<script>
//调用方法
//点击后可再选
$('#rating').star({
     mode:'LightEntire', //整颗星
     num:2,
});

$("#baocun").click(function(){
		$.ajax({  
				type: "POST",  
				url: "addCEvaluation.action",  
				data: {"c_id":$("#cid").val(),"CContent":$("#CContent").val(),"TGrade":$("#TGrade").val()},  
				dataType: "json",  
				success: function(data) {
			      	CloseDiv("MyDiv","fade");
			      	objectx.innerHTML="<a href='#' onclick='ShowselDiv("+CIdx+",\""+CNamex+"\")'>查看评价</a>";
			      	setTimeout( function(){
					  alert("评价成功!");
					}, 1 * 1000 );//延迟1000毫米    	
				},  
				error: function() {  
					alert("错误");
				}  
		 });  
		 
})

</script>
</body>
</html>