package com.playtika.log;

import org.junit.Test;

/**
 * Unit test for simple TestLoggerApplication.
 */
public class TestLoggerApplicationTest {
    @Test
    public void testRunLoggingInOneThread() throws Exception {
        TestLoggerApplication application = new TestLoggerApplication();
        application.logMessage(application.createTestBean());
    }

    @Test
    public void testRunLoggingInOneThreadWithCount() throws Exception {
        TestLoggerApplication application = new TestLoggerApplication();
        application.logMessages(1000);
    }

    @Test
    public void testRunLoggingInParallel() throws Exception {
        TestLoggerApplication application = new TestLoggerApplication();
        application.logMessagesInParallel(1000000);
    }
}
