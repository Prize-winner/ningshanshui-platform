package com.cloud.ningshanshui.admin.controller;

import com.cloud.ningshanshui.admin.model.SysLoginLog;
import com.cloud.ningshanshui.admin.service.SysLoginLogService;
import com.cloud.ningshanshui.core.http.HttpResult;
import com.cloud.ningshanshui.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 登录日志控制器
 */
@RestController
@RequestMapping("loginlog")
public class SysLoginLogController {

	@Autowired
	private SysLoginLogService sysLoginLogService;

	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(sysLoginLogService.findPage(pageRequest));
	}
	
	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysLoginLog> records) {
		return HttpResult.ok(sysLoginLogService.delete(records));
	}
}
