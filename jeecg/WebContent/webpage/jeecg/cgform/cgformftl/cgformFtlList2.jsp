<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
<div region="center" style="padding: 1px;"><t:datagrid name="cgformFtlList" title="表单模板列表" actionUrl="cgformFtlController.do?datagrid&cgformId=${formid}" idField="id" fit="true">
	<t:dgCol title="编号" field="id" hidden="true"></t:dgCol>
	<t:dgCol title="表单ID" field="cgformId" hidden="true"></t:dgCol>
	<t:dgCol title="模板名称" field="cgformName"></t:dgCol>
	<t:dgCol title="版本号" field="ftlVersion"></t:dgCol>
	<t:dgCol title="激活状态" field="ftlStatus" replace="未激活_0,已激活_1"></t:dgCol>
	<t:dgCol title="word路径" field="ftlWordUrl"></t:dgCol>
	<t:dgCol title="操作" field="opt" width="100"></t:dgCol>
	<t:dgDelOpt title="删除" exp="ftlStatus#eq#0" url="cgformFtlController.do?del&id={id}&formId=${formid}" />
	<t:dgConfOpt title="激活" url="cgformFtlController.do?active&id={id}&formId=${formid}" message="确认激活模板" exp="ftlStatus#eq#0"/>
	<t:dgConfOpt title="取消激活" url="cgformFtlController.do?cancleActive&id={id}&formId=${formid}" message="确认取消激活" exp="ftlStatus#eq#1"/>
	<t:dgToolBar title="Word模板上传" icon="icon-add" funname="add" url="cgformFtlController.do?addorupdate&cgformId=${formid}"></t:dgToolBar>
	<t:dgToolBar title="新建模板" icon="icon-add" funname="add" width="830" url="cgformFtlController.do?addorupdate2&cgformId=${formid}" height="400"></t:dgToolBar>
	<t:dgToolBar title="模板编辑" icon="icon-edit" funname="update" url="cgformFtlController.do?addorupdate2&cgformId=${formid}" width="835" height="500"></t:dgToolBar>
</t:datagrid></div>
</div>
