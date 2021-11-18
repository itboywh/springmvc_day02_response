package com.itboy.controller;

import com.itboy.domin.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author wh
 * @date 2021年11月13日16:43
 */
@RequestMapping("/user")
@Controller
public class UserController {
    @RequestMapping("/teststring")
    public String testString(Model model){
        User user=new User();
        user.setUsername("小明");
        user.setPassword("123456");
        model.addAttribute("user",user);
        return "success";
    }

    /**
     * 请求转发执行一次
     */
    @RequestMapping("/testvoid")
    public void testVoid(HttpServletRequest request,HttpServletResponse response) throws Exception{
        System.out.println("testVoid方法执行了");
       // 请求转发执行一次
       //  request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
        //重定向
      // response.sendRedirect(request.getContextPath()+"/index.jsp");
        //解决中文乱码
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/http;charset=utf-8");
        //服务器直接响应给客户端
        response.getWriter().print("你好，世界");
        return;
    }

    /**
     * 和model方法类似
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView mv= new ModelAndView();
        User user=new User();
        user.setUsername("小明");
        user.setPassword("123456");
        //将user对象存入到model对象中，把user对象存入到request对象
        mv.addObject("user",user);
        //视图调整到哪个对象
        mv.setViewName("success");
        return mv;
    }
    @RequestMapping("/testForwordorRedirect")
    public String testForwordorRedirect(){
        System.out.println("testForwordorRedirect方法执行了");
        //forword转发一次执行
        // return "forward:/WEB-INF/pages/success.jsp";
        //redirect重定向
        return "redirect:/index.jsp";
    }
    //模拟异步请求1
    @RequestMapping("/testJson")
    public void testJson(@RequestBody String body){
        System.out.println(body);
    }
    //异步请求响应对象2
    @RequestMapping("/testAjax")
    public @ResponseBody User testJson(@RequestBody User user) {
        //前端发送的是ajax请求,传的是json,后端把json字符封装到user对象中
        System.out.println(user);
        //修改前端username
        user.setUsername("小华");
        return user;
    }
}
