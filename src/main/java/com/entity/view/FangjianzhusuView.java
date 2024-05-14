package com.entity.view;

import com.entity.FangjianzhusuEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 住宿信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("fangjianzhusu")
public class FangjianzhusuView extends FangjianzhusuEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 fangjian
			/**
			* 房间号
			*/
			private String fangjianName;
			/**
			* 房间类型
			*/
			private Integer fangjianTypes;
				/**
				* 房间类型的值
				*/
				private String fangjianValue;
			/**
			* 房间价格(天)
			*/
			private Double fangjianMoney;
			/**
			* 房间详情
			*/
			private String fangjianContent;

		//级联表 yonghu
			/**
			* 员工姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 联系方式
			*/
			private String yonghuPhone;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public FangjianzhusuView() {

	}

	public FangjianzhusuView(FangjianzhusuEntity fangjianzhusuEntity) {
		try {
			BeanUtils.copyProperties(this, fangjianzhusuEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}













				//级联表的get和set fangjian

					/**
					* 获取： 房间号
					*/
					public String getFangjianName() {
						return fangjianName;
					}
					/**
					* 设置： 房间号
					*/
					public void setFangjianName(String fangjianName) {
						this.fangjianName = fangjianName;
					}

					/**
					* 获取： 房间类型
					*/
					public Integer getFangjianTypes() {
						return fangjianTypes;
					}
					/**
					* 设置： 房间类型
					*/
					public void setFangjianTypes(Integer fangjianTypes) {
						this.fangjianTypes = fangjianTypes;
					}


						/**
						* 获取： 房间类型的值
						*/
						public String getFangjianValue() {
							return fangjianValue;
						}
						/**
						* 设置： 房间类型的值
						*/
						public void setFangjianValue(String fangjianValue) {
							this.fangjianValue = fangjianValue;
						}

					/**
					* 获取： 房间价格(天)
					*/
					public Double getFangjianMoney() {
						return fangjianMoney;
					}
					/**
					* 设置： 房间价格(天)
					*/
					public void setFangjianMoney(Double fangjianMoney) {
						this.fangjianMoney = fangjianMoney;
					}

					/**
					* 获取： 房间详情
					*/
					public String getFangjianContent() {
						return fangjianContent;
					}
					/**
					* 设置： 房间详情
					*/
					public void setFangjianContent(String fangjianContent) {
						this.fangjianContent = fangjianContent;
					}










				//级联表的get和set yonghu

					/**
					* 获取： 员工姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 员工姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}

					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}

					/**
					* 获取： 联系方式
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 联系方式
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}

					/**
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}

					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}



}
