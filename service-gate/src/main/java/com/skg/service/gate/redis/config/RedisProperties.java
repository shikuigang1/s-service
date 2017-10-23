package com.skg.service.gate.redis.config;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//@Component
//@ConfigurationProperties(prefix = "redis.cluster")
public class RedisProperties {

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    private int maxIdle = 10;

    public int getMaxTotal() {
        return maxTotal;
    }
    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }
    /**
     * 最大连接数
     */
    private int maxTotal = 500;

    public int getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(int maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    private int maxWaitMillis = 3000;

    /** redis集群节点 */
    private String nodes;
    /** 连接超时时间 */
    private int timeout;
    /** 重连次数 */
    private int maxAttempts;
    public String getNodes() {
        return nodes;
    }
    public void setNodes(String nodes) {
        this.nodes = nodes;
    }
    public int getTimeout() {
        return timeout;
    }
    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
    public int getMaxAttempts() {
        return maxAttempts;
    }
    public void setMaxAttempts(int maxAttempts) {
        this.maxAttempts = maxAttempts;
    }

    private String hostName = "localhost";

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getMaxRedirects() {
        return maxRedirects;
    }

    public void setMaxRedirects(int maxRedirects) {
        this.maxRedirects = maxRedirects;
    }

    public String getMastername() {
        return mastername;
    }

    public void setMastername(String mastername) {
        this.mastername = mastername;
    }

    private String password;

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    /**
     * Maximum number of redirects to follow when executing commands across the
     * cluster.
     */
    private int maxRedirects = 10;

    private String mastername;

}
