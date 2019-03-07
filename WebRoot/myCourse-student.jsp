<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>我的课程</title>
    <link rel="stylesheet" href="css/default.css">
    <link rel="stylesheet" href="css/main-student.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style type="text/css">
        .black_overlay1{  
 			display: none;  
 			position: absolute;  
 			top: 0%;  
 			left: 0%;  
 			width: 100%;  
 			height: 100%;  
 			z-index:1001;  
 			-moz-opacity: 0.8;  
 			opacity:.80;  
 			filter: alpha(opacity=80);  
		}  
		.white_content1 {  
 			display: none;  
 			position: absolute;  
 			top: 20%;  
 			left: 50%;  
 			width: 400px;  
 			height: 500px;  
 			border: 16px solid lightblue;  
 			background-color: white;  
 			z-index:1002;
 			overflow: auto;  
		}
    	.black_overlay{  
 			display: none;  
 			position: absolute;  
 			top: 0%;  
 			left: 0%;  
 			width: 100%;  
 			height: 100%;  
 			background-color: black;  
 			z-index:1001;  
 			-moz-opacity: 0.8;  
 			opacity:.80;  
 			filter: alpha(opacity=80);  
		}  
		.white_content {  
 			display: none;  
 			position: absolute;  
 			top: 10%;  
 			left: 10%;  
 			width: 80%;  
 			height: 80%;  
 			border: 16px solid lightblue;  
 			background-color: white;  
 			z-index:1002;
 			overflow: auto;  
		}
		/*.white_content_small {  
 			display: none;  
 			position: absolute;  
 			top: 20%;  
 			left: 30%;  
 			width: 40%;  
 			height: 50%;  
 			border: 16px solid lightblue;  
 			background-color: white;  
 			z-index:1002;  
 			overflow: auto;  
		}*/
        .login_manager {
            width: 400px;
            height: 200px;
            background-color: #fff;
            border-radius: 10px;
            position: absolute;
            top: 30%;
            left: 36%;
        }

        #screen {
            width: 100%;
            height: 100%;
            background: #000;
            opacity: 0.3;
            position: fixed;
            top: 0;
        }

        .open-menu a {
            font-size: 13px;
        }

        .nav-btn-box {
            width: 90%;
            margin-left: 60px;
            display: flex;
            flex-direction: row;
            align-items: center;
            justify-content: space-between;
            letter-spacing: 1px;
        }

        .table-box {
            width: 90%;
           
        }

        caption {
            width: 78%;
            font-size: 16px;
            text-align: center;
            font-size: 14px;
            font-weight: bold;
        }

        #course-tab {
            border-collapse: collapse;
            border: 1px #525152 solid;
            width: 60%;
            margin: 0 auto;
        }

        th, td {
            width: 120px;
            border: 1px #525152 solid;
            text-align: center;
            font-size: 12px;
            line-height: 30px;
            background: #f5f5f5;
        }

        th {
            background: #EBB752;
        }

        /*模拟对角线*/
        .out {
            border-top: 60px #EBB752 solid; /*上边框宽度等于表格第一行行高*/
            width: 0px; /*让容器宽度为0*/
            height: 0px; /*让容器高度为0*/
            border-left: 125px #6FB3E0 solid; /*左边框宽度等于表格第一行第一格宽度*/
            position: relative; /*让里面的两个子容器绝对定位*/
        }

        b {
            font-style: normal;
            display: block;
            position: absolute;
            top: -40px;
            left: -40px;
            width: 35px;
        }

        em {
            font-style: normal;
            display: block;
            position: absolute;
            top: -25px;
            left: -70px;
            width: 55px;
        }

        .t1 {
            background: #6FB3E0;
            height: 105px;
        }

        td:not(.t1):hover {
            transform: scale(1.01);
            transition: 0.3s;
            border-radius: 5px;
            box-shadow: 0px 0px 10px 0px rgba(0, 0, 0, 0.5);
        }
    </style>
