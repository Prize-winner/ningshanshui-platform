package com.cloud.ningshanshui.admin.service;

import com.cloud.ningshanshui.admin.model.SysDict;
import com.cloud.ningshanshui.core.service.CurdService;

import java.util.List;


/**
 * 字典管理
 */
public interface SysDictService extends CurdService<SysDict> {

	/**
	 * 根据名称查询
	 * @param lable
	 * @return
	 */
	List<SysDict> findByLable(String lable);
}
