package com.sino.packlist.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: 预计发货明细
 * @author onlineGenerator
 * @date 2015-06-12 09:26:37
 * @version V1.0   
 *
 */
@Entity
@Table(name = "sino_pack_list", schema = "")
@SuppressWarnings("serial")
public class SinoPackListEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**目的国*/
	@Excel(name="目的国")
	private java.lang.String descountry;
	/**厂商*/
	@Excel(name="厂商")
	private java.lang.String firm;
	/**产品*/
	@Excel(name="产品")
	private java.lang.String product;
	/**产品描述*/
	@Excel(name="产品描述")
	private java.lang.String description;
	/**PO单号*/
	@Excel(name="PO单号")
	private java.lang.String po;
	/**SO单号*/
	@Excel(name="SO单号")
	private java.lang.String so;
	/**数量*/
	@Excel(name="数量")
	private java.lang.Integer amount;
	/**现出厂时间*/
	@Excel(name="现出厂时间")
	private java.util.Date actualtime;
	/**原出厂时间*/
	@Excel(name="原出厂时间")
	private java.util.Date plantime;
	/**开船时间*/
	@Excel(name="开船时间")
	private java.util.Date etd;
	/**Extend Amount*/
	@Excel(name="Extend Amount")
	private java.lang.Double eamount;
	/**Remark*/
	@Excel(name="Remark")
	private java.lang.String remark;
	/**单价*/
	@Excel(name="单价")
	private java.lang.Double price;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String remarks;
	/**时间*/
	@Excel(name="时间")
	private java.util.Date time;
	
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
	 *@return: java.lang.String  目的国
	 */
	@Column(name ="DESCOUNTRY",nullable=true,length=50)
	public java.lang.String getDescountry(){
		return this.descountry;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  目的国
	 */
	public void setDescountry(java.lang.String descountry){
		this.descountry = descountry;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  厂商
	 */
	@Column(name ="FIRM",nullable=true,length=50)
	public java.lang.String getFirm(){
		return this.firm;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  厂商
	 */
	public void setFirm(java.lang.String firm){
		this.firm = firm;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品
	 */
	@Column(name ="PRODUCT",nullable=true,length=50)
	public java.lang.String getProduct(){
		return this.product;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品
	 */
	public void setProduct(java.lang.String product){
		this.product = product;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品描述
	 */
	@Column(name ="DESCRIPTION",nullable=true,length=50)
	public java.lang.String getDescription(){
		return this.description;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品描述
	 */
	public void setDescription(java.lang.String description){
		this.description = description;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  PO单号
	 */
	@Column(name ="PO",nullable=true,length=50)
	public java.lang.String getPo(){
		return this.po;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  PO单号
	 */
	public void setPo(java.lang.String po){
		this.po = po;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  SO单号
	 */
	@Column(name ="SO",nullable=true,length=50)
	public java.lang.String getSo(){
		return this.so;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  SO单号
	 */
	public void setSo(java.lang.String so){
		this.so = so;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  数量
	 */
	@Column(name ="AMOUNT",nullable=true,length=32)
	public java.lang.Integer getAmount(){
		return this.amount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  数量
	 */
	public void setAmount(java.lang.Integer amount){
		this.amount = amount;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  现出厂时间
	 */
	@Column(name ="ACTUALTIME",nullable=true,length=32)
	public java.util.Date getActualtime(){
		return this.actualtime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  现出厂时间
	 */
	public void setActualtime(java.util.Date actualtime){
		this.actualtime = actualtime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  原出厂时间
	 */
	@Column(name ="PLANTIME",nullable=true,length=32)
	public java.util.Date getPlantime(){
		return this.plantime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  原出厂时间
	 */
	public void setPlantime(java.util.Date plantime){
		this.plantime = plantime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开船时间
	 */
	@Column(name ="ETD",nullable=true,length=32)
	public java.util.Date getEtd(){
		return this.etd;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开船时间
	 */
	public void setEtd(java.util.Date etd){
		this.etd = etd;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  Extend Amount
	 */
	@Column(name ="EAMOUNT",nullable=true,length=32)
	public java.lang.Double getEamount(){
		return this.eamount;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  Extend Amount
	 */
	public void setEamount(java.lang.Double eamount){
		this.eamount = eamount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  Remark
	 */
	@Column(name ="REMARK",nullable=true,length=32)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  Remark
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
	}
	/**
	 *方法: 取得java.lang.Double
	 *@return: java.lang.Double  单价
	 */
	@Column(name ="PRICE",nullable=true,length=32)
	public java.lang.Double getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置java.lang.Double
	 *@param: java.lang.Double  单价
	 */
	public void setPrice(java.lang.Double price){
		this.price = price;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARKS",nullable=true,length=200)
	public java.lang.String getRemarks(){
		return this.remarks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemarks(java.lang.String remarks){
		this.remarks = remarks;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  时间
	 */
	@Column(name ="TIME",nullable=true,length=32)
	public java.util.Date getTime(){
		return this.time;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  时间
	 */
	public void setTime(java.util.Date time){
		this.time = time;
	}
}
