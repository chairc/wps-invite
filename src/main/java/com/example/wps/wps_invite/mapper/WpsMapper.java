package com.example.wps.wps_invite.mapper;

import com.example.wps.wps_invite.entity.Wps;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @auther chairc
 * @date 2020/5/22 16:43
 */
@Mapper
public interface WpsMapper {

    List<Wps> getWpsSidAll();

    void insertInviteSid(String sid);
}
