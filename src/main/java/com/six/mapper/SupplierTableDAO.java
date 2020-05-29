package com.six.mapper;

import com.six.bean.SupplierTable;
import com.six.bean.SupplierTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierTableDAO {
    long countByExample(SupplierTableExample example);

    int deleteByExample(SupplierTableExample example);

    int deleteByPrimaryKey(Integer supplierId);

    int insert(SupplierTable record);

    int insertSelective(SupplierTable record);

    List<SupplierTable> selectByExample(SupplierTableExample example);

    SupplierTable selectByPrimaryKey(Integer supplierId);

    int updateByExampleSelective(@Param("record") SupplierTable record, @Param("example") SupplierTableExample example);

    int updateByExample(@Param("record") SupplierTable record, @Param("example") SupplierTableExample example);

    int updateByPrimaryKeySelective(SupplierTable record);

    int updateByPrimaryKey(SupplierTable record);

    List<SupplierTable> selectTaskByLimit(SupplierTable task);
}