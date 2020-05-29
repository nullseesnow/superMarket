package com.six.service;

import com.six.bean.BillTable;
import com.six.bean.BillTableExample;
import com.six.mapper.BillTableDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("billTableService")
public class BillTableServiceImpl implements BillTableService{
	@Autowired
	private BillTableDAO billTableDao;
	public long countByExample(BillTableExample example){
    	return billTableDao.countByExample(example);
    }

	public int deleteByExample(BillTableExample example){
    	return billTableDao.deleteByExample(example);
    }

	public int deleteByPrimaryKey(Integer id){
    	return billTableDao.deleteByPrimaryKey(id);
    }

	public int insert(BillTable record){
    	return billTableDao.insert(record);
    }

	public int insertSelective(BillTable record){
    	return billTableDao.insertSelective(record);
    }

	public List<BillTable> selectByExample(BillTableExample example){
    	return billTableDao.selectByExample(example);
    }

	public BillTable selectByPrimaryKey(Integer id){
    	return billTableDao.selectByPrimaryKey(id);
    }
  
	public int updateByExampleSelective(BillTable record, BillTableExample example){
    	return billTableDao.updateByExampleSelective(record, example);
    }

	public int updateByExample(BillTable record, BillTableExample example){
    	return billTableDao.updateByExample(record, example);
    }

	public int updateByPrimaryKeySelective(BillTable record){
    	return billTableDao.updateByPrimaryKeySelective(record);
    }

	public int updateByPrimaryKey(BillTable record){
    	return billTableDao.updateByPrimaryKey(record);
    }
}
