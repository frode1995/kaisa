package frode.kaisa.controller;

import frode.kaisa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: frode
 * @Date: 2018/8/22 11:53
 * @Description:
 */
@CrossOrigin
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    @ResponseBody
    Map<String, Object> userLogin(@RequestParam("userId") Long userId, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> modelMap=new HashMap<>();
        if(userService.valLogin(userId,password)){
            //sessionService.saveSession(request);
            modelMap.put("code",1);//1成功 2失败
            modelMap.put("msg","登录成功");
            return modelMap;
        }else{
            modelMap.put("code",0);
            modelMap.put("msg","登录失败");
            return modelMap;
        }
    }

    @RequestMapping(value = "/index", method = { RequestMethod.POST,RequestMethod.GET })
    String  main(){
        return "index";
    }

}