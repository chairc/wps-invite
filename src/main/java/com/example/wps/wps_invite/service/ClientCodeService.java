package com.example.wps.wps_invite.service;

import com.example.wps.wps_invite.entity.ResultSet;

/**
 * @auther chairc
 * @date 2021/5/1 21:31
 */
public interface ClientCodeService {

    ResultSet insertClientCode(String clientCode, String client);
}
