package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 财务信息
 *
 * @author 
 * @email
 */
@TableName("caiwu")
public class CaiwuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public CaiwuEntity() {

	}

	public CaiwuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 标题
     */
    @TableField(value = "caiwu_name")

    private String caiwuName;


    /**
     * 财务类型
     */
    @TableField(value = "caiwu_types")

    private Integer caiwuTypes;


    /**
     * 金额
     */
    @TableField(value = "caiwu_money")

    private Double caiwuMoney;


    /**
     * 添加时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 详情
     */
    @TableField(value = "caiwu_text")

    private String caiwuText;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }
    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：标题
	 */
    public String getCaiwuName() {
        return caiwuName;
    }
    /**
	 * 获取：标题
	 */

    public void setCaiwuName(String caiwuName) {
        this.caiwuName = caiwuName;
    }
    /**
	 * 设置：财务类型
	 */
    public Integer getCaiwuTypes() {
        return caiwuTypes;
    }
    /**
	 * 获取：财务类型
	 */

    public void setCaiwuTypes(Integer caiwuTypes) {
        this.caiwuTypes = caiwuTypes;
    }
    /**
	 * 设置：金额
	 */
    public Double getCaiwuMoney() {
        return caiwuMoney;
    }
    /**
	 * 获取：金额
	 */

    public void setCaiwuMoney(Double caiwuMoney) {
        this.caiwuMoney = caiwuMoney;
    }
    /**
	 * 设置：添加时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }
    /**
	 * 获取：添加时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：详情
	 */
    public String getCaiwuText() {
        return caiwuText;
    }
    /**
	 * 获取：详情
	 */

    public void setCaiwuText(String caiwuText) {
        this.caiwuText = caiwuText;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Caiwu{" +
            "id=" + id +
            ", caiwuName=" + caiwuName +
            ", caiwuTypes=" + caiwuTypes +
            ", caiwuMoney=" + caiwuMoney +
            ", insertTime=" + insertTime +
            ", caiwuText=" + caiwuText +
            ", createTime=" + createTime +
        "}";
    }
}
