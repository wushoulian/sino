package com.sino.packlist.service.impl;
import com.sino.packlist.service.SinoPackListServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import com.sino.packlist.entity.SinoPackListEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;
import java.io.Serializable;

@Service("sinoPackListService")
@Transactional
public class SinoPackListServiceImpl extends CommonServiceImpl implements SinoPackListServiceI {

	
 	public <T> void delete(T entity) {
 		super.delete(entity);
 		//执行删除操作配置的sql增强
		this.doDelSql((SinoPackListEntity)entity);
 	}
 	
 	public <T> Serializable save(T entity) {
 		Serializable t = super.save(entity);
 		//执行新增操作配置的sql增强
 		this.doAddSql((SinoPackListEntity)entity);
 		return t;
 	}
 	
 	public <T> void saveOrUpdate(T entity) {
 		super.saveOrUpdate(entity);
 		//执行更新操作配置的sql增强
 		this.doUpdateSql((SinoPackListEntity)entity);
 	}
 	
 	/**
	 * 默认按钮-sql增强-新增操作
	 * @param id
	 * @return
	 */
 	public boolean doAddSql(SinoPackListEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-更新操作
	 * @param id
	 * @return
	 */
 	public boolean doUpdateSql(SinoPackListEntity t){
	 	return true;
 	}
 	/**
	 * 默认按钮-sql增强-删除操作
	 * @param id
	 * @return
	 */
 	public boolean doDelSql(SinoPackListEntity t){
	 	return true;
 	}
 	
 	/**
	 * 替换sql中的变量
	 * @param sql
	 * @return
	 */
 	public String replaceVal(String sql,SinoPackListEntity t){
 		sql  = sql.replace("#{id}",String.valueOf(t.getId()));
 		sql  = sql.replace("#{descountry}",String.valueOf(t.getDescountry()));
 		sql  = sql.replace("#{firm}",String.valueOf(t.getFirm()));
 		sql  = sql.replace("#{product}",String.valueOf(t.getProduct()));
 		sql  = sql.replace("#{description}",String.valueOf(t.getDescription()));
 		sql  = sql.replace("#{po}",String.valueOf(t.getPo()));
 		sql  = sql.replace("#{so}",String.valueOf(t.getSo()));
 		sql  = sql.replace("#{amount}",String.valueOf(t.getAmount()));
 		sql  = sql.replace("#{actualtime}",String.valueOf(t.getActualtime()));
 		sql  = sql.replace("#{plantime}",String.valueOf(t.getPlantime()));
 		sql  = sql.replace("#{etd}",String.valueOf(t.getEtd()));
 		sql  = sql.replace("#{eamount}",String.valueOf(t.getEamount()));
 		sql  = sql.replace("#{remark}",String.valueOf(t.getRemark()));
 		sql  = sql.replace("#{price}",String.valueOf(t.getPrice()));
 		sql  = sql.replace("#{remarks}",String.valueOf(t.getRemarks()));
 		sql  = sql.replace("#{time}",String.valueOf(t.getTime()));
 		sql  = sql.replace("#{UUID}",UUID.randomUUID().toString());
 		return sql;
 	}
}