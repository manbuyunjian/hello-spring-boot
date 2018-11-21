package com.mall.hello.spring.boot.controller;


import io.itit.itf.okhttp.FastHttpClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    /**
     *
     * @return index
     */
    @RequestMapping(value = "hello",method = RequestMethod.GET)
    public String getWechatOpenid(){
        return "index，hello";
    }

    @RestController
    @RequestMapping("/wx")
    public class GetOpenId {
        private String appid = "wx177a01d06745b0da";
        private String appsecret = "a85dfb7306e5ff0a66f79b9a0904152c";
        private String url = "";
        private String resp = "";

        @RequestMapping(value = "/getOpenId", method = RequestMethod.GET)
        public String getOpenId(@RequestParam(required = true) String code) throws Exception {
            System.out.println("申请的code值为 " + code);
            url = "https://api.weixin.qq.com/sns/jscode2session?appid=" + appid+
                    "&secret=" + appsecret + "&js_code=" + code + "&grant_type=authorization_code";
            resp = FastHttpClient.get().url(url).build().execute().string();
            return resp;
        }
    }
}
