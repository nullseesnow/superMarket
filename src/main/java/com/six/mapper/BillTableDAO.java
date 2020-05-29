package com.six.mapper;

import com.six.bean.BillTable;
import com.six.bean.BillTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BillTableDAO {
    long countByExample(BillTableExample example);

    int deleteByExample(BillTableExample example);

    int deleteByPrimaryKey(Integer billId);

    int insert(BillTable record);

    int insertSelective(BillTable record);

    List<BillTable> selectByExample(BillTableExample example);

    BillTable selectByPrimaryKey(Integer billId);

    int updateByExampleSelective(@Param("record") BillTable record, @Param("example") BillTableExample example);

    int updateByExample(@Param("record") BillTable record, @Param("example") BillTableExample example);

    int updateByPrimaryKeySelective(BillTable record);

    int updateByPrimaryKey(BillTable record);
}