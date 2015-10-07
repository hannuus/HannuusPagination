package com.hannuus.pagination;

/**
 * 分页回调<br>
 * 用于执行service查询接口
 * 
 * @author cuesky
 * @date 2015年10月7日 下午6:50:44
 * @param <T>
 *            Domain Class
 */
public interface PageQueryCallback<T> {

	/**
	 * 分页查询
	 * 
	 * @param params
	 *            分页参数
	 * @return 分页数据项
	 */
	PageDTO<T> query(PageParams params);

}
