package com.jontian;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * Created by zhongjun on 8/5/17.
 */
@Service
public class Util {

    @Async
    public <T> void doAsync(Runnable runnable) {
        runnable.run();
    }

    @Transactional
    public <T> T doTransactional(Supplier<T> supplier){
        return supplier.get();
    }
    public static void sleep(long ms){
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
