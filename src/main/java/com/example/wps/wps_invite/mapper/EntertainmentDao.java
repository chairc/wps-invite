package com.example.wps.wps_invite.mapper;

import com.example.wps.wps_invite.model.Entertainment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EntertainmentDao {
    List<Entertainment> getWpsSidAll();
}
