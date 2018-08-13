package com.leihou.interview.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.concurrent.CountDownLatch;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    private MockMvc mockMvc;

    @Resource
    private UserController userController;

    private int thread_num;

    /**
     * 开始时间
     */
    private static long startTime = 0L;

    private String method;

    @Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        thread_num = 2000;
        method = "highConcurrencyCreate";
//        method = "create";
    }




    @Test
    @Transactional
    public void testCreat() throws InterruptedException {

        startTime = System.currentTimeMillis();
        System.out.println("CountDownLatch started at: " + startTime);
        // 初始化计数器为1
        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < thread_num; i++) {
            String loginid = "abc" + i;
            new Thread(() ->{
                // 线程等待
                try {
                    countDownLatch.await();
                    mockMvc.perform(MockMvcRequestBuilders.get("/user/"+method).param("loginid",loginid).param("password","123456"))
                            .andExpect(MockMvcResultMatchers.status().isOk());

                    long endTime = System.currentTimeMillis();
                    System.out.println(Thread.currentThread().getName() + " ended at: " + endTime + ", cost: " + (endTime - startTime) + " ms.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }).start();
        }
        // 启动多个线程
        countDownLatch.countDown();
        Thread.sleep(20000);
    }
}
