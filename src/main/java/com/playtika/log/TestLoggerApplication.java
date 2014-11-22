package com.playtika.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Hello world!
 */
public class TestLoggerApplication {
    private final Logger logger = LoggerFactory.getLogger(TestLoggerApplication.class);
    private ExecutorService executorService = Executors.newFixedThreadPool(250);

    void logMessages(int count) {
        TestBean testBean = createTestBean();
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
