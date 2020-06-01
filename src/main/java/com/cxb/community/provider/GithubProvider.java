package com.cxb.community.provider;


import com.alibaba.fastjson.JSON;
import com.cxb.community.dto.AccessTokenDTO;
import com.cxb.community.dto.GithubUserDTO;
import okhttp3.*;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class GithubProvider {
    public static final MediaType mediaType
            = MediaType.get("application/json; charset=utf-8");

    OkHttpClient client = new OkHttpClient();

    String post(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, mediaType);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }

    String post(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }


    public String getAccessToken(AccessTokenDTO accessTokenDTO){
        String url = "https://github.com/login/oauth/access_token";
        String json = JSON.toJSONString(accessTokenDTO);
        try {
            String string = post(url,json);
            String access_token = string.split("&")[0].split("=")[1];
            return access_token;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public GithubUserDTO getUser(String accessToken){
        String url = "https://api.github.com/user?access_token="+accessToken;
        try {
            GithubUserDTO githubUserDTO = JSON.parseObject(post(url),GithubUserDTO.class);
            return githubUserDTO;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
