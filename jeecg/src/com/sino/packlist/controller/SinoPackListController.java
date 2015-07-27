package com.sino.packlist.controller;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.sino.packlist.entity.SinoPackListEntity;
import com.sino.packlist.service.SinoPackListServiceI;



/**   
 * @Title: Controller
 * @Description: 预计发货明细
 * @author onlineGenerator
 * @date 2015-06-11 11:34:41
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/sinoPackListController")
public class SinoPackListController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SinoPackListController.class);

	@Autowired
	private SinoPackListServiceI sinoPackListService;
	@Autowired
	private SystemService systemService;
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * 预计发货明细列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "sinoPackList")
	public ModelAndView sinoPackList(HttpServletRequest request) {
		return new ModelAndView("com/sino/packlist/sinoPackListList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(SinoPackListEntity sinoPackList,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		
		String descountry = sinoPackList.getDescountry();
		String product = sinoPackList.getProduct();
		String description = sinoPackList.getDescription();
		String po = sinoPackList.getPo();
		String so = sinoPackList.getSo();
		sinoPackList.setDescountry(null);
		sinoPackList.setProduct(null);
		sinoPackList.setDescription(null);
		sinoPackList.setPo(null);
		sinoPackList.setSo(null);
		
		CriteriaQuery cq = new CriteriaQuery(SinoPackListEntity.class, dataGrid);
		//查询条件组装器
		HqlGenerateUtil.installHql(cq, sinoPackList, request.getParameterMap());
		try{
		//自定义追加查询条件
			if(null != descountry && !descountry.equals(""))
			{
				cq.like("descountry", "%"+descountry+"%");
			}
			
			if(null != product && !product.equals(""))
			{
				cq.like("product", "%"+product+"%");
			}
			
			if(null != description && !description.equals(""))
			{
				cq.like("description", "%"+description+"%");
			}
			
			if(null != po && !po.equals(""))
			{
				cq.like("po", "%"+po+"%");
			}
			
			if(null != so && !so.equals(""))
			{
				cq.like("so", "%"+so+"%");
			}
			
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.sinoPackListService.getDataGridReturn(cq, true);
		
		
		dataGrid.getResults();
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除预计发货明细
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(SinoPackListEntity sinoPackList, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		sinoPackList = systemService.getEntity(SinoPackListEntity.class, sinoPackList.getId());
		message = "预计发货明细删除成功";
		try{
			sinoPackListService.delete(sinoPackList);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "预计发货明细删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除预计发货明细
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "预计发货明细删除成功";
		try{
			for(String id:ids.split(",")){
				SinoPackListEntity sinoPackList = systemService.getEntity(SinoPackListEntity.class, 
				id
				);
				sinoPackListService.delete(sinoPackList);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "预计发货明细删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加预计发货明细
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(SinoPackListEntity sinoPackList, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "预计发货明细添加成功";
		try{
			sinoPackList.setTime(new Date());
			sinoPackListService.save(sinoPackList);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "预计发货明细添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新预计发货明细
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(SinoPackListEntity sinoPackList, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "预计发货明细更新成功";
		SinoPackListEntity t = sinoPackListService.get(SinoPackListEntity.class, sinoPackList.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(sinoPackList, t);
			sinoPackListService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "预计发货明细更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 预计发货明细新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(SinoPackListEntity sinoPackList, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(sinoPackList.getId())) {
			sinoPackList = sinoPackListService.getEntity(SinoPackListEntity.class, sinoPackList.getId());
			req.setAttribute("sinoPackListPage", sinoPackList);
		}
		return new ModelAndView("com/sino/packlist/sinoPackList-add");
	}
	/**
	 * 预计发货明细编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(SinoPackListEntity sinoPackList, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(sinoPackList.getId())) {
			sinoPackList = sinoPackListService.getEntity(SinoPackListEntity.class, sinoPackList.getId());
			req.setAttribute("sinoPackListPage", sinoPackList);
		}
		return new ModelAndView("com/sino/packlist/sinoPackList-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		return new ModelAndView("com/sino/packlist/sinoPackListUpload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(SinoPackListEntity sinoPackList,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(SinoPackListEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, sinoPackList, request.getParameterMap());
		List<SinoPackListEntity> sinoPackLists = this.sinoPackListService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"预计发货明细");
		modelMap.put(NormalExcelConstants.CLASS,SinoPackListEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("预计发货明细列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,sinoPackLists);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(SinoPackListEntity sinoPackList,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "预计发货明细");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,SinoPackListEntity.class);
		modelMap.put(TemplateExcelConstants.LIST_DATA,null);
		return TemplateExcelConstants.JEECG_TEMPLATE_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<SinoPackListEntity> listSinoPackListEntitys = ExcelImportUtil.importExcelByIs(file.getInputStream(),SinoPackListEntity.class,params);
				for (SinoPackListEntity sinoPackList : listSinoPackListEntitys) {
					sinoPackListService.save(sinoPackList);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
}
