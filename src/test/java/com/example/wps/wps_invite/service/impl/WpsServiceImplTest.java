package com.example.wps.wps_invite.service.impl;

import com.example.wps.wps_invite.mapper.WpsMapper;
import com.example.wps.wps_invite.service.WpsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @auther chairc
 * @date 2021/2/28 21:51
 */
@SpringBootTest
class WpsServiceImplTest {

    private WpsService wpsService;

    @Autowired
    public WpsServiceImplTest(WpsService wpsService) {
        this.wpsService = wpsService;
    }

    @Test
    void wpsAutoInvite() {
    }

    @Test
    void insertInviteSid() {
        wpsService.insertInviteSid("123");
    }
}