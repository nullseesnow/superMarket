package com.six.mapper;

import com.six.bean.ShopTable;
import com.six.bean.ShopTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShopTableDAO {
    long countByExample(ShopTableExample example);

    int deleteByExample(ShopTableExample example);

    int deleteByPrimaryKey(Integer shopId);

    int insert(ShopTable record);

    int insertSelective(ShopTable record);

    List<ShopTable> selectByExample(ShopTableExample example);

    List<ShopTable> selectByExample01(ShopTableExample example);

    ShopTable selectByPrimaryKey(Integer shopId);

    int updateByExampleSelective(@Param("record") ShopTable record, @Param("example") ShopTableExample example);

    int updateByExample(@Param("record") ShopTable record, @Param("example") ShopTableExample example);

    int updateByPrimaryKeySelective(ShopTable record);

    int updateByPrimaryKey(ShopTable record);

    List<ShopTable> selectByPage(ShopTable shopTable);

    List<ShopTable> selectByPage2(ShopTable shopTable);
    int delById(Integer id);
}