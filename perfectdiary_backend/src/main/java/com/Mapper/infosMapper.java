package com.Mapper;

import com.Obj.infoObj;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface infosMapper {
    public void insertInfo(infoObj obj);
    public List<infoObj> selectAllByUsername(String username);
    public void delByTimestamp(@Param("timeStamp") String timeStamp, @Param("userName") String userName);
}
