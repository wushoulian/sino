package org.jeecgframework.web.sms.service.impl;
import org.jeecgframework.web.sms.service.TSSmsSqlServiceI;
import org.jeecgframework.core.common.service.impl.CommonServiceImpl;
import org.jeecgframework.web.sms.entity.TSSmsSqlEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.UUID;
import java.io.Serializable;

import javax.annotation.Resource;

@Service("tSSmsSqlService")
@Transactional
public class TSSmsSqlServiceImpl extends CommonServiceImpl implements TSSmsSqlServiceI {

	@Resource
	private JdbcTemplate jdbcTemplate;
	
	public boolean doAddSql(TSSmsSqlEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean doDelSql(TSSmsSqlEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public boolean doUpdateSql(TSSmsSqlEntity t) {
		// TODO Auto-generated method stub
		return false;
	}
/**
 * 执行业务查询出来的sql
 */
	public Map<String, Object> getMap(String sql,Map<String, Object> map){
		return this.jdbcTemplate.queryForMap(sql, map);
		
	}
 	
}