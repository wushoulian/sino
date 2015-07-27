package com.sino.zk.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: 考勤数据
 * @author onlineGenerator
 * @date 2015-06-24 09:57:12
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sino_zk", schema = "")
@SuppressWarnings("serial")
public class SinoZkEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**工号*/
	private java.lang.String number;
	/**姓名*/
	private java.lang.String name;
	/**时间*/
	private java.util.Date dtime;
	/**年份*/
	private java.lang.Integer dyear;
	/**月份*/
	private java.lang.Integer dmonth;
	/**日份*/
	private java.lang.Integer dday;
	/**时数*/
	private java.lang.Integer dhour;
	/**分数*/
	private java.lang.Integer dminute;
	/**秒数*/
	private java.lang.Integer dsecond;
	/**卡钟IP*/
	private java.lang.String ip;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=36)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工号
	 */
	@Column(name ="NUMBER",nullable=true,length=50)
	public java.lang.String getNumber(){
		return this.number;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工号
	 */
	public void setNumber(java.lang.String number){
		this.number = number;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  姓名
	 */
	@Column(name ="NAME",nullable=true,length=50)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  时间
	 */
	@Column(name ="DTIME",nullable=true,length=20)
	public java.util.Date getDtime(){
		return this.dtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  时间
	 */
	public void setDtime(java.util.Date dtime){
		this.dtime = dtime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  年份
	 */
	@Column(name ="DYEAR",nullable=true,length=50)
	public java.lang.Integer getDyear(){
		return this.dyear;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  年份
	 */
	public void setDyear(java.lang.Integer dyear){
		this.dyear = dyear;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  月份
	 */
	@Column(name ="DMONTH",nullable=true,length=50)
	public java.lang.Integer getDmonth(){
		return this.dmonth;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  月份
	 */
	public void setDmonth(java.lang.Integer dmonth){
		this.dmonth = dmonth;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  日份
	 */
	@Column(name ="DDAY",nullable=true,length=20)
	public java.lang.Integer getDday(){
		return this.dday;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  日份
	 */
	public void setDday(java.lang.Integer dday){
		this.dday = dday;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  时数
	 */
	@Column(name ="DHOUR",nullable=true,length=32)
	public java.lang.Integer getDhour(){
		return this.dhour;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  时数
	 */
	public void setDhour(java.lang.Integer dhour){
		this.dhour = dhour;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  分数
	 */
	@Column(name ="DMINUTE",nullable=true,length=32)
	public java.lang.Integer getDminute(){
		return this.dminute;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  分数
	 */
	public void setDminute(java.lang.Integer dminute){
		this.dminute = dminute;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  秒数
	 */
	@Column(name ="DSECOND",nullable=true,length=32)
	public java.lang.Integer getDsecond(){
		return this.dsecond;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  秒数
	 */
	public void setDsecond(java.lang.Integer dsecond){
		this.dsecond = dsecond;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  卡钟IP
	 */
	@Column(name ="IP",nullable=true,length=32)
	public java.lang.String getIp(){
		return this.ip;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  卡钟IP
	 */
	public void setIp(java.lang.String ip){
		this.ip = ip;
	}
}
