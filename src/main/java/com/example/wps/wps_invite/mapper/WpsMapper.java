package com.example.wps.wps_invite.mapper;

import com.example.wps.wps_invite.entity.Wps;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface WpsMapper {
    List<Wps> getWpsSidAll();
}
