package com.hannuus.pagination;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

/**
 * 分页查询模板
 * 
 * @author cuesky
 * @date 2015年10月7日 下午6:46:52
 */
@Component
public class PageQueryTemplate {

	private Logger logger = Logger.getLogger(getClass());

	/**
	 * 执行分页查询
	 * 
	 * @param pageNum
	 *            页码
	 * @param pageSize
	 *            页面大小
	 * @param model
	 *            域模型
	 * @param callback
	 *            查询回调
	 */
	public <T> PageDTO<T> execute(int pageNum, int pageSize, Object model,
			PageQueryCallback<T> callback) {
		PageParams params = preHandle(pageNum, pageSize, null);
		PageDTO<T> page = callback.query(params);
		postHandle(params, model, page);
		return page;
	}

	/**
	 * 执行分页查询
	 * 
	 * @param pageNum
	 *            页码
	 * @param pageSize
	 *            页面大小
	 * @param model
	 *            域模型
	 * @param callback
	 *            查询回调
	 */
	public <T> PageDTO<T> execute(int pageNum, int pageSize, String attName,
			Object model, PageQueryCallback<T> callback) {
		PageParams params = preHandle(pageNum, pageSize, attName);
		PageDTO<T> page = callback.query(params);
		postHandle(params, model, page);
		return page;
	}

	/**
	 * 执行分页查询
	 * 
	 * @param pageNum
	 *            页码
	 * @param pageSize
	 *            页面大小
	 * @param model
	 *            域模型
	 * @param callback
	 *            查询回调
	 * @param pageWrapper
	 *            自定义分页包装器
	 */
	public <T> PageDTO<T> execute(int pageNum, int pageSize, Object model,
			PageQueryCallback<T> callback, PageWrapper pageWrapper) {
		defaultPageWrapper = pageWrapper;
		PageDTO<T> page = execute(pageNum, pageSize, model, callback);
		return page;
	}

	/**
	 * 执行分页查询
	 * 
	 * @param pageNum
	 *            页码
	 * @param pageSize
	 *            页面大小
	 * @param model
	 *            域模型
	 * @param callback
	 *            查询回调
	 * @param pageWrapper
	 *            自定义分页包装器
	 */
	public <T> PageDTO<T> execute(int pageNum, int pageSize, String attName,
			Object model, PageQueryCallback<T> callback, PageWrapper pageWrapper) {
		defaultPageWrapper = pageWrapper;
		PageDTO<T> page = execute(pageNum, pageSize, attName, model, callback);
		return page;
	}

	/**
	 * 分页参数预处理
	 * 
	 * @param pageNum
	 *            页码
	 * @param pageSize
	 *            页面大小
	 * @param attName
	 *            在作用域中的属性名
	 * @return 分页参数
	 */
	private PageParams preHandle(int pageNum, int pageSize, String attName) {
		PageParams params = defaultPageWrapper.wrapPageParams(pageNum,
				pageSize, attName);
		return params;
	}

	/**
	 * 分页后的数据封送
	 * 
	 * @param model
	 *            域模型
	 * @param page
	 *            分页数据项
	 */
	private <T> void postHandle(PageParams params, Object model, PageDTO<T> page) {
		defaultPageWrapper.wrapPageDTO(params, model, page);
	}

	/** 默认分页包装器 */
	private PageWrapper defaultPageWrapper = new PageWrapper() {

		public PageParams wrapPageParams(int pageNum, int pageSize,
				String attName) {
			PageParams params = new PageParams(pageNum, pageSize, attName);
			logger.debug(params);
			return params;
		}

		public <T> void wrapPageDTO(PageParams params, Object model,
				PageDTO<T> page) {
			if (model != null) {
				ModelMap map = (ModelMap) model;
				map.put(params.getAttName(), page);
				logger.debug(page);
			}
		}

	};

}
