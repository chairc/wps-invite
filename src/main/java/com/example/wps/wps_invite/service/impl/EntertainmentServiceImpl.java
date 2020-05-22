package com.example.wps.wps_invite.service.impl;

import com.example.wps.wps_invite.mapper.EntertainmentDao;
import com.example.wps.wps_invite.model.Entertainment;
import com.example.wps.wps_invite.service.EntertainmentService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EntertainmentServiceImpl implements EntertainmentService {
    @Autowired
    private EntertainmentDao entertainmentDao;

    @Override
    public String wpsAutoInvite(String uid) {
        try {
            List<Entertainment> list = entertainmentDao.getWpsSidAll();
            ObjectMapper mapper = new ObjectMapper();
            Map<String, String> map = new HashMap<>();
            String url = "https://zt.wps.cn/2018/clock_in/api/invite";
            map.put("invite_userid", uid);
            //转成json格式
            String mapToJson = mapper.writeValueAsString(map);
            StringBuilder sb = new StringBuilder();
            URL urlObj = new URL(url);

            //循环十次由10个sid进行邀请
            for (Entertainment entertainment : list) {
                System.out.println("当前sid为:" + entertainment);
                HttpURLConnection conn = (HttpURLConnection) urlObj.openConnection();
                //post请求不能使用缓存
                conn.setUseCaches(false);
                // 设置是否向httpUrlConnection输出，post请求，参数要放在http正文内，因此设为true, 默认情况下是false;
                conn.setDoOutput(true);
                // 设置是否从httpUrlConnection读入，默认情况下是true;
                conn.setDoInput(true);
                // 设定请求的方法为"POST"，默认是GET
                conn.setRequestMethod("POST");
                //添加请求头header
                conn.setRequestProperty("Host", "zt.wps.cn");
                conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");
                conn.setRequestProperty("sid", entertainment.getWps_sid());
                try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"))) {
                    writer.write(mapToJson);
                    System.out.println(mapToJson);
                    writer.flush();
                }
                try (BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"))) {
                    String tmpLine;
                    while ((tmpLine = reader.readLine()) != null) {
                        sb.append(tmpLine);
                    }
                    System.out.println("sb:" + sb);
                }
                conn.disconnect();
            }
            return "1";
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
