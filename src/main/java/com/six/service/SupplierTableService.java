package com.six.service;

import com.six.bean.SupplierTable;
import com.six.bean.SupplierTableExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SupplierTableService {
   
    long countByExample(SupplierTableExample example);

    int deleteByExample(SupplierTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SupplierTable record);

    int insertSelective(SupplierTable record);

    List<SupplierTable> selectByExample(SupplierTableExample example);

    SupplierTable selectByPrimaryKey(Integer id);
  
    int updateByExampleSelective(@Param("record") SupplierTable record, @Param("example") SupplierTableExample example);

    int updateByExample(@Param("record") SupplierTable record, @Param("example") SupplierTableExample example);

    int updateByPrimaryKeySelective(SupplierTable record);

    int updateByPrimaryKey(SupplierTable record);


    List<SupplierTable> selectTaskByLimit(SupplierTable supplierTable);
}
