package com.playtika.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Hello world!
 */
public class TestLoggerApplication {
    private final Logger logger = LoggerFactory.getLogger(TestLoggerApplication.class);
    private ExecutorService executorService = Executors.newFixedThreadPool(250);
    TestBean testBean = createTestBean();


    void logMessagesInParallel(int threadCount) {
        List<Future> futures = new ArrayList<Future>();
        for (int i = 0; i < threadCount; i++) {
            futures.add(executorService.submit(new Runnable() {
                @Override
                public void run() {
                    logMessages(10);
                }
            }));
        }
        for (Future future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    void logMessages(int count) {
        for (int i = 0; i < count; i++) {
            logMessage(testBean);
        }
    }

    void logMessage(TestBean testBean) {
        logger.error("This is test error message. With test bean {} ", testBean);
    }

    TestBean createTestBean() {
        return new TestBean("testName", 1, new String[]{"test1", "test2", "test3", "test4", UUID.randomUUID().toString()},
                new ArrayList<String>() {{
                    add(UUID.randomUUID().toString());
                    add(UUID.randomUUID().toString());
                    add(UUID.randomUUID().toString());
                }});
    }
}
