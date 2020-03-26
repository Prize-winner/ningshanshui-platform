package com.cloud.ningshanshui.core.page;

import com.cloud.ningshanshui.common.utils.ReflectionUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * <p>Title: MyBatis 分页查询助手</p>
 * <p>Company: 纬度网络能源</p>
 *
 * @version 1.0
 * @KaiFaAuthor 宁山水
 * @date 2020-03-24 16:55
 */

public class MybatisPageHelper {

    public static final String findPage = "findPage";

    /**
     * 分页查询, 约定查询方法名为 “findPage”
     * @param pageRequest 分页请求
     * @param mapper Dao对象，MyBatis的 Mapper
     * @param args 方法参数
     * @return
     */
    public static PageResult findPage(PageRequest pageRequest, Object mapper) {
        return findPage(pageRequest, mapper, findPage);
    }

    /**
     * 调用分页插件进行分页查询
     * @param pageRequest 分页请求
     * @param mapper Dao对象，MyBatis的 Mapper
     * @param queryMethodName 要分页的查询方法名
     * @param args 方法参数
     * @return
     */
    public static PageResult findPage(PageRequest pageRequest, Object mapper, String queryMethodName, Object... args) {
        // 设置分页参数
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        // 利用反射调用查询方法
        Object result = ReflectionUtils.invoke(mapper, queryMethodName, args);
        return getPageResult(pageRequest, new PageInfo((List) result));
    }

    /**
     * 将分页信息封装到统一的接口
     * @param pageRequest
     * @param page
     * @return
     */
    private static PageResult getPageResult(PageRequest pageRequest, PageInfo<?> pageInfo) {
        PageResult pageResult = new PageResult();
        pageResult.setPageNum(pageInfo.getPageNum());
        pageResult.setPageSize(pageInfo.getPageSize());
        pageResult.setTotalSize(pageInfo.getTotal());
        pageResult.setTotalPages(pageInfo.getPages());
        pageResult.setContent(pageInfo.getList());
        return pageResult;
    }

}
