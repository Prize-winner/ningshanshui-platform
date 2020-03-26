package com.cloud.ningshanshui.admin.controller;

import com.cloud.ningshanshui.admin.model.SysDict;
import com.cloud.ningshanshui.admin.service.SysDictService;
import com.cloud.ningshanshui.core.http.HttpResult;
import com.cloud.ningshanshui.core.page.PageRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 字典控制器
 */
@RestController
@RequestMapping("dict")
public class SysDictController {

	@Autowired
	private SysDictService sysDictService;
	
	@PostMapping(value="/save")
	public HttpResult save(@RequestBody SysDict record) {
		return HttpResult.ok(sysDictService.save(record));
	}

	@PostMapping(value="/delete")
	public HttpResult delete(@RequestBody List<SysDict> records) {
		return HttpResult.ok(sysDictService.delete(records));
	}

	@PostMapping(value="/findPage")
	public HttpResult findPage(@RequestBody PageRequest pageRequest) {
		return HttpResult.ok(sysDictService.findPage(pageRequest));
	}
	
	@GetMapping(value="/findByLable")
	public HttpResult findByLable(@RequestParam String lable) {
		return HttpResult.ok(sysDictService.findByLable(lable));
	}
}
