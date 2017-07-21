package entity;

import java.util.ArrayList;
import java.util.List;

public class page {
	// 页号
	private int pageNo;

	// 每页条数
	private int pageSize = 3;

	// 总条数
	private int count;

	// 总页数
	private int totalPage;

	// 前一页
	private int pre;

	// 后一页
	private int next;

	// 分页的当前页的数据
	private List<User> list = new ArrayList<User>();

	private int start;

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getCount() {
		return count;
	}

	// 设置总条数的时候,设置总页数,验证页号,设置上一页,下一页
	public void setCount(int count) {
		// 设置总条数
		this.count = count;
		// 设置总页数
		this.totalPage = count % pageSize == 0 ? count / pageSize : count
				/ pageSize + 1;
		// 验证页号
		if (pageNo < 1) {
			pageNo = 1;
		} else if (pageNo > totalPage) {
			pageNo = totalPage;
		}

		// 设置上一页
		if (pageNo > 1) {
			pre = pageNo - 1;
		} else {
			pre = 1;
		}

		// 设置下一页
		if (pageNo >= totalPage) {
			next = totalPage;
		} else {
			next = pageNo + 1;
		}

		// 设置起始行号
		start = (pageNo - 1) * pageSize;

	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPre() {
		return pre;
	}

	public void setPre(int pre) {
		this.pre = pre;
	}

	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}
}
