package com.codespace.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "thread.pool.executor.config", ignoreInvalidFields = true)
public class ThreadPoolConfigProperties {
        private Integer corePoolSize = 10;
        private Integer maxPoolSize = 10;
        private Long keepAliveTime = 10L;
        private Integer blockQueueSize = 5000;

        private String policy = "AbortPolicy";

}
