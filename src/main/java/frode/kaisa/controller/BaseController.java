package frode.kaisa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: frode
 * @Date: 2018/8/22 12:04
 * @Description: 无前缀控制器
 */
/*@CrossOrigin*/
@Controller
@RequestMapping("")
public class BaseController {


    @RequestMapping(value = "/login", method = { RequestMethod.POST,RequestMethod.GET })
    public String openLogin(){
        return "login";
    }

    @RequestMapping(value = "/index", method = { RequestMethod.POST,RequestMethod.GET })
    public String openIndex(){
        return "index";
    }
}
