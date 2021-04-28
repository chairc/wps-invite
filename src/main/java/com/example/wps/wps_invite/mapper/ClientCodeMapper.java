package com.example.wps.wps_invite.mapper;

import com.example.wps.wps_invite.entity.ClientCode;
import org.apache.ibatis.annotations.Mapper;

/**
 * @auther chairc
 * @date 2021/4/28 13:36
 */
@Mapper
public interface ClientCodeMapper {
    ClientCode getClientCode();
}
