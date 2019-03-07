<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>查看评价</title>
    <script src="js/jquery-1.6.3.js"></script>
    <style type="text/css">
      div{
      	width: 100%;
      	height: auto;
      	float:left;
      	text-align: center;
      }
      .cell{
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
	<div><h3 id="cnameCE2"></h3></div>
	<div>
		<span class="cell">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		<span class="cell">评价内容：
		</span>
		<span class="cell"><textarea id="CContent2" rows="3" cols="40"></textarea></span>
	</div>
	<div>
		<span class="cell">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>
		<span class="cell">评价星级：</span>
		<span class="cell">
		<ul id = "rating2" class="rating">
      		 <li class="rating-item" title="很不好"></li>
      		 <li class="rating-item" title="不好"></li>
     		 <li class="rating-item" title="一般"></li>
     		 <li class="rating-item" title="好"></li>
     		 <li class="rating-item" title="很好"></li>
   	    </ul>
   	    </span>
   	    
   	</div>
   	<div>
   		<button onclick="CloseDiv('MyDiv2','fade2')"><h4>取消</h4></button>
   	</div>
</body>
</html>