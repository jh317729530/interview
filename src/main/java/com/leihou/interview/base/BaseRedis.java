package com.leihou.interview.base;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

public interface BaseRedis {


    String getFullKey(String prefix, String k);

    boolean cacheValue(String prefix, String k, String v, long time);

    String getValue(String prefix, String key);

    boolean containsValueKey(String prefix, String k);

    boolean cacheValue(String k, String v, Date expireDate);

    String cacheValueIfAbsent(String prefix, String k, long time, Supplier<String> supplier);

    /**
     * 移除
     * @param prefix
     * @param k
     * @return
     */
    boolean removeValue(String prefix, String k);

    /**
     * 获取失效的时间
     * @param prefix
     * @param key
     * @return
     */
    Long getExpire(String prefix, String key);

    Boolean setIfAbsent(String k,String v,TimeUnit timeUnit,long time);



}
