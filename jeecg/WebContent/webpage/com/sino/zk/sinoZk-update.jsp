<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>考勤数据</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="sinoZkController.do?doUpdate" tiptype="1">
					<input id="id" name="id" type="hidden" value="${sinoZkPage.id }">
					<input id="number" name="number" type="hidden" value="${sinoZkPage.number }">
					<input id="name" name="name" type="hidden" value="${sinoZkPage.name }">
					<input id="dtime" name="dtime" type="hidden" value="${sinoZkPage.dtime }">
					<input id="dyear" name="dyear" type="hidden" value="${sinoZkPage.dyear }">
					<input id="dmonth" name="dmonth" type="hidden" value="${sinoZkPage.dmonth }">
					<input id="dday" name="dday" type="hidden" value="${sinoZkPage.dday }">
					<input id="dhour" name="dhour" type="hidden" value="${sinoZkPage.dhour }">
					<input id="dminute" name="dminute" type="hidden" value="${sinoZkPage.dminute }">
					<input id="dsecond" name="dsecond" type="hidden" value="${sinoZkPage.dsecond }">
					<input id="ip" name="ip" type="hidden" value="${sinoZkPage.ip }">
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/sino/zk/sinoZk.js"></script>		