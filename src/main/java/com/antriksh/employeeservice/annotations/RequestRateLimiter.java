package com.antriksh.employeeservice.annotations;

import java.time.Instant;
import java.util.concurrent.atomic.AtomicInteger;

public class RequestRateLimiter {

    private final int maxRequestsPerSecond;
    private final AtomicInteger requestCount = new AtomicInteger(0);
    private long windowStart;

    public RequestRateLimiter(int maxRequestsPerSecond) {
        this.maxRequestsPerSecond = maxRequestsPerSecond;
        this.windowStart = Instant.now().toEpochMilli();
    }

    public synchronized boolean allowRequest() {
        long currentTime = Instant.now().toEpochMilli();
        long windowDuration = 1000; // 1 second in milliseconds

        if (currentTime - windowStart > windowDuration) {
            // Reset count and window start after the window has passed
            requestCount.set(0);
            windowStart = currentTime;
        }

        // Increment the count and check if it's within the allowed range
        return requestCount.incrementAndGet() <= maxRequestsPerSecond;
    }
}
