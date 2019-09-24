package com.donnie.grow.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisSample {

    private static final String REDIS_HOST = "localhost";
    private static final int REDIS_PORT = 6379;
    private static final String REDIS_PASS = "redis123";

    public static void main(String[] args) {

        /*直接连接方式*/
        Jedis jedis = new Jedis(REDIS_HOST, REDIS_PORT);
        jedis.auth(REDIS_PASS);
        String rsp = jedis.set("test","112233");
        System.out.println("redis set rsp:" + rsp);
        String value = jedis.get("test");
        System.out.println("redis get value:" + value);
        jedis.close();

        /*连接池连接方式*/
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);
        config.setMaxIdle(10);
        JedisPool pool = new JedisPool(config, REDIS_HOST, REDIS_PORT, 300, REDIS_PASS);
        Jedis client = null;
        try {
            client = pool.getResource();
            client.setex("test1", 2, "445566");
            System.out.println("redis get value:" + client.get("test1"));
            Thread.sleep(3000);
            System.out.println("redis get value:" + client.get("test1"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            client.close();
        }
    }


}
