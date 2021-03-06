package com.homework.web;

import com.homework.domain.UserDO;
import com.homework.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * Created by jiangyayi on 15/12/10.
 */
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/index.html")
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value="/loginCheck.html")
    public ModelAndView loginCheck(HttpServletRequest request,LoginCommand loginCommand){
        boolean isValidUser=userService.hasMatchUser(loginCommand.getUserName(),loginCommand.getPassword());
        if(!isValidUser){
            return  new ModelAndView("login","error","用户名或密码错误");
        }else {
            UserDO userDO=userService.findUserByUserName(loginCommand.getUserName());
            userDO.setLastIp(request.getRemoteAddr());
            userDO.setLastVisit(new Date());
            userService.loginSuccess(userDO);
            request.getSession().setAttribute("user",userDO);
            return  new ModelAndView("main");

        }
    }
}
