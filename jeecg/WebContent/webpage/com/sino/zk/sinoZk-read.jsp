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
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="sinoZkController.do?doReader">
		
		<table style="width: 600px;" cellpadding="0" cellspacing="1" class="formtable">
		 <tr>
		  	 <td align="right">
				<label class="Validform_label">
					卡钟IP:
				</label>
			 </td>
			 <td class="value">
			    <input id="ip" name="ip">
			 </td>
		   </tr>
		 </table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/sino/zk/sinoZk.js"></script>		