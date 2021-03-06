package org.jeecgframework.web.sms.util;

import java.util.List;
import java.util.Map;

import org.jeecgframework.core.util.ApplicationContextUtil;
import org.jeecgframework.web.sms.entity.TSSmsEntity;
import org.jeecgframework.web.sms.entity.TSSmsSqlEntity;
import org.jeecgframework.web.sms.entity.TSSmsTemplateEntity;
import org.jeecgframework.web.sms.entity.TSSmsTemplateSqlEntity;
import org.jeecgframework.web.sms.service.TSSmsServiceI;
import org.jeecgframework.web.sms.service.TSSmsSqlServiceI;
import org.jeecgframework.web.sms.service.TSSmsTemplateServiceI;
import org.jeecgframework.web.sms.service.TSSmsTemplateSqlServiceI;
import org.jeecgframework.web.system.service.SystemService;
/**
 * 
  * @ClassName: TuiSongMsgUtil 统一发送消息的公用方法
  * @Description: TODO
  * @author Comsys-skyCc cmzcheng@gmail.com
  * @date 2014-9-18 下午3:20:34
  *
 */
public class TuiSongMsgUtil {
	
	private static TSSmsServiceI tSSmsService; //短信表service；

	private static SystemService systemService;
	private static TSSmsTemplateSqlServiceI tSSmsTemplateSqlService;//业务sql消息模板关联service;
	
	private static TSSmsTemplateServiceI tSSmsTemplateService;//消息模板service
	
	private static TSSmsSqlServiceI tSSmsSqlService;//业务sqlservice
	/**
	 * 
	  * sendMessage 统一消息发送接口
	  *
	  * @Title: sendMessage 
	  * @Description: TODO
	  * @param @param msgType 消息类型
	  * @param @param code
	  * @param @param map
	  * @param @param sentTo
	  * @param @return    设定文件
	  * @return String    返回类型
	  * @throws
	 */
	public static String sendMessage(String msgType, String code,
			Map<String, Object> map, String sentTo) {
		// TODO Auto-generated method stub
		try {
			TSSmsEntity tss=new TSSmsEntity();
			tss.setEsType(msgType);
			tss.setEsReceiver(sentTo);
			tss.setEsStatus("1");
			String hql="from TSSmsTemplateSqlEntity as tempSql where tempSql.code=? ";
			String smsContent="";
			List<TSSmsTemplateSqlEntity> tssmsTemplateSqlList=getTssmsTemplateSqlInstance().findHql(hql, code);
			for (TSSmsTemplateSqlEntity tsSmsTemplateSqlEntity : tssmsTemplateSqlList) {
				String templateSql= getTemplateSql(tsSmsTemplateSqlEntity.getSqlId());//获取对应业务sql表中的sql语句
				String templateContent=getTemplateContent(tsSmsTemplateSqlEntity.getTemplateId());//获取模板表的对应的模板内容
				//执行查询出来的模板sql
				smsContent=getSearchSql(templateSql,map)+templateContent;//组合短信内容
			}
			tss.setEsContent(smsContent);
			getTSSmsServiceInstance().save(tss);		//对库进行查询操作
			return "success";

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return "false";
		}
			}
	
	/**
	 * 
	  * getSearchSql 操作业务sql表短信sql的方法
	  *
	  * @Title: getSearchSql
	  * @Description: TODO
	  * @param @param templateSql
	  * @param @param map
	  * @param @return    设定文件
	  * @return String    返回类型
	  * @throws
	 */
	public static Map<String, Object> getSearchSql(String templateSql,Map<String, Object> map){
		//调用查询sql的方法执行此sql
		return tSSmsSqlService.getMap(templateSql, map);
		
	}
	/**
	 * 
	  * getTemplateServiceSql 获取短信sql具体的sql内容
	  *
	  * @Title: getTemplateServiceSql
	  * @Description: TODO
	  * @param @param sqlId
	  * @param @return    设定文件
	  * @return String    返回类型
	  * @throws
	 */
	public static String getTemplateSql(String sqlId){
		String hql="from TSSmsSqlEntity as tssSql where tssSql.id=?";
		List<TSSmsSqlEntity>tssmsSqlList=getTSSmsSqlInstance().findHql(hql, sqlId);
		String sqlContent="";
		for (TSSmsSqlEntity tsSmsSqlEntity : tssmsSqlList) {
			sqlContent=tsSmsSqlEntity.getSqlContent();
		}
		return sqlContent;
	}
	/**
	 * 
	  * getTemplateContent 获取模板内容
	  *
	  * @Title: getTemplateContent
	  * @Description: TODO
	  * @param @param templateId
	  * @param @return    设定文件
	  * @return String    返回类型
	  * @throws
	 */
	public static  String getTemplateContent(String templateId){
		String hql="from TSSmsTemplateEntity as template where template.id=? ";
		List<TSSmsTemplateEntity> tSSmsTemplateList=getTssmsTemplateInstance().findHql(hql, templateId);
		String templateConetent="";
		for (TSSmsTemplateEntity tsSmsTemplateEntity : tSSmsTemplateList) {
			templateConetent=tsSmsTemplateEntity.getTemplateContent();
		}
		return templateConetent;
	}
	
	/**
	 * 
	  * getTSSmsServiceInstance 获取短信service
	  *
	  * @Title: getTSSmsServiceInstance
	  * @Description: TODO
	  * @param @return    设定文件
	  * @return TSSmsServiceI    返回类型
	  * @throws
	 */
	public static TSSmsServiceI getTSSmsServiceInstance(){
		
		if(tSSmsService==null){
			tSSmsService=ApplicationContextUtil.getContext().getBean(TSSmsServiceI.class);
			
		}
		return tSSmsService;
	}
	/**
	 * 
	  * getTssmsTemplateSqlInstance 获取短信模板关联service实体
	  *
	  * @Title: getTssmsTemplateSqlInstance
	  * @Description: TODO
	  * @param @return    设定文件
	  * @return TSSmsTemplateSqlServiceI    返回类型
	  * @throws
	 */
	public static TSSmsTemplateSqlServiceI getTssmsTemplateSqlInstance(){
		
		if(tSSmsTemplateSqlService==null){
			
			tSSmsTemplateSqlService=ApplicationContextUtil.getContext().getBean(TSSmsTemplateSqlServiceI.class);
			
		}
		return tSSmsTemplateSqlService;
	}
	/**
	 * 
	  * getTssmsTemplateInstance 获取具体的模板service实体
	  *
	  * @Title: getTssmsTemplateInstance
	  * @Description: TODO
	  * @param @return    设定文件
	  * @return TSSmsTemplateServiceI    返回类型
	  * @throws
	 */
	public static TSSmsTemplateServiceI getTssmsTemplateInstance(){
		if(tSSmsTemplateService==null){
			
			tSSmsTemplateService=ApplicationContextUtil.getContext().getBean(TSSmsTemplateServiceI.class);
		}
		return tSSmsTemplateService;
	}
	/**
	 * 
	  * getTSSmsSqlInstance 获取业务sql service实体
	  *
	  * @Title: getTSSmsSqlInstance
	  * @Description: TODO
	  * @param @return    设定文件
	  * @return TSSmsSqlServiceI    返回类型
	  * @throws
	 */
	public static TSSmsSqlServiceI getTSSmsSqlInstance(){
		if(tSSmsSqlService==null){
			
			tSSmsSqlService=ApplicationContextUtil.getContext().getBean(TSSmsSqlServiceI.class);
		}
		return tSSmsSqlService;
	}
}
