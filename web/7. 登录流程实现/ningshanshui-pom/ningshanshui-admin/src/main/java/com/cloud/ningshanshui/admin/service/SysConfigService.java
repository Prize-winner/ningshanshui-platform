package com.cloud.ningshanshui.admin.service;

import com.cloud.ningshanshui.admin.model.SysConfig;
import com.cloud.ningshanshui.core.service.CurdService;

import java.util.List;


/**
 * 系统配置管理
 */
public interface SysConfigService extends CurdService<SysConfig> {

	/**
	 * 根据名称查询
	 * @param lable
	 * @return
	 */
	List<SysConfig> findByLable(String lable);
}
