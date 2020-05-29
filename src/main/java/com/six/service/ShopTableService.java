package com.six.service;

import com.six.bean.ShopTable;
import com.six.bean.ShopTableExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopTableService {
   
    long countByExample(ShopTableExample example);

    int deleteByExample(ShopTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShopTable record);

    int insertSelective(ShopTable record);

    List<ShopTable> selectByExample(ShopTableExample example);

    List<ShopTable> selectByExample01(ShopTableExample example);

    ShopTable selectByPrimaryKey(Integer id);
  
    int updateByExampleSelective(@Param("record") ShopTable record, @Param("example") ShopTableExample example);

    int updateByExample(@Param("record") ShopTable record, @Param("example") ShopTableExample example);

    int updateByPrimaryKeySelective(ShopTable record);

    int updateByPrimaryKey(ShopTable record);

    List<ShopTable> selectByPage(ShopTable shopTable);
    List<ShopTable> selectByPage2(ShopTable shopTable,String sname);

    long selectCount(ShopTableExample example);
}
