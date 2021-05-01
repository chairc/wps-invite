package com.example.wps.wps_invite.service.impl;

import com.example.wps.wps_invite.service.ClientCodeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @auther chairc
 * @date 2021/5/1 21:41
 */
@SpringBootTest
class ClientCodeServiceImplTest {

    private ClientCodeService clientCodeService;

    @Autowired
    public ClientCodeServiceImplTest(ClientCodeService clientCodeService) {
        this.clientCodeService = clientCodeService;
    }

    @Test
    void insertClientCode() {
        clientCodeService.insertClientCode("123","123");
    }
}