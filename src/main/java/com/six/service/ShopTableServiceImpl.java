package com.six.service;

import com.six.bean.ShopTable;
import com.six.bean.ShopTableExample;
import com.six.mapper.ShopTableDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("shopTableService")
public class ShopTableServiceImpl implements ShopTableService{
	@Autowired
	private ShopTableDAO shopTableDao;
	public long countByExample(ShopTableExample example){
    	return shopTableDao.countByExample(example);
    }

	public int deleteByExample(ShopTableExample example){
    	return shopTableDao.deleteByExample(example);
    }

	public int deleteByPrimaryKey(Integer id){
    	return shopTableDao.deleteByPrimaryKey(id);
    }

	public int insert(ShopTable record){
    	return shopTableDao.insert(record);
    }

	public int insertSelective(ShopTable record){
    	return shopTableDao.insertSelective(record);
    }

	public List<ShopTable> selectByExample(ShopTableExample example){
    	return shopTableDao.selectByExample(example);
    }

    @Override
    public List<ShopTable> selectByExample01(ShopTableExample example) {
        return shopTableDao.selectByExample01(example);
    }

    public ShopTable selectByPrimaryKey(Integer id){
    	return shopTableDao.selectByPrimaryKey(id);
    }
  
	public int updateByExampleSelective(ShopTable record, ShopTableExample example){
    	return shopTableDao.updateByExampleSelective(record, example);
    }

	public int updateByExample(ShopTable record, ShopTableExample example){
    	return shopTableDao.updateByExample(record, example);
    }

	public int updateByPrimaryKeySelective(ShopTable record){
    	return shopTableDao.updateByPrimaryKeySelective(record);
    }

	public int updateByPrimaryKey(ShopTable record){
    	return shopTableDao.updateByPrimaryKey(record);
    }

    @Override
    public List<ShopTable> selectByPage(ShopTable shopTable) {

	    return shopTableDao.selectByPage(shopTable);
    }

    @Override
    public List<ShopTable> selectByPage2(ShopTable shopTable, String sname) {
	    shopTable.setShopName("%"+sname+"%");
        System.out.println(shopTable+"-------------------------------------");
        return shopTableDao.selectByPage2(shopTable);
    }

    @Override
    public long selectCount(ShopTableExample example) {
        return shopTableDao.countByExample(example);
    }
}
