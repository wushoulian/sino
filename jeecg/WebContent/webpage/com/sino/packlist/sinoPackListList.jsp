<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,tools,DatePicker"></t:base>
<div class="easyui-layout" fit="true">
  <div region="center" style="padding:1px;">
  <t:datagrid name="sinoPackListList" checkbox="true" title="发货明细" actionUrl="sinoPackListController.do?datagrid" idField="id" fit="true" fitColumns="false" queryMode="group">
   <t:dgCol title="主键"  field="id"  hidden="true"  width="120"></t:dgCol>
   <t:dgCol title="客户"  field="firm"  dictionary="sinofirm"  query="true"  width="120" frozenColumn="true"></t:dgCol>
   <t:dgCol title="目的国"  field="descountry"   query="true"  width="120" frozenColumn="true"></t:dgCol>
   <t:dgCol title="产品"  field="product"   query="true" width="120"  frozenColumn="true"></t:dgCol>
   <t:dgCol title="产品描述"  field="description"   query="true" width="300"></t:dgCol>
   <t:dgCol title="PO单号"  field="po"   query="true" width="120"></t:dgCol>
   <t:dgCol title="SO单号"  field="so"  query="true" width="120"></t:dgCol>
   <t:dgCol title="数量"  field="amount"   width="120"></t:dgCol>
   <t:dgCol title="原出厂时间"  field="plantime" formatter="yyyy-MM-dd"  query="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="现出厂时间"  field="actualtime" formatter="yyyy-MM-dd"  query="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="开船时间"  field="etd" formatter="yyyy-MM-dd"  query="true" queryMode="group"  width="120"></t:dgCol>
   <t:dgCol title="Extend Amount"  field="eamount"    width="120"></t:dgCol>
   <t:dgCol title="Remark"  field="remark"    width="120"></t:dgCol>
   <t:dgCol title="单价"  field="price"    width="120"></t:dgCol>
   <t:dgCol title="备注"  field="remarks"    width="400"></t:dgCol>
   <t:dgCol title="录入时间"  field="time" formatter="yyyy-MM-dd hh:mm:ss"  width="140"></t:dgCol>
   <t:dgCol title="操作" field="opt" width="100"></t:dgCol>
   <t:dgDelOpt title="删除" url="sinoPackListController.do?doDel&id={id}" />
   <t:dgToolBar title="录入" icon="icon-add" url="sinoPackListController.do?goAdd" funname="add" width="900"></t:dgToolBar>
   <t:dgToolBar title="编辑" icon="icon-edit" url="sinoPackListController.do?goUpdate" funname="update" width="900"></t:dgToolBar>
   <t:dgToolBar title="批量删除"  icon="icon-remove" url="sinoPackListController.do?doBatchDel" funname="deleteALLSelect"></t:dgToolBar>
   <t:dgToolBar title="查看" icon="icon-search" url="sinoPackListController.do?goUpdate" width="900" funname="detail"></t:dgToolBar>
   <t:dgToolBar title="导出" icon="icon-putout" funname="ExportXls"></t:dgToolBar>
  </t:datagrid>
  </div>
 </div>
 <!-- <script src = "webpage/com/sino/packlist/sinoPackListList.js"></script>	 -->	
 <script type="text/javascript">
 $(document).ready(function(){
 		//给时间控件加上样式
 			$("#sinoPackListListtb").find("input[name='actualtime_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#sinoPackListListtb").find("input[name='actualtime_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 		    $("#sinoPackListListtb").find("input[name='plantime_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 		    $("#sinoPackListListtb").find("input[name='plantime_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#sinoPackListListtb").find("input[name='etd_begin']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 			$("#sinoPackListListtb").find("input[name='etd_end']").attr("class","Wdate").attr("style","height:20px;width:90px;").click(function(){WdatePicker({dateFmt:'yyyy-MM-dd'});});
 });
 
 </script>