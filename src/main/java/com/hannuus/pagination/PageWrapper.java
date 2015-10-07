package com.hannuus.pagination;

/**
 * Pagination封送接口
 * 
 * @author cuesky
 * @date 2015年10月7日 下午6:51:12
 */
public interface PageWrapper {

	/**
	 * 封装分页参数
	 * 
	 * @param pageNum
	 *            页码
	 * @param pageSize
	 *            页面大小
	 * @param attName
	 *            在作用域中的属性名
	 * @return
	 */
	PageParams wrapPageParams(int pageNum, int pageSize, String attName);

	/**
	 * 封装页面数据项
	 * 
	 * @param params
	 *            分页参数
	 * @param model
	 *            域模型，可为HttpServletRequest、ModelMap等
	 * @param page
	 *            页面数据项
	 */
	<T> void wrapPageDTO(PageParams params, Object model, PageDTO<T> page);

}
