package service.Imp;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.UserMapper;

import entity.User;
import entity.page;
import service.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserMapper mapper;

	public List<User> getAll() {
		return mapper.getAll();
	}


	@SuppressWarnings({ "rawtypes", "unchecked" })
	public page getPage(Map map) {
		page pb = new page();

		// ȡ��ҳ��
		int pageNo = (Integer) map.get("pageNo");
		pb.setPageNo(pageNo);

		// �Ȳ�ѯ������
		int count = mapper.getCount(map);
		pb.setCount(count);

		// �������������0,��������ҳ��ѯ
		if (count > 0) {

			// ������ʼ��,pageSize
			map.put("start", pb.getStart());
			map.put("pageSize", pb.getPageSize());

			// ��ѯ��ҳ����
			List<User> list = mapper.getPage(map);

			// ��������䵽PageBean��,������
			pb.setList(list);
		}

		return pb;
	}

}
