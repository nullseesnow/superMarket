package com.six.service;

import com.six.bean.UserTable;
import com.six.bean.UserTableExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserTableService {
   
    long countByExample(UserTableExample example);

    int deleteByExample(UserTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserTable record);

    int insertSelective(UserTable record);

    List<UserTable> selectByExample(UserTableExample example);

    UserTable selectByPrimaryKey(Integer id);
  
    int updateByExampleSelective(@Param("record") UserTable record, @Param("example") UserTableExample example);

    int updateByExample(@Param("record") UserTable record, @Param("example") UserTableExample example);

    int updateByPrimaryKeySelective(UserTable record);

    int updateByPrimaryKey(UserTable record);
    int updateByPrimaryKey1(UserTable record);
    //bootstrap  样式进行  分页  传入实体就是  查询信息进行分页
    List<UserTable> selectTaskByLimit(UserTable userTable);
    List<UserTable> findByName(String userName);
    //List<UserTable> selectAllUser();

}
