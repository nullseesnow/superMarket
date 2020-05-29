package com.six.mapper;

import com.six.bean.UserTable;
import com.six.bean.UserTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTableDAO {
    long countByExample(UserTableExample example);

    int deleteByExample(UserTableExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(UserTable record);

    int insertSelective(UserTable record);

    List<UserTable> selectByExample(UserTableExample example);

    UserTable selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") UserTable record, @Param("example") UserTableExample example);

    int updateByExample(@Param("record") UserTable record, @Param("example") UserTableExample example);

    int updateByPrimaryKeySelective(UserTable record);

    int updateByPrimaryKey(UserTable record);

    List<UserTable> selectTaskCount(UserTableExample example);
    //bootstrap  样式进行  分页  传入实体就是  查询信息进行分页
    List<UserTable> selectTaskByLimit(UserTable task);

    int updateByPrimaryKey1(UserTable record);

    //模糊查询
    List<UserTable> findByName(String userName);
}