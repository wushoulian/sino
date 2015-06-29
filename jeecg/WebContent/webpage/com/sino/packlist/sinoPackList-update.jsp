<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<!DOCTYPE html>
<html>
 <head>
  <title>预计发货明细</title>
  <t:base type="jquery,easyui,tools,DatePicker"></t:base>
  <script type="text/javascript" src="plug-in/ckeditor_new/ckeditor.js"></script>
  <script type="text/javascript" src="plug-in/ckfinder/ckfinder.js"></script>
  <script type="text/javascript">
  //编写自定义JS代码
  </script>
 </head>
 <body>
  <t:formvalid formid="formobj" dialog="true" usePlugin="password" layout="table" action="sinoPackListController.do?doUpdate" >
					<input id="id" name="id" type="hidden" value="${sinoPackListPage.id }">
					<input id="time" name="time" type="hidden" value="${sinoPackListPage.time }">
		<table style="width: 860px;" cellpadding="0" cellspacing="1" class="formtable">
					<tr>
						<td align="right">
							<label class="Validform_label">
								客户:
							</label>
						</td>
						<td class="value">
									<t:dictSelect field="firm" type="list"
										typeGroupCode="sinofirm" defaultVal="${sinoPackListPage.firm}" hasLabel="false"  title="客户"></t:dictSelect>     
							<span class="Validform_checktip"></span>
						</td>
						<td align="right">
							<label class="Validform_label">
								目的国:
							</label>
						</td>
						<td class="value">
						     	 <input id="descountry" name="descountry" type="text" style="width: 200px" class="inputxt"  
									               
									                 value='${sinoPackListPage.descountry}'>
							<span class="Validform_checktip"></span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								产品:
							</label>
						</td>
						<td class="value">
						     	 <input id="product" name="product" type="text" style="width: 200px" class="inputxt"  
									               
									                 value='${sinoPackListPage.product}'>
							<span class="Validform_checktip"></span>
						</td>
						<td align="right">
							<label class="Validform_label">
								产品描述:
							</label>
						</td>
						<td class="value">
						     	 <input id="description" name="description" type="text" style="width: 200px" class="inputxt"  
									               
									                 value='${sinoPackListPage.description}'>
							<span class="Validform_checktip"></span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								PO单号:
							</label>
						</td>
						<td class="value">
						     	 <input id="po" name="po" type="text" style="width: 200px" class="inputxt"  
									               
									                 value='${sinoPackListPage.po}'>
							<span class="Validform_checktip"></span>
						</td>
						<td align="right">
							<label class="Validform_label">
								SO单号:
							</label>
						</td>
						<td class="value">
									  <input id="so" name="so" type="text" style="width: 200px" class="inputxt" 
									                
						      						 value='${sinoPackListPage.so}'>    
							<span class="Validform_checktip"></span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								数量:
							</label>
						</td>
						<td class="value">
						     	 <input id="amount" name="amount" type="text" style="width: 200px" class="inputxt"  
									               
									                 value='${sinoPackListPage.amount}' datatype="n" errormsg="格式不正确!" ignore="ignore">
							<span class="Validform_checktip">数字格式</span>
						</td>
						<td align="right">
							<label class="Validform_label">
								原出厂时间:
							</label>
						</td>
						<td class="value">
									  <input id="plantime" name="plantime" type="text" style="width: 200px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${sinoPackListPage.plantime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								现出厂时间:
							</label>
						</td>
						<td class="value">
									  <input id="actualtime" name="actualtime" type="text" style="width: 200px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${sinoPackListPage.actualtime}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
						</td>
						<td align="right">
							<label class="Validform_label">
								开船时间:
							</label>
						</td>
						<td class="value">
									  <input id="etd" name="etd" type="text" style="width: 200px" 
						      						class="Wdate" onClick="WdatePicker()"
									                
						      						 value='<fmt:formatDate value='${sinoPackListPage.etd}' type="date" pattern="yyyy-MM-dd"/>'>    
							<span class="Validform_checktip"></span>
						</td>
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								Extend Amount:
							</label>
						</td>
						<td class="value">
						     	 <input id="eamount" name="eamount" type="text" style="width: 200px" class="inputxt"  
									               
									                 value='${sinoPackListPage.eamount}' datatype="d" errormsg="格式不正确!" ignore="ignore">
							<span class="Validform_checktip">数字格式</span>
						</td>
						<td align="right">
							<label class="Validform_label">
								单价:
							</label>
						</td>
						<td class="value">
						     	 <input id="price" name="price" type="text" style="width: 200px" class="inputxt"  
									               
									                 value='${sinoPackListPage.price}' datatype="d" errormsg="格式不正确!" ignore="ignore"> 
							<span class="Validform_checktip">数字格式</span>
						</td>
						
					</tr>
					<tr>
						<td align="right">
							<label class="Validform_label">
								Remark:
							</label>
						</td>
						<td class="value">
						     	 <input id="remark" name="remark" type="text" style="width: 200px" class="inputxt"  
									               
									                 value='${sinoPackListPage.remark}'>
							<span class="Validform_checktip"></span>
						</td>
						<td align="right">
							<label class="Validform_label">
								备注:
							</label>
						</td>
						<td class="value">
						  	 	<textarea id="remarks" style="width:200px;" class="inputxt" rows="3" name="remarks">${sinoPackListPage.remarks}</textarea>
							<span class="Validform_checktip"></span>
						</td>
					</tr>
			</table>
		</t:formvalid>
 </body>
  <script src = "webpage/com/sino/packlist/sinoPackList.js"></script>		