</head>
<body style="background-color: #F8F8F8;width: 70%;">
<div class="navbar navbar-default navbar-fixed-top" role="navigation" id="top-navbar">
    <!--<div class="container">-->
    <div class="navbar-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#" style="letter-spacing: 1px;color: #fff">
                <small>
                    <span class="glyphicon glyphicon-send"></span> 华信软件学院2015级选课系统
                </small>
            </a>
        </div><!--navbar-header-->
        <ul class="nav navbar-nav navbar-right" style="margin-right: 0px;">
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown" style="padding: 7px;">
                    <img src="images/portrait.png" class="user-portrait" alt="暂无..">
                    <span class="caret" style="color: #fff;"></span>
                </a>
                <ul class="dropdown-menu pull-right" id="user-menu">
                    <li><a href="#"><span class="glyphicon glyphicon-user"></span>个人中心</a></li>
                    <li><a href="#"><span class="glyphicon glyphicon-off"></span>退出登录</a></li>
                </ul>
            </li>
        </ul>
        <ul class="nav navbar-nav navbar-right" id="menu-list">
            <li class="actived"><a href="#"><span class="glyphicon glyphicon-home" id="go_main_page"></span> 首页</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-tasks"></span> 选课中心</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-envelope"></span> 我的消息</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-bullhorn"></span> 联系我们</a></li>
        </ul>

    </div><!--navbar-fluid-->
