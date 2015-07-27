package com.sino.zk.service.impl;
import com.sino.zk.service.SinoZkServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.sino.zk.entity.SinoZkEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("sinoZkService")
@Transactional
public class SinoZkServiceImpl extends CommonServiceImpl implements SinoZkServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((SinoZkEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((SinoZkEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((SinoZkEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(SinoZkEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(SinoZkEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(SinoZkEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,SinoZkEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{number}",String.valueOf(t.getNumber()));
 		sql  = sql.replace("#{name}",String.valueOf(t.getName()));
 		sql  = sql.replace("#{dtime}",String.valueOf(t.getDtime()));
 		sql  = sql.replace("#{dyear}",String.valueOf(t.getDyear()));
 		sql  = sql.replace("#{dmonth}",String.valueOf(t.getDmonth()));
 		sql  = sql.replace("#{dday}",String.valueOf(t.getDday()));
 		sql  = sql.replace("#{dhour}",String.valueOf(t.getDhour()));
 		sql  = sql.replace("#{dminute}",String.valueOf(t.getDminute()));
 		sql  = sql.replace("#{dsecond}",String.valueOf(t.getDsecond()));
 		sql  = sql.replace("#{ip}",String.valueOf(t.getIp()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}