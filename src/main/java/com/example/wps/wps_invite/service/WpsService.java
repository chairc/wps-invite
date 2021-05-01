package com.example.wps.wps_invite.service;

import com.example.wps.wps_invite.entity.ResultSet;

/**
 * @auther chairc
 * @date 2020/5/22 16:43
 */
public interface WpsService {
    ResultSet wpsAutoInvite(String uid);

    ResultSet insertInviteSid(String sid);
}
