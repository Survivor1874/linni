package com.learn.linni.common.utils;

import okhttp3.OkHttpClient;

import java.util.concurrent.TimeUnit;

/**
 * @author linjun.li@quvideo.com
 * @date 2019-01-23 09:54
 **/
public class HttpClientFactory {

    private static OkHttpClient client;

    public static OkHttpClient getClient() {
        if (client == null) {
            synchronized (HttpClientFactory.class) {
                if (client == null) {
                    client = new OkHttpClient.Builder()
                            .connectTimeout(3, TimeUnit.SECONDS)
                            .readTimeout(3, TimeUnit.SECONDS)
                            .writeTimeout(3, TimeUnit.SECONDS)
                            .build();
                }
            }
        }
        return client;
    }

}
