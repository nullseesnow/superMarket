package com.six.service;

import com.six.bean.BillTable;
import com.six.bean.BillTableExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BillTableService {
   
    long countByExample(BillTableExample example);

    int deleteByExample(BillTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BillTable record);

    int insertSelective(BillTable record);

    List<BillTable> selectByExample(BillTableExample example);

    BillTable selectByPrimaryKey(Integer id);
  
    int updateByExampleSelective(@Param("record") BillTable record, @Param("example") BillTableExample example);

    int updateByExample(@Param("record") BillTable record, @Param("example") BillTableExample example);

    int updateByPrimaryKeySelective(BillTable record);

    int updateByPrimaryKey(BillTable record);
}
