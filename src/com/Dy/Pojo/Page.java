package com.Dy.Pojo;

import java.util.List;

public class Page<T> {
	// 每页显示的条数 ， 默认我们就给他设置为10条吧
	private Integer pageSize=10;
	// 当前页码
	private Integer currentPage=1;
	// 总记录条数
	private Integer totalNum;
	// 总页数
	private Integer totalPage;
	// 要显示的数据
	private List<T> list;

	private Integer startindex;
	// 要显示的页数，比如start=1，end=5，就在页面上显示1，2，3，4，5
	private Integer start;
	private Integer end;

	public Page(Integer pageSize, Integer currentPage, Integer totalNum) {
		// 开始的页面等于当前页面
		this.start = currentPage;
		this.startindex = (currentPage - 1) * pageSize;
		this.pageSize = pageSize;
		this.currentPage = currentPage;
		this.totalNum = totalNum;
		// 正好整除
		if (this.totalNum % pageSize == 0)
			// 总页数
			this.currentPage = this.totalNum / pageSize;
		else
			this.totalPage = this.totalNum / pageSize + 1;
		//计算最后显示的一页，这里用了硬编码，可以使用.propertires,或设置一个变量解决，这里因为是Demo就先这样
		if (this.totalPage - currentPage >= 5) {
			this.end = currentPage + 5;
		} else {
			this.end = this.currentPage;
		}

	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}

	public Integer getTotalNum() {
		return totalNum;
	}

	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public void setTotal(Integer total) {
		this.totalNum = total;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public Integer getStartindex() {
		return startindex;
	}

	public void setStartindex(Integer startindex) {
		this.startindex = startindex;
	}

}
