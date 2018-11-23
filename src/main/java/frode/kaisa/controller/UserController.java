package frode.kaisa.controller;

import com.sun.org.apache.xpath.internal.operations.Bool;
import frode.kaisa.dao.InfoMapper;
import frode.kaisa.domain.InfoDO;
import frode.kaisa.service.BaseService;
import frode.kaisa.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.util.Date;
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

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private BaseService baseService;

    @Autowired
    InfoMapper infoMapper;



    @PostMapping("/login")
    @ResponseBody
    Map<String, Object> userLogin(@RequestParam("userId") Long userId, @RequestParam("password") String password, HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> modelMap=new HashMap<>();
        if(userService.valLogin(userId,password)){
            //sessionService.saveSession(request);
            logger.info(userId+"进行登录操作！");
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

    @RequestMapping(value = "/transaction", method = { RequestMethod.POST,RequestMethod.GET })
    String  transaction(HttpServletRequest request,HttpServletResponse response){
        String ids = request.getParameter("ids");
        String[] strings = ids.split(",");
        Long[] idArray = new Long[strings.length];
        for (int i = 0; i < strings.length; i++) {
            idArray[i] = Long.valueOf(strings[i]);
        }
        //String result = baseService.transaction(idArray);
        return baseService.transaction(idArray);
    }

    //测试插入对象
    @ResponseBody
    @RequestMapping(value = "/insertInfo", method = { RequestMethod.POST,RequestMethod.GET })
    Map insertInfo(HttpServletRequest request,HttpServletResponse response){
        Map<String,Object> map = new HashMap<>();
        InfoDO infoDO = new InfoDO();
       // infoDO.setInfoId(2L);//Long型需要加大L标记  主键一般不赋值
        infoDO.setUserId(Long.valueOf(request.getParameter("userId")));
        infoDO.setLatitude(Double.valueOf(request.getParameter("latitude")));//纬度36.66959
        infoDO.setLongitude(Double.valueOf(request.getParameter("longitude")));//经度 东
        //infoDO.setLoginTime(LocalDateTime.now());
        Boolean result = infoMapper.saveInfo(infoDO);
        System.out.println(result);
        map.put("result","success");
        return map;
        //return "success";
    }
}