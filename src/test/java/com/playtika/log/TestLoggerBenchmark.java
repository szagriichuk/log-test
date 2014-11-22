package com.playtika.log;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;

/**
 * @author szagriichuk
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
@State(Scope.Thread)
public class TestLoggerBenchmark {
    TestLoggerApplication application = new TestLoggerApplication();
    TestBean testBean = application.createTestBean();

    @Benchmark
    @Threads(1000)
    public void testLoggs() {
        application.logMessage(testBean);
    }
}
