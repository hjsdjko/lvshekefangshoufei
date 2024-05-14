package com.entity.vo;

import com.entity.FangjianzhusuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 住宿信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("fangjianzhusu")
public class FangjianzhusuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 房间
     */

    @TableField(value = "fangjian_id")
    private Integer fangjianId;


    /**
     * 员工
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 预约用户名称
     */

    @TableField(value = "fangjianzhusu_name")
    private String fangjianzhusuName;


    /**
     * 联系方式
     */

    @TableField(value = "fangjianzhusu_phone")
    private String fangjianzhusuPhone;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "fangjianzhusu_time")
    private Date fangjianzhusuTime;


    /**
     * 住宿天数
     */

    @TableField(value = "zhusu_number")
    private Integer zhusuNumber;


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
	 * 设置：房间
	 */
    public Integer getFangjianId() {
        return fangjianId;
    }


    /**
	 * 获取：房间
	 */

    public void setFangjianId(Integer fangjianId) {
        this.fangjianId = fangjianId;
    }
    /**
	 * 设置：员工
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：员工
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：预约用户名称
	 */
    public String getFangjianzhusuName() {
        return fangjianzhusuName;
    }


    /**
	 * 获取：预约用户名称
	 */

    public void setFangjianzhusuName(String fangjianzhusuName) {
        this.fangjianzhusuName = fangjianzhusuName;
    }
    /**
	 * 设置：联系方式
	 */
    public String getFangjianzhusuPhone() {
        return fangjianzhusuPhone;
    }


    /**
	 * 获取：联系方式
	 */

    public void setFangjianzhusuPhone(String fangjianzhusuPhone) {
        this.fangjianzhusuPhone = fangjianzhusuPhone;
    }
    /**
	 * 设置：预约时间
	 */
    public Date getFangjianzhusuTime() {
        return fangjianzhusuTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setFangjianzhusuTime(Date fangjianzhusuTime) {
        this.fangjianzhusuTime = fangjianzhusuTime;
    }
    /**
	 * 设置：住宿天数
	 */
    public Integer getZhusuNumber() {
        return zhusuNumber;
    }


    /**
	 * 获取：住宿天数
	 */

    public void setZhusuNumber(Integer zhusuNumber) {
        this.zhusuNumber = zhusuNumber;
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