</div><!--navbar-->
<div style="margin-top: 50px;">
    <div class="container-fluid" style="padding: 0;">
        <div class="row" style="width: 100%;margin-left: 0px;margin-right: 0;">
            <nav class="col-md-2" style="padding-left: 0;padding-right: 0;">
                <ul class="nav nav-pills nav-stacked" style="text-align: center;">
                    <li class="active" style="border-radius: 0;"><a href="#">功能列表</a></li>
                    <li><a href="#">课程中心</a></li>
                    <li class="dropdown">
                        <a href="javascript:open1();">
                            个人中心 <span class="caret"></span>
                        </a>
                        <ul class="nav nav-pills nav-stacked open-menu" id="menu_1" style="text-align: center;">
                            <li><a href="#">基本资料</a></li>
                            <li><a href="#" style="background-color: #eee;">我的课程</a></li>
                        </ul>
                    </li>
                    <li><a href="#">留言反馈</a></li>
                    <li><a href="javascript:login_manager();">登录管理员</a></li>
                </ul>
                <div style="width: 95%;padding: 6px;border: 1px solid #ccc;text-align: center;margin-top: 40px;margin-left: 8px;">
                    <p>咨询QQ：2923471252</p>
                    <p>&nbsp;&nbsp;友情提示：
                        <font color="red">学生登录新教务选课系统的初始账号为个人学号，初始密码为身份证号后6位(若身份证号包含X请注意用大写，若系统中身份证号为空则密码为学号)，该信息同步于学校数字校园信息门户，</font>学生若需更改个人密码需登录【信息门户](http://my.tjut.edu.cn/)进行修改(修改后教务选课系统密码自动同步)。
                    </p>
                    <p>&nbsp;&nbsp;为了更好的保证选课操作的流畅性，请使用IE8及以上版本、Chrome(谷歌)、Firefox(火狐)等浏览器，不建议使用IE6、IE7等老版本浏览器。</p>
                </div>
            </nav>
            <div class="col-md-10 breadcrumbs"
                 style="height:655px;padding-right: 0;padding-left: 0;border: 1px solid #ccc;">
                <ul class="breadcrumb"
                    style="height: 40px;line-height: 23.2px;background-color: #F5F5F5;border-bottom: 1px solid #ccc;">
                    <li>
                        <span class="glyphicon glyphicon-home"></span>
                        <a href="#">首页</a>
                    </li>
                    <li>
                        <a href="#">个人中心</a>
                    </li>
                    <li>
                        <a href="#">我的课程</a>
                    </li>
                    <li class="active" id="bread-last">本学期课程</li>
                </ul><!-- .breadcrumb -->
                <div style="width: 100%;">
                    <div class="nav-btn-box">
                        <a class="btn btn-info" id="goThisCourse" href="#" role="button" disabled>本学期课程</a>
                        <a class="btn btn-info" id="goOtherCourse" href="#" role="button">我的历史课程</a>
                    </div>
                    <div class="table-box" id="thisCourse">
                        <table id="course-tab">
                            <caption>当前学期个人课程表<div>挂科:${sessionScope.FailScore }已申请重修</div></caption> 
                            <tr>
                                <th style="width:80px;">
                                    <div class="out">
                                        <b></b>
                                        <em></em>
                                    </div>
                                </th>
                                <th>周一</th>
                                <th>周二</th>
                                <th>周三</th>
                                <th>周四</th>
                                <th>周五</th>
                            </tr>
                            <tr>
                                <td class="t1">第一节</td>
                                <td id="${sessionScope.pt_c1_1.c_id }">
                                	<P>${sessionScope.pt_c1_1.c_name }<p>
                                	<p>${sessionScope.pt_c1_1.t_name }<p>
                                	<p>${sessionScope.pt_c1_1.c_classroom }<p>
                                </td>
                               <td id="${sessionScope.pt_c1_2.c_id }">
                                	<p>${sessionScope.pt_c1_2.c_name }<p>
                                	<p>${sessionScope.pt_c1_2.t_name }<p>
                                	<p>${sessionScope.pt_c1_2.c_classroom }<p>
                                </td>
                               <td id="${sessionScope.pt_c1_3.c_id }">
                                	<p>${sessionScope.pt_c1_3.c_name }<p>
                                	<p>${sessionScope.pt_c1_3.t_name }<p>
                                	<p>${sessionScope.pt_c1_3.c_classroom }<p>
                                </td>
                                <td id="${sessionScope.pt_c1_4.c_id }">
                                	<p>${sessionScope.pt_c1_4.c_name }<p>
                                	<p>${sessionScope.pt_c1_4.t_name }<p>
                                	<p>${sessionScope.pt_c1_4.c_classroom }<p>
                                </td>
                                <td id="${sessionScope.pt_c1_5.c_id }">
                                	<p>${sessionScope.pt_c1_5.c_name }<p>
                                	<p>${sessionScope.pt_c1_5.t_name }<p>
                                	<p>${sessionScope.pt_c1_5.c_classroom }<p>
                                </td>
                            </tr>
                            <tr>
                                <td class="t1">第二节</td>
                                  <td id="${sessionScope.pt_c2_1.c_id }">
                                	<p>${sessionScope.pt_c2_1.c_name }<p>
                                	<p>${sessionScope.pt_c2_1.t_name }<p>
                                	<p>${sessionScope.pt_c2_1.c_classroom }<p>
                                </td>
                               <td id="${sessionScope.pt_c2_2.c_id }">
                                	<p>${sessionScope.pt_c2_2.c_name }<p>
                                	<p>${sessionScope.pt_c2_2.t_name }<p>
                                	<p>${sessionScope.pt_c2_2.c_classroom }<p>
                                </td>
                              <td id="${sessionScope.pt_c2_3.c_id }">
                                	<p>${sessionScope.pt_c2_3.c_name }<p>
                                	<p>${sessionScope.pt_c2_3.t_name }<p>
                                	<p>${sessionScope.pt_c2_3.c_classroom }<p>
                                </td>
                               <td id="${sessionScope.pt_c2_4.c_id }">
                                	<p>${sessionScope.pt_c2_4.c_name }<p>
                                	<p>${sessionScope.pt_c2_4.t_name }<p>
                                	<p>${sessionScope.pt_c2_4.c_classroom }<p>
                                </td>
                                <td id="${sessionScope.pt_c2_5.c_id }">
                                	<p>${sessionScope.pt_c2_5.c_name }<p>
                                	<p>${sessionScope.pt_c2_5.t_name }<p>
                                	<p>${sessionScope.pt_c2_5.c_classroom }<p>
                                </td>
                            </tr>
                            <tr>
                                <td></td>
                            </tr>
                            <tr>
                                <td class="t1">第三节</td>
                                 <td id="${sessionScope.pt_c3_1.c_id }">
                                	<p>${sessionScope.pt_c3_1.c_name }<p>
                                	<p>${sessionScope.pt_c3_1.t_name }<p>
                                	<p>${sessionScope.pt_c3_1.c_classroom }<p>
                                </td>
                               <td id="${sessionScope.pt_c3_2.c_id }">
                                	<p>${sessionScope.pt_c3_2.c_name }<p>
                                	<p>${sessionScope.pt_c3_2.t_name }<p>
                                	<p>${sessionScope.pt_c3_2.c_classroom }<p>
                                </td>
                              <td id="${sessionScope.pt_c3_3.c_id }">
                                	<p>${sessionScope.pt_c3_3.c_name }<p>
                                	<p>${sessionScope.pt_c3_3.t_name }<p>
                                	<p>${sessionScope.pt_c3_3.c_classroom }<p>
                                </td>
                               <td id="${sessionScope.pt_c3_4.c_id }">
                                	<p>${sessionScope.pt_c3_4.c_name }<p>
                                	<p>${sessionScope.pt_c3_4.t_name }<p>
                                	<p>${sessionScope.pt_c3_4.c_classroom }<p>
                                </td>
                                <td id="${sessionScope.pt_c3_5.c_id }">
                                	<p>${sessionScope.pt_c3_5.c_name }<p>
                                	<p>${sessionScope.pt_c3_5.t_name }<p>
                                	<p>${sessionScope.pt_c3_5.c_classroom }<p>
                                </td>
                            </tr>
                            <tr>
                                <td class="t1">第四节</td>
                                 <td id="${sessionScope.pt_c4_1.c_id }">
                                	<p>${sessionScope.pt_c4_1.c_name }<p>
                                	<p>${sessionScope.pt_c4_1.t_name }<p>
                                	<p>${sessionScope.pt_c4_1.c_classroom }<p>
                                </td>
                               <td id="${sessionScope.pt_c4_2.c_id }">
                                	<p>${sessionScope.pt_c4_2.c_name }<p>
                                	<p>${sessionScope.pt_c4_2.t_name }<p>
                                	<p>${sessionScope.pt_c4_2.c_classroom }<p>
                                </td>
                              <td id="${sessionScope.pt_c4_3.c_id }">
                                	<p>${sessionScope.pt_c4_3.c_name }<p>
                                	<p>${sessionScope.pt_c4_3.t_name }<p>
                                	<p>${sessionScope.pt_c4_3.c_classroom }<p>
                                </td>
                               <td id="${sessionScope.pt_c4_4.c_id }">
                                	<p>${sessionScope.pt_c4_4.c_name }<p>
                                	<p>${sessionScope.pt_c4_4.t_name }<p>
                                	<p>${sessionScope.pt_c4_4.c_classroom }<p>
                                </td>
                                <td id="${sessionScope.pt_c4_5.c_id }">
                                	<p>${sessionScope.pt_c4_5.c_name }<p>
                                	<p>${sessionScope.pt_c4_5.t_name }<p>
                                	<p>${sessionScope.pt_c4_5.c_classroom }<p>
                                </td>
                            </tr>
                        </table>
                       
                    </div>
                    <div class="panel-body" id="otherCourse" style="padding-bottom:0px;" hidden>
                        <div class="panel panel-default">
                            <div class="panel-heading">查询条件</div>
                            <div class="panel-body">
                                <form id="formSearch" class="form-horizontal">
                                    <div class="form-group" style="margin-top:15px">
                                        <label class="control-label col-sm-1"
                                               for="txt_search_departmentname">课程关键字</label>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" id="txt_search_curriculumname">
                                        </div>
                                        <label class="control-label col-sm-1" for="txt_search_semester">学期</label>
                                        <div class="col-sm-3">
                                            <input type="text" class="form-control" id="txt_search_semester">
                                        </div>
                                        <div class="col-sm-4" style="text-align:left;">
                                            <button type="button" style="margin-left:50px" id="btn_query"
                                                    class="btn btn-primary">查询
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </div>
                        <table id="tb_curriculums"></table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="navbar navbar-default navbar-fixed-bottom" role="navigation" id="top-navbar">
    <!--<div class="container">-->
    <div class="navbar-fluid">
        <div class="navbar-header"
             style="width: 100%;text-align: center;padding: 10px 0;color:#fff;letter-spacing: 1px;">
            <p>版权所有 © 天津理工大学 华信软件学院 2015级1班</p>
            <p>技术支持：天津市西青区 联系我们</p>
        </div>
    </div>
</div>
<div id="screen" hidden></div>
<div class="login_manager" hidden>
    <form class="form-horizontal" role="form">
        <div class="form-group" style="margin-top: 20px;">
            <h4 style="text-align: center;margin-bottom: 30px;">管理员登录</h4>
            <label for="pwd" class="col-sm-5 control-label">管理员密码：</label>
            <div class="col-sm-5">
                <input type="password" class="form-control" id="pwd"
                       placeholder="请输入密码">
            </div>
        </div>
        <div class="form-group" style="margin-top: 30px;">
            <div class="col-sm-5 col-sm-offset-4">
                <button type="submit" class="btn btn-info" style="padding-left: 20px;padding-right: 20px;">确认登录</button>
            </div>
        </div>
    </form>
</div>
<!--弹出层时背景层DIV-->  
<div id="fade" class="black_overlay">  
</div>  
<!--立即评价-->  
 <div id="MyDiv" class="white_content">  
  <div style="text-align: center; cursor: default;"> 
   <jsp:include page="addCEvaluation.jsp"></jsp:include>
  </div>  
 </div> 
 <!--弹出层时背景层DIV-->  
<div id="fade2" class="black_overlay">  
</div>  
<!--查看评价-->  
 <div id="MyDiv2" class="white_content">  
  <div style="text-align: center; cursor: default;"> 
   <jsp:include page="selectCEvaluation.jsp"></jsp:include>
  </div>  
 </div>  
  <!--弹出层时背景层DIV-->  
<div id="fade3" class="black_overlay1">  
</div>  
<!--课堂笔记-->  
 <div id="MyDiv3" class="white_content1">  
  <div style="text-align: center; cursor: default;"> 
   <jsp:include page="class-note.jsp"></jsp:include>
  </div>  
 </div>      
</body>
<script src="js/jquery-1.6.3.js"></script>
<script src="js/jquery-3.3.1.min.js"></script>
<script src="js/default.js"></script>
<script src="js/main-student.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/myCourse-student.js"></script>
<script>
	//查询历史选课
	$("#btn_query").click(function(){
		var curriculumname=$("#txt_search_curriculumname").val();
		var semester=$("#txt_search_semester").val();
		  $.ajax({  
				type: "POST",  
				url: "SelectHistoryCourses.action",  
				data: {"curriculumname":curriculumname,"semester":semester},  
				dataType: "json",  
				success: function(data) {	
					$("#tb_curriculums").html("");			
			      	for(var i=0;i<data.historyCourseViews.length;i++){
			      		$("#tb_curriculums").append("<tr><td>课程编号</td><td>课程名</td><td>教师</td><td>学分</td><td>课程类别 </td><td>课程性质</td><td>开课单位(学院)</td><td>上课教室</td><td>学期</td><td>课程评价情况</td></tr>");
			      		$("#tb_curriculums").append("<tr>");
			      		$("#tb_curriculums").append("<td>"+data.historyCourseViews[i].CId+"</td>");
			      		$("#tb_curriculums").append("<td>"+data.historyCourseViews[i].CName+"</td>");
			      		$("#tb_curriculums").append("<td>"+data.historyCourseViews[i].TName+"</td>");
			      		$("#tb_curriculums").append("<td>"+data.historyCourseViews[i].CCredit+"</td>");
			      		$("#tb_curriculums").append("<td>"+data.historyCourseViews[i].CType+"</td>");
			      		$("#tb_curriculums").append("<td>"+data.historyCourseViews[i].CNature+"</td>");
			      		$("#tb_curriculums").append("<td>"+data.historyCourseViews[i].CInstitute+"</td>");
			      		$("#tb_curriculums").append("<td>"+data.historyCourseViews[i].CClassroom+"</td>");
			      		$("#tb_curriculums").append("<td>"+data.historyCourseViews[i].CSemester+"</td>");
			      		if(data.historyCourseViews[i].isPingjia==1){
			      			$("#tb_curriculums").append("<td><a href='#' onclick='ShowselDiv("+data.historyCourseViews[i].CId+",\""+data.historyCourseViews[i].CName+"\")'>查看评价</a></td>");
			      		}else{
			      			$("#tb_curriculums").append("<td><a href='#' onclick='ShowaddDiv("+data.historyCourseViews[i].CId+",\""+data.historyCourseViews[i].CName+"\",this)'>立即评价</a></td>");
			      		}
			      		$("#tb_curriculums").append("</tr>");
			      	}
				},  
				error: function() {  
					alert("错误");
				}  
		 });   
	});
    function login_manager() {
        $("#screen").show(500);
        $(".login_manager").show(500);
    };
    $("#screen").click(function () {
        $(".login_manager").hide(500);
        $("#screen").hide(500);
    });
    function open1() {
        if ($("#menu_1").is(":hidden")) {
            $("#menu_1").show(500);
        } else {
            $("#menu_1").hide(500);
        }
    };
    //定义三个全局变量，用于增加评价后修改立即评价为查看评价
    var objectx;
    var CIdx;
    var CNamex;
    //弹出增加评价隐藏层 
	function ShowaddDiv(cidx,cnamex,object){
		CIdx=cidx;
		CNamex=cnamex;
		objectx=object.parentNode;
		$("#cid").val(cidx);
		$("#cnameCE").html("课程名称:"+cnamex);
 		document.getElementById("MyDiv").style.display='block';  
 		document.getElementById("fade").style.display='block' ;  
 		var bgdiv = document.getElementById("fade");  
 		bgdiv.style.width = document.body.scrollWidth;   
 		// bgdiv.style.height = $(document).height();  
 		$("#fade").height($(document).height());  
	};
	var numXX;
	   //弹出查看评价隐藏层 
	function ShowselDiv(cidx,cnamex,object){
		$.ajax({  
				type: "POST",  
				url: "selectCEvaluation.action",  
				data: {"c_id":cidx},  
				dataType: "json",  
				success: function(data) {
			      	$("#cnameCE2").html("课程名称:"+cnamex);
			      	//遍历读取星星颗数，然后点亮星星
			      	for(var i=0;i<data.cEvaluation.TGrade;i++){			      		
			      		$("#rating2").children().eq(i).css('background-position','-47px 0');
			      	};
			      	//给评价内容框赋值
					$("#CContent2").val(data.cEvaluation.CContent);
 					document.getElementById("MyDiv2").style.display='block';  
 					document.getElementById("fade2").style.display='block' ;  
 					var bgdiv = document.getElementById("fade2");  
 					bgdiv.style.width = document.body.scrollWidth;   
 					// bgdiv.style.height = $(document).height();  
 					$("#fade2").height($(document).height());  
				},  
				error: function() {  
					alert("错误");
				}  
		 });   
		
	};  
	//关闭弹出层 
	function CloseDiv(show_div,bg_div){  
 		document.getElementById(show_div).style.display='none';  
 		document.getElementById(bg_div).style.display='none'; 
 		//星星数目清零
 		$("#rating").children().css('background-position','0 0');
 		$("#rating2").children().css('background-position','0 0');
 		
	}; 
	 //弹出课堂笔记隐藏层 
		function ShownoteDiv(){
	 		document.getElementById("MyDiv3").style.display='block';  
	 		document.getElementById("fade3").style.display='block' ;  
	 		var bgdiv = document.getElementById("fade3");  
	 		bgdiv.style.width = document.body.scrollWidth;   
	 		// bgdiv.style.height = $(document).height();  
	 		$("#fade3").height($(document).height());  
		};	
	//获取course-tab表格的所有td
	$("#course-tab td").click(//
			function(){
				//筛选课表有值项
				if($(this).attr("id")!=0){
					CIdx=$(this).attr("id");
					$.ajax({  
						type: "POST",  
						url: "selectClassNote.action",  
						data: {"CId":$(this).attr("id")},  
						dataType: "json",  
						success: function(data) {
							$("#fontCName").html(data.c_name);
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
				}
				
	})
	
</script>
</html>