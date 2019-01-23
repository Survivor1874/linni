package com.learn.linni.common.utils;

import com.alibaba.fastjson.JSON;
import okhttp3.*;

import java.io.IOException;

/**
 * @author linjun.li@quvideo.com
 * @date 2019-01-23 09:52
 **/
public class HttpUtils {

    public static String message() {
        String url = "http://vid-qa.x2api.com/officialMessage/search";
        String json = "{ \n" +
                "    \"communities\": [ \"hi\",\"ta\" ], \n" +
                "    \"languages\": [ \"hi\",\"ta\" ], \n" +
                "    \"messageId\": \"123\",\n" +
                "     \"startTime\": \"2019-01-23T10:47:50.988Z\", \n" +
                "     \"tagretType\": \"2\", \n" +
                "     \"tags\": [ \"1\",\"2\" ],\n" +
                "    \"targetContent\": \"123,1233,12333\",\n" +
                "     \"versions\": [ \"2.7.0\" ]\n" +
                "}";
        RequestBody body = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        return response(request);
    }

    private static String response(Request request) {
        OkHttpClient client = HttpClientFactory.getClient();
        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful() && response.body() != null) {
                return response.body().string();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(message());
    }



}
