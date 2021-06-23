package com.six.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.six.bean.UserTable;
import com.six.bean.UserTableExample;
import com.six.service.UserTableService;
import com.six.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/userTable")
public class UserTableController {
    @Autowired
   private UserTableService userTableService;

    @RequestMapping("/taskAndSchoolAllPage")
    @ResponseBody//不写这个注解  ，不反回json注解  会执行 视图解析器
    public Msg taskAndSchoolAllPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber, UserTableExample example, UserTable userTable) {
        System.out.println(">>>>>>>>>>>>>>>>");
        PageHelper.startPage(pageNumber, 5);


        List<UserTable> userTabkes = userTableService.selectByExample(example);


        System.out.println(userTabkes + "进入控制 层");
        PageInfo<UserTable> TaskPageInfo = new PageInfo<>(userTabkes, 5);
//        System.out.println(userTabkes + "?????????????????????????????????????");
        return Msg.success().add("pageInfo", TaskPageInfo);

    }

    //bootstrap  tabler  插件  进行分页
    @RequestMapping("/selectTaskByLimit")

    public Map<String, Object> selectTaskByLinit(UserTable userTable) {
        //查出总数
        //查出所有  数据
        Map<String, Object> map = new HashMap<>();
        UserTableExample example = new UserTableExample();
        long count = userTableService.countByExample(example);//使用       example  进行查条数
        List<UserTable> tasks = userTableService.selectTaskByLimit(userTable);
//        System.out.println(count + ">>>>>>>>>>>>>>>>>>>>>>>");
        map.put("total", count);
        map.put("rows", tasks);
        return map;

    }
    //模糊查询

    @RequestMapping(value = "/mohu", method = RequestMethod.POST)
    @ResponseBody
    public Msg selectFind(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber, @RequestParam(value = "userName", defaultValue = "") String userName) {

//        System.out.println("LLLL" + pageNumber);


       /* System.out.println("模糊查询");
        System.out.println(userName);*/
        UserTableExample example = new UserTableExample();
        UserTableExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameLike(userName);
        PageHelper.startPage(pageNumber, 5);
        List<UserTable> list = userTableService.findByName("%" + userName + "%");

        PageInfo<UserTable> TaskPageInfo = new PageInfo<>(list, 5);
        System.out.println(list);
        return Msg.success().add("pageInfo", TaskPageInfo);


    }


    /*    @RequestMapping(value="/deleteByExample",method=RequestMethod.DELETE)
        public Msg deleteByExample(@ModelAttribute UserTable userTable){

            UserTableExample example = new UserTableExample();


            Integer count = userTableService.deleteByExample(example);

            return Msg.success().add("data",count);
        }*/
//删除
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Msg deleteByPrimaryKey(Integer userId) {
        System.out.println("删除界面");
        System.out.println(userId+"<><><><");
        Integer count = userTableService.deleteByPrimaryKey(userId);
        System.out.println(count + ">>>>>>>>>>>>>>");
        return Msg.success().add("count", count);
    }

//添加
    @RequestMapping( "/insert")
    @ResponseBody
    public Msg insert(@ModelAttribute UserTable userTable) {
        System.out.println("添加后台");
        System.out.println(userTable.getUserName() + "????????");
        Integer count = userTableService.insertSelective(userTable);
        System.out.println(Msg.success());
        return Msg.success().add("data", count);

    }

    @RequestMapping(value = "/insertSelective")
    @ResponseBody
    public Msg insertSelective(UserTable userTable) {


        System.out.println("进来了");
        String name = userTable.getUserName();
        System.out.println(name);
        Integer count = userTableService.insertSelective(userTable);
        return Msg.success().add("data", count);

    }

    @RequestMapping(value = "/selectByExample", method = RequestMethod.GET)
    public Msg selectByExample(@ModelAttribute UserTable userTable) {
        UserTableExample example = new UserTableExample();
        List<UserTable> list = userTableService.selectByExample(example);
        return Msg.success().add("data", list);
    }

