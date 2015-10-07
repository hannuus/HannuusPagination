package com.hannuus.pagination;

import org.springframework.util.StringUtils;

/**
 * 分页参数换算类<br>
 * 将请求中的参数换算为DB分页所需参数<br>
 * 暂不包装Domain相关条件参数
 * 
 * @author cuesky
 * @date 2015年8月31日 下午9:09:08
 */
public class PageParams {

	/** 该页起始位置索引 */
	private int start;
	/** 分页条数 */
	private int pageSize = 8;
	/** 在作用域中的属性名 */
	private String attName = "page";

	public PageParams() {
	}

	// /**
	// * @param pageNum
	// * 页码
	// * @param pageSize
	// * 分页条数
	// */
	// public PageParams(int pageNum, int pageSize) {
	// // fix the pageNum
	// if (pageNum >= 1) {
	// this.start = (pageNum - 1) * pageSize;
	// }
	// // fix the pageSize
	// if (pageSize > 0) {
	// this.pageSize = pageSize;
	// }
	// }

	/**
	 * @param pageNum
	 *            页码
	 * @param pageSize
	 *            分页条数
	 * @param attName
	 *            在作用域中的属性名
	 */
	public PageParams(int pageNum, int pageSize, String attName) {
		// fix the pageNum
		if (pageNum >= 1) {
			this.start = (pageNum - 1) * pageSize;
		}
		// fix the pageSize
		if (pageSize > 0) {
			this.pageSize = pageSize;
		}
		if (!StringUtils.isEmpty(attName)) {
			this.attName = attName;
		}
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getAttName() {
		return attName;
	}

	public void setAttName(String attName) {
		this.attName = attName;
	}

	@Override
	public String toString() {
		return "PageParams [start=" + start + ", pageSize=" + pageSize
				+ ", attName=" + attName + "]";
	}

}
