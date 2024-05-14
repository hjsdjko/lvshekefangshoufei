package com.entity.vo;

import com.entity.CaiwuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 财务信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("caiwu")
public class CaiwuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 详情
     */

    @TableField(value = "caiwu_text")
    private String caiwuText;


    /**
     * 创建时间 show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
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
	 * 设置：创建时间 show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
