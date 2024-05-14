package com.entity.model;

import com.entity.CaiwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 财务信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class CaiwuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 标题
     */
    private String caiwuName;


    /**
     * 财务类型
     */
    private Integer caiwuTypes;


    /**
     * 金额
     */
    private Double caiwuMoney;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 详情
     */
    private String caiwuText;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：标题
	 */
    public String getCaiwuName() {
        return caiwuName;
    }


    /**
	 * 设置：标题
	 */
    public void setCaiwuName(String caiwuName) {
        this.caiwuName = caiwuName;
    }
    /**
	 * 获取：财务类型
	 */
    public Integer getCaiwuTypes() {
        return caiwuTypes;
    }


    /**
	 * 设置：财务类型
	 */
    public void setCaiwuTypes(Integer caiwuTypes) {
        this.caiwuTypes = caiwuTypes;
    }
    /**
	 * 获取：金额
	 */
    public Double getCaiwuMoney() {
        return caiwuMoney;
    }


    /**
	 * 设置：金额
	 */
    public void setCaiwuMoney(Double caiwuMoney) {
        this.caiwuMoney = caiwuMoney;
    }
    /**
	 * 获取：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：添加时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：详情
	 */
    public String getCaiwuText() {
        return caiwuText;
    }


    /**
	 * 设置：详情
	 */
    public void setCaiwuText(String caiwuText) {
        this.caiwuText = caiwuText;
    }
    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
