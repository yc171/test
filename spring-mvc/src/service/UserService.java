package service;

import java.util.List;
import java.util.Map;

import entity.User;
import entity.page;

public interface UserService {
	page getPage(Map<?, ?> map);

	List<User> getAll();

}
