package com.skg.service.gate.redis.config;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisClusterNode;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisNode;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.util.StringUtils;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

//@Configuration
public class JedisClusterConfig {

    @Autowired
    private RedisProperties redisProperties;

    /**
     * 注意：
     * 这里返回的JedisCluster是单例的，并且可以直接注入到其他类中去使用
     * @return
     */
/*    @Bean
    public JedisCluster getJedisCluster() {
        String[] serverArray = redisProperties.getNodes().split(",");//获取服务器数组(这里要相信自己的输入，所以没有考虑空指针问题)
        Set<HostAndPort> nodes = new HashSet<>();

        for (String ipPort : serverArray) {
            String[] ipPortPair = ipPort.split(":");
            nodes.add(new HostAndPort(ipPortPair[0].trim(), Integer.valueOf(ipPortPair[1].trim())));
        }
        return new JedisCluster(nodes, redisProperties.getTimeout());
    }*/

    public RedisClusterConfiguration redisClusterConfiguration() {

        RedisClusterConfiguration redisClusterConfiguration = new RedisClusterConfiguration();
        String[] hosts = redisProperties.getNodes().split(",");
        Set<RedisNode> redisNodes = new HashSet<RedisNode>();

        for (String ipPort : hosts) {
            String[] ipPortPair = ipPort.split(":");
            redisNodes.add(new RedisClusterNode(ipPortPair[0], Integer.valueOf(ipPortPair[1])));
        }
        redisClusterConfiguration.setClusterNodes(redisNodes);
        redisClusterConfiguration.setMaxRedirects(redisProperties.getMaxRedirects());
        return redisClusterConfiguration;

    }

   // @Bean
    public JedisPoolConfig jedisPoolConfig() {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(redisProperties.getMaxIdle());
        jedisPoolConfig.setMaxTotal(redisProperties.getMaxTotal());
        jedisPoolConfig.setMaxWaitMillis(redisProperties.getMaxWaitMillis());

        return jedisPoolConfig;

    }

 /*   @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisClusterConfiguration(),
                jedisPoolConfig());
        if (!StringUtils.isEmpty(redisProperties.getPassword()))
            jedisConnectionFactory.setPassword(redisProperties.getPassword());
        return jedisConnectionFactory;
    }*/

   // @Bean
    public JedisConnectionFactory jedisConnectionFactoryForSingle() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(
                jedisPoolConfig());
        if (!StringUtils.isEmpty(redisProperties.getPassword()))
            jedisConnectionFactory.setPassword(redisProperties.getPassword());
        return jedisConnectionFactory;
    }

    //@Bean
    public RedisTemplate<String, String> redisTemplate() {

        RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(jedisConnectionFactoryForSingle());
        redisTemplate.setDefaultSerializer(new StringRedisSerializer());

        return redisTemplate;
    }
}