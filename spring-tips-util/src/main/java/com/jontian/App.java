package com.jontian;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

/**
 * Created by jtian on 6/19/2017.
 */
@SpringBootApplication
@Component
@EnableAsync
public class App implements CommandLineRunner {
    @Autowired
    Util util;

    public void run(String... strings) throws Exception {
        util.doAsync(()->{
            for(int i=0; i<10; i++) {
                Util.sleep(1);
                System.out.println("async");
            }
        });
        for(int i=0; i<10; i++) {
            Util.sleep(1);
            System.out.println("hello world");
        }
    }

    public static void main(String args[]) {
        SpringApplication.run(App.class);
    }
}

