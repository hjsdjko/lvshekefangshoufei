package com.entity.model;

import com.entity.FangjianzhusuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 住宿信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class FangjianzhusuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 房间
     */
    private Integer fangjianId;


    /**
     * 员工
     */
    private Integer yonghuId;


    /**
     * 预约用户名称
     */
    private String fangjianzhusuName;


    /**
     * 联系方式
     */
    private String fangjianzhusuPhone;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date fangjianzhusuTime;


    /**
     * 住宿天数
     */
    private Integer zhusuNumber;


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
	 * 获取：房间
	 */
    public Integer getFangjianId() {
        return fangjianId;
    }


    /**
	 * 设置：房间
	 */
    public void setFangjianId(Integer fangjianId) {
        this.fangjianId = fangjianId;
    }
    /**
	 * 获取：员工
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：员工
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：预约用户名称
	 */
    public String getFangjianzhusuName() {
        return fangjianzhusuName;
    }


    /**
	 * 设置：预约用户名称
	 */
    public void setFangjianzhusuName(String fangjianzhusuName) {
        this.fangjianzhusuName = fangjianzhusuName;
    }
    /**
	 * 获取：联系方式
	 */
    public String getFangjianzhusuPhone() {
        return fangjianzhusuPhone;
    }


    /**
	 * 设置：联系方式
	 */
    public void setFangjianzhusuPhone(String fangjianzhusuPhone) {
        this.fangjianzhusuPhone = fangjianzhusuPhone;
    }
    /**
	 * 获取：预约时间
	 */
    public Date getFangjianzhusuTime() {
        return fangjianzhusuTime;
    }


    /**
	 * 设置：预约时间
	 */
    public void setFangjianzhusuTime(Date fangjianzhusuTime) {
        this.fangjianzhusuTime = fangjianzhusuTime;
    }
    /**
	 * 获取：住宿天数
	 */
    public Integer getZhusuNumber() {
        return zhusuNumber;
    }


    /**
	 * 设置：住宿天数
	 */
    public void setZhusuNumber(Integer zhusuNumber) {
        this.zhusuNumber = zhusuNumber;
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
