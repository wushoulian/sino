package com.sino.zk.controller;
import java.io.IOException;
import java.text.SimpleDateFormat;
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

import com.sino.zk.entity.SinoZkEntity;
import com.sino.zk.service.SinoZkServiceI;



/**   
 * @Title: Controller
 * @Description: 考勤数据
 * @author onlineGenerator
 * @date 2015-06-24 09:57:12
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/sinoZkController")
public class SinoZkController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(SinoZkController.class);

	@Autowired
	private SinoZkServiceI sinoZkService;
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
	 * 考勤数据列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "sinoZk")
	public ModelAndView sinoZk(HttpServletRequest request) {
		return new ModelAndView("com/sino/zk/sinoZkList");
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
	public void datagrid(SinoZkEntity sinoZk,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(SinoZkEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, sinoZk, request.getParameterMap());
		try{
		//自定义追加查询条件
		String query_dtime_begin = request.getParameter("dtime_begin");
		String query_dtime_end = request.getParameter("dtime_end");
		if(StringUtil.isNotEmpty(query_dtime_begin)){
			cq.ge("dtime", new SimpleDateFormat("yyyy-MM-dd").parse(query_dtime_begin));
		}
		if(StringUtil.isNotEmpty(query_dtime_end)){
			cq.le("dtime", new SimpleDateFormat("yyyy-MM-dd").parse(query_dtime_end));
		}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.sinoZkService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除考勤数据
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(SinoZkEntity sinoZk, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		sinoZk = systemService.getEntity(SinoZkEntity.class, sinoZk.getId());
		message = "考勤数据删除成功";
		try{
			sinoZkService.delete(sinoZk);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "考勤数据删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除考勤数据
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "考勤数据删除成功";
		try{
			for(String id:ids.split(",")){
				SinoZkEntity sinoZk = systemService.getEntity(SinoZkEntity.class, 
				id
				);
				sinoZkService.delete(sinoZk);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "考勤数据删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加考勤数据
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(SinoZkEntity sinoZk, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "考勤数据添加成功";
		try{
			sinoZkService.save(sinoZk);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "考勤数据添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 读取考勤数据
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "goReader")
	public ModelAndView goReader(SinoZkEntity sinoZk, HttpServletRequest req) {
		sinoZk = new SinoZkEntity();
		req.setAttribute("sinoZkPage", sinoZk);
		return new ModelAndView("com/sino/zk/sinoZk-read");
	}
	@RequestMapping(params = "doReader")
	@ResponseBody
	public AjaxJson doReader(SinoZkEntity sinoZk, HttpServletRequest req) {
		AjaxJson j = new AjaxJson();
		message = "考勤数据读取成功";
		try 
		{
			System.out.println(sinoZk.getIp());
		}
		catch (Exception e) {
			e.printStackTrace();
			message = "考勤数据读取失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	
	/**
	 * 更新考勤数据
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(SinoZkEntity sinoZk, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "考勤数据更新成功";
		SinoZkEntity t = sinoZkService.get(SinoZkEntity.class, sinoZk.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(sinoZk, t);
			sinoZkService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "考勤数据更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * 考勤数据新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(SinoZkEntity sinoZk, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(sinoZk.getId())) {
			sinoZk = sinoZkService.getEntity(SinoZkEntity.class, sinoZk.getId());
			req.setAttribute("sinoZkPage", sinoZk);
		}
		return new ModelAndView("com/sino/zk/sinoZk-add");
	}
	/**
	 * 考勤数据编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(SinoZkEntity sinoZk, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(sinoZk.getId())) {
			sinoZk = sinoZkService.getEntity(SinoZkEntity.class, sinoZk.getId());
			req.setAttribute("sinoZkPage", sinoZk);
		}
		return new ModelAndView("com/sino/zk/sinoZk-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		return new ModelAndView("com/sino/zk/sinoZkUpload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(SinoZkEntity sinoZk,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(SinoZkEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, sinoZk, request.getParameterMap());
		List<SinoZkEntity> sinoZks = this.sinoZkService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"考勤数据");
		modelMap.put(NormalExcelConstants.CLASS,SinoZkEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("考勤数据列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,sinoZks);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(SinoZkEntity sinoZk,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		modelMap.put(TemplateExcelConstants.FILE_NAME, "考勤数据");
		modelMap.put(TemplateExcelConstants.PARAMS,new TemplateExportParams("Excel模板地址"));
		modelMap.put(TemplateExcelConstants.MAP_DATA,null);
		modelMap.put(TemplateExcelConstants.CLASS,SinoZkEntity.class);
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
				List<SinoZkEntity> listSinoZkEntitys = ExcelImportUtil.importExcelByIs(file.getInputStream(),SinoZkEntity.class,params);
				for (SinoZkEntity sinoZk : listSinoZkEntitys) {
					sinoZkService.save(sinoZk);
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
