package com.cloud.ningshanshui.admin.service;

import com.cloud.ningshanshui.admin.model.SysDept;
import com.cloud.ningshanshui.core.service.CurdService;

import java.util.List;


/**
 * 机构管理
 */
public interface SysDeptService extends CurdService<SysDept> {

	/**
	 * 查询机构树
	 * @param userId 
	 * @return
	 */
	List<SysDept> findTree();
}
