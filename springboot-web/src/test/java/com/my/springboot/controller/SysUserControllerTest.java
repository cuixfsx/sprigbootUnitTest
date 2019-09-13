package com.my.springboot.controller;


import com.my.springboot.ControllerTestApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ControllerTestApplication.class)
public class SysUserControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext applicationContext;

    @Before
    public void init() {
        mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext).build();  //初始化
    }

    @Test
    public void testList() throws Exception {
        String responseString = mockMvc.perform(
                get("/sysUser/list")    //请求的url,请求的方法是get
                        .contentType(MediaType.APPLICATION_JSON)  //数据的格式
        ).andExpect(status().isOk())
                .andDo(print())
                .andReturn().getResponse().getContentAsString();   //将相应的数据转换为字符串
        System.out.println("--------返回的json = " + responseString);

    }

}
