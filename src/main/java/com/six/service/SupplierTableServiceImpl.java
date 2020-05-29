package com.six.service;

import com.six.bean.SupplierTable;
import com.six.bean.SupplierTableExample;
import com.six.mapper.SupplierTableDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("supplierTableService")
public class SupplierTableServiceImpl implements SupplierTableService{
	@Autowired
	private SupplierTableDAO supplierTableDao;

	public long countByExample(SupplierTableExample example){
		return supplierTableDao.countByExample(example);
	}

	public int deleteByExample(SupplierTableExample example){
		return supplierTableDao.deleteByExample(example);
	}

	public int deleteByPrimaryKey(Integer id){
		return supplierTableDao.deleteByPrimaryKey(id);
	}

	public int insert(SupplierTable record){
		return supplierTableDao.insert(record);
	}

	public int insertSelective(SupplierTable record){
		return supplierTableDao.insertSelective(record);
	}

	public List<SupplierTable> selectByExample(SupplierTableExample example){
		return supplierTableDao.selectByExample(example);
	}

	public SupplierTable selectByPrimaryKey(Integer id){
		return supplierTableDao.selectByPrimaryKey(id);
	}

	public int updateByExampleSelective(SupplierTable record, SupplierTableExample example){
		return supplierTableDao.updateByExampleSelective(record, example);
	}

	public int updateByExample(SupplierTable record, SupplierTableExample example){
		return supplierTableDao.updateByExample(record, example);
	}

	public int updateByPrimaryKeySelective(SupplierTable record){
		return supplierTableDao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(SupplierTable record){
		return supplierTableDao.updateByPrimaryKey(record);
	}

	@Override
	public List<SupplierTable> selectTaskByLimit(SupplierTable task) {
		return supplierTableDao.selectTaskByLimit(task);
	}


}
