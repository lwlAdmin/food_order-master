package com.ljw.food_order_server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FoodOrderServerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    void auto(){
        AutoGenerator autoGenerator = new AutoGenerator();
        autoGenerator.setDatabase("mgc");
        autoGenerator.setUsername("root");
        autoGenerator.setPassword("root");
        String[] tables = {"station","user"};
        autoGenerator.setTables(tables);
        autoGenerator.setIp("192.168.1.101");
        autoGenerator.setPort("3306");
        autoGenerator.setPacketName("com.ljw.food_order_server");
        autoGenerator.setTablePrefix("");
        autoGenerator.auto();
    }

}
