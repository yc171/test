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

		// 取出页号
		int pageNo = (Integer) map.get("pageNo");
		pb.setPageNo(pageNo);

		// 先查询总条数
		int count = mapper.getCount(map);
		pb.setCount(count);

		// 如果总条数等于0,不用做分页查询
		if (count > 0) {

			// 设置起始行,pageSize
			map.put("start", pb.getStart());
			map.put("pageSize", pb.getPageSize());

			// 查询分页数据
			List<User> list = mapper.getPage(map);

			// 把数据填充到PageBean中,并返回
			pb.setList(list);
		}

		return pb;
	}

}