//跟据ID 查询

    @RequestMapping(value = "/selectByPrimaryKey", method = RequestMethod.GET)

    public String selectByPrimaryKey(Integer userId, HttpServletRequest request) {
        System.out.println(userId);
        UserTable userTable = userTableService.selectByPrimaryKey(userId);
        request.setAttribute("userTable", userTable);
        System.out.println("id 查询界面");
        System.out.println(userTable.getUserName());
        return "market/userView";
    }

    //修改 查询
    @RequestMapping(value = "/selectByPrimaryKey1", method = RequestMethod.GET)

    public String selectByPrimaryKey1(Integer userId, HttpServletRequest request) {
        System.out.println("修改查询界面");
        System.out.println(userId);
        UserTable userTable = userTableService.selectByPrimaryKey(userId);
        request.setAttribute("userTable", userTable);
        System.out.println("修改 查询界面");
        System.out.println(userTable.getUserName());
        return "market/userUpdate";
    }

    @RequestMapping(value = "/updateByPrimaryKey", method = RequestMethod.PUT)

    public Msg updateByPrimaryKey(@ModelAttribute UserTable record) {
        System.out.println(
                "修改界面"
        );
        System.out.println(record.getUserName());
        Integer updateId = userTableService.updateByPrimaryKey(record);

        return Msg.success().add("data", updateId);
    }

    @RequestMapping(value = "/updateByExampleSelective", method = RequestMethod.PUT)
    public Msg updateByExampleSelective(@ModelAttribute UserTable userTable) {
        UserTableExample example = new UserTableExample();

        Integer updateId = userTableService.updateByExampleSelective(userTable, example);
        return Msg.success().add("data", updateId);
    }

    @RequestMapping(value = "/updateByPrimaryKeySelective")

    public Msg updateByPrimaryKeySelective(@ModelAttribute UserTable userTable) {


        Integer updateId = userTableService.updateByPrimaryKeySelective(userTable);
        return Msg.success().add("data", updateId);
    }

    @RequestMapping(value = "/updateByExample", method = RequestMethod.PUT)
    public Msg updateByExample(@ModelAttribute UserTable userTable) {
        System.out.println("修改界面");
        UserTableExample example = new UserTableExample();

        Integer updateId = userTableService.updateByExample(userTable, example);
        return Msg.success().add("data", updateId);
    }


    @RequestMapping(value="/login1")
    public String login1(@ModelAttribute UserTable userTable, HttpSession session, HttpServletRequest request, HttpServletResponse response, String isLogin)throws Exception{
        UserTableExample example = new UserTableExample();
        UserTableExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userTable.getUserName());
        criteria.andUserPwdEqualTo(userTable.getUserPwd());
        List<UserTable> list = userTableService.selectByExample(example);
        if (list.size()>0){
        String userName = list.get(0).getUserName();
            session.setAttribute("userName",userName);
            session.setAttribute("list",list.get(0));
            session.setAttribute("userId",list.get(0).getUserId());
           /* UserTable list1 = (UserTable) session.getAttribute("list");
            Integer userId = list1.getUserId();
            criteria.andUserIdEqualTo(userId);
            UserTable userTable1 = userTableService.selectByPrimaryKey(userId);
            String userPwd = userTable.getUserPwd();*/

            if ("y".equals(isLogin)){
                String userName1 = userTable.getUserName();
                String userPwd1 = userTable.getUserPwd();

                Cookie nameCookie = new Cookie("userName", URLEncoder.encode(userName1, "UTF-8"));
                Cookie pwdCookie = new Cookie("userPwd", URLEncoder.encode(userPwd1, "UTF-8"));
                //成功
                nameCookie.setMaxAge(60*60*24*7);
                pwdCookie.setMaxAge(60*60*24*7);
                nameCookie.setPath("/");
                pwdCookie.setPath("/");
                nameCookie.setHttpOnly(false);
                pwdCookie.setHttpOnly(false);
                response.addCookie(nameCookie);
                response.addCookie(pwdCookie);
            }
        return "market/index";
        }else {
           request.setAttribute("msg1","账户或者密码错误");
            return "market/login3";
        }
    }

    @RequestMapping(value="/insertSelective1")
    public String insertSelective1(@ModelAttribute UserTable userTable){
        System.out.println(userTable);
        Integer count = userTableService.insertSelective(userTable);
        if (count>0){

        return "market/login4";
        }else {
            return "market/regist";
        }
    }

    @RequestMapping(value="/selectByExample2")
    @ResponseBody
    public Msg selectByExample2(UserTable userTable, String userName, HttpServletRequest request){
//        System.out.println("111333");
        UserTableExample example = new UserTableExample();
        UserTableExample.Criteria criteria = example.createCriteria();
        criteria.andUserNameEqualTo(userName);

        List<UserTable> list = userTableService.selectByExample(example);
        System.out.println("list"+list);
       // Map<String,Object> resultMap = new HashMap<String, Object>();
        if (list.size()>0){
            //resultMap.put("result1", "success");
            System.out.println("123");
            return Msg.success().add("data",list);
        }else{
       // resultMap.put("result1", "notsuccess");
        return Msg.fail();
    }
    }
    @RequestMapping(value="/clearCookie1")
    public String clearCookie1(HttpSession session,HttpServletResponse response,UserTable userTable)throws Exception{

        UserTable list = (UserTable) session.getAttribute("list");
        System.out.println(list);
        if (list!=null){
            String userName1 = list.getUserName();
            String userPwd1 = list.getUserPwd();
            Cookie nameCookie = new Cookie("userName", URLEncoder.encode(userName1, "UTF-8"));
            Cookie pwdCookie = new Cookie("userPwd", URLEncoder.encode(userPwd1, "UTF-8"));
            nameCookie.setMaxAge(0);
            pwdCookie.setMaxAge(0);
            nameCookie.setPath("/");
            pwdCookie.setPath("/");
            nameCookie.setHttpOnly(false);
            pwdCookie.setHttpOnly(false);
            response.addCookie(nameCookie);
            response.addCookie(pwdCookie);
            session.invalidate();
            System.out.println("11111");
            return "market/login3";
        }else {
            System.out.println("2222");
            return "market/login3";
        }
    }
    @RequestMapping(value="/updateByPrimaryKeyUser")
    public String updateByPrimaryKeyUser(@ModelAttribute  UserTable record){
        System.out.println("修改来了");
        System.out.println(record);
        int i = userTableService.updateByPrimaryKey1(record);
        if (i>0){
        return "market/login3";
    }else {
        return "market/password";
    }

    }
    @RequestMapping(value="/selectByExample3")
    @ResponseBody
    public Msg selectByExample3(@ModelAttribute UserTable userTable,String oldpwd,HttpSession session){
        UserTableExample example = new UserTableExample();
        List<UserTable> list = userTableService.selectByExample(example);
        UserTable list1 = (UserTable) session.getAttribute("list");

        String userPwd = list1.getUserPwd();

        if (userPwd.equals(oldpwd)){
            return Msg.success().add("data",list);
        }else{
            return Msg.fail();
        }
    }
}
