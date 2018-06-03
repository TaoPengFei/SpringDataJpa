package tpf.spring.data.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import tpf.spring.data.jpa.entity.User;
import tpf.spring.data.jpa.service.RegisterService;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: 陶鹏飞
 * @Description:
 * @Date: 2018/6/3-19:38
 * @email: taopengfei1223@foxmail.com
 **/

@Controller
public class RegisterController {

//    register
    @Autowired
    private RegisterService registerService;

    @RequestMapping("/register")
    public String register(){
        return "/register";
    }

    @RequestMapping("/login")
    public String login(){
        return "redirect:/login.jsp";
    }

//    @RequestMapping("/userRegister")
    @RequestMapping(value = "userRegister", method = RequestMethod.POST)
    @ResponseBody
//    public Map<String,Object> updateDeptEmpTree(@RequestBody Map<String, Object> param){
    public String updateDeptEmpTree(@RequestBody Map<String, Object> param){

        /*Map<String, Object> result = new HashMap<>();
        User user = new User();*/
        /*int rowCount =  */registerService.saveUser((User) map2Object(param, User.class));
        System.out.println((User) map2Object(param, User.class));
//        int rowCount = iEmpService.updateDeptEmpTree(param);
        /*try {
            if ( rowCount > 0 ) {
                result.put("code", 1);
                result.put("msg", "操作成功");
            } else {
                result.put("code", 0);
                result.put("msg", "操作失败");
            }
        } catch (Exception e) {
            result.put("code", -1);
            result.put("msg", e.getMessage());
        }*/
//        return result;
        return "redirect:/login.jsp";
    }

    /**
     * 实体对象转成Map
     * @param obj 实体对象
     * @return
     */
    public static Map<String, Object> object2Map(Object obj) {
        Map<String, Object> map = new HashMap<>();
        if (obj == null) {
            return map;
        }
        Class clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();
        try {
            for (Field field : fields) {
                field.setAccessible(true);
                map.put(field.getName(), field.get(obj));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    /**
     * Map转成实体对象
     * @param map map实体对象包含属性
     * @param clazz 实体对象类型
     * @return
     */
    public static Object map2Object(Map<String, Object> map, Class<?> clazz) {
        if (map == null) {
            return null;
        }
        Object obj = null;
        try {
            obj = clazz.newInstance();

            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field : fields) {
                int mod = field.getModifiers();
                if (Modifier.isStatic(mod) || Modifier.isFinal(mod)) {
                    continue;
                }
                field.setAccessible(true);
                field.set(obj, map.get(field.getName()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }

}
