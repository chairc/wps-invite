package com.example.wps.wps_invite;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class WpsInviteApplicationTests {

    @Test
    void contextLoads() {
        /*Thread t1 = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                System.out.println("t1=" + i);
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println("t2=" + i);
            }
        });
        t1.start();
        t2.start();*/
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(5 * 1000); //设置暂停的时间 5 秒
                System.out.println(sdf.format(new Date()) + "--循环执行第" + (i + 1) + "次");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
