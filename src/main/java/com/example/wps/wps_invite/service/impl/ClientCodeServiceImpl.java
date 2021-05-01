package com.example.wps.wps_invite.service.impl;

import com.example.wps.wps_invite.entity.ResultSet;
import com.example.wps.wps_invite.mapper.ClientCodeMapper;
import com.example.wps.wps_invite.service.ClientCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @auther chairc
 * @date 2021/5/1 21:32
 */
@Service
public class ClientCodeServiceImpl implements ClientCodeService {

    private static final Logger log = LoggerFactory.getLogger(ClientCodeServiceImpl.class); //slf4j

    private ClientCodeMapper clientCodeMapper;

    @Autowired
    public ClientCodeServiceImpl(ClientCodeMapper clientCodeMapper) {
        this.clientCodeMapper = clientCodeMapper;
    }

    /**
     * 新增client_code和client参数
     *
     * @param clientCode 客户端码
     * @param client     客户端类型
     * @return 成功或异常
     */

    @Override
    public ResultSet insertClientCode(String clientCode, String client) {
        ResultSet resultSet = new ResultSet();
        try {
            clientCodeMapper.insertClientCode(clientCode, client);
            resultSet.ok("insert client code success");
            log.info("insert client code success");
        } catch (Exception e) {
            log.error("insert client code error:{}", e.toString());
            resultSet.fail("insert client code error");
        }
        return resultSet;
    }
}
