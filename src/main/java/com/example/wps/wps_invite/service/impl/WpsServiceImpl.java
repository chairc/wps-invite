package com.example.wps.wps_invite.service.impl;

import com.example.wps.wps_invite.entity.ClientCode;
import com.example.wps.wps_invite.entity.ResultSet;
import com.example.wps.wps_invite.entity.Wps;
import com.example.wps.wps_invite.mapper.ClientCodeMapper;
import com.example.wps.wps_invite.mapper.WpsMapper;
import com.example.wps.wps_invite.service.WpsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @auther chairc
 * @date 2020/5/22 16:43
 */
@Service
@Component
public class WpsServiceImpl implements WpsService {

    private static final Logger log = LoggerFactory.getLogger(WpsServiceImpl.class); //slf4j

    private WpsMapper wpsMapper;

    private ClientCodeMapper clientCodeMapper;

    @Autowired
    public WpsServiceImpl(WpsMapper wpsMapper,ClientCodeMapper clientCodeMapper) {
        this.wpsMapper = wpsMapper;
        this.clientCodeMapper = clientCodeMapper;
    }

    @Value("${wps.wps-invite-path}")
    private String WPS_INVITE_PATH;

    /**
     * 自动签到程序
     *
     * @param uid 用户uid
     * @return 成功或异常
     */

    @Override
    public ResultSet wpsAutoInvite(String uid) {
        ResultSet resultSet = new ResultSet();
        try {
            List<Wps> list = wpsMapper.getWpsSidAll();
            ClientCode clientCodeData = clientCodeMapper.getClientCode();
            //拿到客户端代码，由于客户端代码具有时效性，需要不断更新取最新一条，目前没啥好的解决办法就是抓包存库再使用
            String clientCode = clientCodeData.getClientCode();
            String client = clientCodeData.getClient();
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> map = new HashMap<>();
            map.put("invite_userid", uid);
            map.put("client_code",clientCode);
            map.put("client",client);
            //转成json格式
            String mapToJson = mapper.writeValueAsString(map);
            StringBuilder sb = new StringBuilder();
            URL urlObj = new URL(WPS_INVITE_PATH);

            //循环十次由多个sid进行邀请
            for (Wps wps : list) {
                System.out.println("当前sid为:" + wps.getWpsSid());
                HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
                //post请求不能使用缓存
                conn.setUseCaches(false);
                //设置是否向httpUrlConnection输出，post请求，参数要放在http正文内，因此设为true, 默认情况下是false;
                conn.setDoOutput(true);
                //设置是否从httpUrlConnection读入，默认情况下是true;
                conn.setDoInput(true);
                //设定请求的方法为"POST"，默认是GET
                conn.setRequestMethod("POST");
                //添加请求头header
                conn.setRequestProperty("Host", "zt.wps.cn");
                conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                conn.setRequestProperty("sid", wps.getWpsSid());
                try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), StandardCharsets.UTF_8))) {
                    writer.write(mapToJson);
                    System.out.println(mapToJson);
                    writer.flush();
                }
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), StandardCharsets.UTF_8))) {
                    String tmpLine = reader.readLine();
                    try {
                        ObjectMapper objectMapper = new ObjectMapper();
                        HashMap hashMap = objectMapper.readValue(tmpLine, HashMap.class);
                        String result = (String) hashMap.get("result");
                        if (result.equals("ok")) {
                            System.out.println("当前返回值:" + tmpLine);
                        }
                    } catch (Exception e) {
                        System.out.println("当前sid:" + wps.getWpsSid() + "已失效");
                    }
                }
                conn.disconnect();
                //设置暂停的时间 2 秒
                Thread.sleep(2 * 1000);
            }
            resultSet.ok("success");
            log.info("success");
            return resultSet;
        } catch (IOException | InterruptedException e) {
            log.error("error:{}", e.toString());
            resultSet.fail("error");
            return resultSet;
        }
    }
}
