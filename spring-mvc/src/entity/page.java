package entity;

import java.util.ArrayList;
import java.util.List;

public class page {
	// ҳ��
	private int pageNo;

	// ÿҳ����
	private int pageSize = 3;

	// ������
	private int count;

	// ��ҳ��
	private int totalPage;

	// ǰһҳ
	private int pre;

	// ��һҳ
	private int next;

	// ��ҳ�ĵ�ǰҳ������
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

	// ������������ʱ��,������ҳ��,��֤ҳ��,������һҳ,��һҳ
	public void setCount(int count) {
		// ����������
		this.count = count;
		// ������ҳ��
		this.totalPage = count % pageSize == 0 ? count / pageSize : count
				/ pageSize + 1;
		// ��֤ҳ��
		if (pageNo < 1) {
			pageNo = 1;
		} else if (pageNo > totalPage) {
			pageNo = totalPage;
		}

		// ������һҳ
		if (pageNo > 1) {
			pre = pageNo - 1;
		} else {
			pre = 1;
		}

		// ������һҳ
		if (pageNo >= totalPage) {
			next = totalPage;
		} else {
			next = pageNo + 1;
		}

		// ������ʼ�к�
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
