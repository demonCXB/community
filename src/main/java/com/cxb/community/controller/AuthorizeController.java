package com.cxb.community.controller;

import com.cxb.community.dto.AccessTokenDTO;
import com.cxb.community.dto.GithubUserDTO;
import com.cxb.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;

    @Value("${github.client.id}")
    private String client_id;

    @Value("${github.client.secret}")
    private String client_secret;

    @Value("${github.redirect_uri}")
    private String redirect_uri;


    @GetMapping("/callback")
    public String callback(@RequestParam(name="code") String code ,
                           @RequestParam(name = "state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_uri(redirect_uri);
        accessTokenDTO.setState(state);
        accessTokenDTO.setClient_id(client_id);
        accessTokenDTO.setClient_secret(client_secret);
        String access_token = githubProvider.getAccessToken(accessTokenDTO);
        GithubUserDTO githubUserDTO = githubProvider.getUser(access_token);
        return "index";
    }
}
