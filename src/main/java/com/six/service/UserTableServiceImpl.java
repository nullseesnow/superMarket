package com.six.service;

import com.six.bean.UserTable;
import com.six.bean.UserTableExample;
import com.six.mapper.UserTableDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userTableService")
public class UserTableServiceImpl implements UserTableService{
	@Autowired
	private UserTableDAO userTableDao;
	public long countByExample(UserTableExample example){
    	return userTableDao.countByExample(example);
    }

	public int deleteByExample(UserTableExample example){
    	return userTableDao.deleteByExample(example);
    }

	public int deleteByPrimaryKey(Integer id){
    	return userTableDao.deleteByPrimaryKey(id);
    }

	public int insert(UserTable record){
    	return userTableDao.insert(record);
    }

	public int insertSelective(UserTable record){
    	return userTableDao.insertSelective(record);
    }

	public List<UserTable> selectByExample(UserTableExample example){
    	return userTableDao.selectByExample(example);
    }

	public UserTable selectByPrimaryKey(Integer id){
    	return userTableDao.selectByPrimaryKey(id);
    }
  
	public int updateByExampleSelective(UserTable record, UserTableExample example){
    	return userTableDao.updateByExampleSelective(record, example);
    }

	public int updateByExample(UserTable record, UserTableExample example){
    	return userTableDao.updateByExample(record, example);
    }

	public int updateByPrimaryKeySelective(UserTable record){
    	return userTableDao.updateByPrimaryKeySelective(record);
    }

	public int updateByPrimaryKey(UserTable record){
    	return userTableDao.updateByPrimaryKey(record);
    }


	public int updateByPrimaryKey1(UserTable record) {
		return userTableDao.updateByPrimaryKey1(record);
	}

	public List<UserTable> selectTaskByLimit(UserTable task) {
		return userTableDao.selectTaskByLimit(task);
	}

	@Override
	public List<UserTable> findByName(String userName) {
		System.out.println("输出测试---------------------："+userName);
		return userTableDao.findByName(userName);
	}
}
