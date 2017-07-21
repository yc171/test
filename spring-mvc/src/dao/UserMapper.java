package dao;

import java.util.List;
import java.util.Map;

import entity.User;


public interface UserMapper {

	List<User> getPage(Map<?, ?> map);

	List<User> getAll();

	int getCount(Map<?, ?> map);
}
