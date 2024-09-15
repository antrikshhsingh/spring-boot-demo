package com.antriksh.employeeservice.annotations;

import com.antriksh.employeeservice.globalexception.RateLimitExceededException;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Before;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class RateLimitingAspect {
    private final Map<String, RequestRateLimiter> limiters = new ConcurrentHashMap<>();

    @Before("@annotation(rateLimit)")
    public void limitRequests(RateLimit rateLimit) {
        String key = "global";  // Simplified key, could be method or user specific

        // Use a rate limiter based on the method (or other criteria)
        RequestRateLimiter rateLimiter = limiters.computeIfAbsent(key, k -> new RequestRateLimiter(rateLimit.requestPerSecond()));

        if (!rateLimiter.allowRequest()) {
            log.error("Rate limited exceeded");
            throw new RateLimitExceededException(rateLimit.message());
        }
    }
}


