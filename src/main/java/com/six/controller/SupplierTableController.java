package com.six.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.six.bean.SupplierTable;
import com.six.bean.SupplierTableExample;
import com.six.service.SupplierTableService;
import com.six.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/supplierTable")
public class SupplierTableController {
    @Autowired
    private SupplierTableService supplierTableService;


    @RequestMapping("/taskAndSchoolAllPage")
    @ResponseBody//不写这个注解  ，不反回json注解  会执行 视图解析器
    public Msg taskAndSchoolAllPage(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber, SupplierTableExample example, SupplierTable supplierTable) {
//        System.out.println(">>>>>>>>>>>>>>>>");
        PageHelper.startPage(pageNumber, 5);


        List<SupplierTable> supplierTables = supplierTableService.selectByExample(example);


//        System.out.println(supplierTables + "进入控制 层");
        PageInfo<SupplierTable> TaskPageInfo = new PageInfo<>(supplierTables, 5);
//        System.out.println(supplierTables + "?????????????????????????????????????");
        return Msg.success().add("pageInfo", TaskPageInfo);

    }

    //bootstrap  tabler  插件  进行分页
    @RequestMapping("/selectTaskByLimit")
    @ResponseBody
    public Map<String, Object> selectTaskByLimit(SupplierTable supplierTable) {
        //查出总数
        //查出所有  数据
        Map<String, Object> map = new HashMap<>();
        SupplierTableExample example = new SupplierTableExample();
        long count = supplierTableService.countByExample(example);//使用       example  进行查条数
        List<SupplierTable> tasks = supplierTableService.selectTaskByLimit(supplierTable);
        System.out.println(count + ">>>>>>>>>>>>>>>>>>>>>>>");
        map.put("total", count);
        map.put("rows", tasks);
        return map;


    }
    //模糊查询

    @RequestMapping(value = "/mohu", method = RequestMethod.POST)
    @ResponseBody

    public Msg slectFind(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,@RequestParam(value = "supplierName", defaultValue = "") String supplierName) {
        System.out.println("LLLL"+pageNumber);

        System.out.println("模糊查询");
        System.out.println(supplierName);

        SupplierTableExample example = new SupplierTableExample();
        SupplierTableExample.Criteria criteria = example.createCriteria();
        criteria.andSupplierNameLike(supplierName);

        PageHelper.startPage(pageNumber, 5);
//        List<SupplierTable> list=  supplierTableService.findByName("%"+supplierName+"%");
//        PageInfo<SupplierTable> TaskPageInfo = new PageInfo<>(list, 5);
//        System.out.println(list);
//        return Msg.success().add("TaskPageInfo", TaskPageInfo);
        return null;

    }

    /*    @RequestMapping(value="/deleteByExample",method=RequestMethod.DELETE)
        public Msg deleteByExample(@ModelAttribute SupplierTable supplierTable){

            SupplierTableExample example = new SupplierTableExample();


            Integer count = supplierTableService.deleteByExample(example);

            return Msg.success().add("data",count);
        }*/
    //删除
    @RequestMapping(value="/delete")
    public String  deleteByPrimaryKey(Integer supplierId){
        System.out.println("删除界面");
        System.out.println(supplierId+"<><><><");
        Integer count = supplierTableService.deleteByPrimaryKey(supplierId);
        System.out.println(count + ">>>>>>>>>>>>>>");
        return "market/providerList";
    }

    @RequestMapping(value="/insert",method=RequestMethod.POST)
    @ResponseBody
    //添加
    public Msg insert(@ModelAttribute SupplierTable supplierTable){
        System.out.println("添加后台");
        System.out.println(supplierTable.getSupplierName()+"????????");
        Integer count = supplierTableService.insert(supplierTable);
        System.out.println(Msg.success());
        return Msg.success().add("data",count);

    }

    @RequestMapping(value="/insertSelective",method=RequestMethod.POST)
    public Msg insertSelective(@ModelAttribute SupplierTable supplierTable){
        String name=  supplierTable.getSupplierName();
        System.out.println(name);
        Integer count = supplierTableService.insertSelective(supplierTable);
        return Msg.success().add("data",count);
    }

    @RequestMapping(value="/selectByExample",method=RequestMethod.GET)
    public Msg selectByExample(@ModelAttribute SupplierTable supplierTable){
        SupplierTableExample example = new SupplierTableExample();
        List<SupplierTable> list = supplierTableService.selectByExample(example);
        return Msg.success().add("data",list);
    }


//根据ID查询

    @RequestMapping(value="/selectByPrimaryKey")
    public String selectByPrimaryKey(Integer supplierId, HttpServletRequest request){
        System.out.println(supplierId);
        SupplierTable supplierTable = supplierTableService.selectByPrimaryKey(supplierId);
        request.setAttribute("supplierTable",supplierTable);
        System.out.println("id 查询界面");
        System.out.println(supplierTable.getSupplierName());
        return  "market/providerView";
    }

    //修改 查询
    @RequestMapping(value = "/selectByPrimaryKey1")
    public String selectByPrimaryKey1(Integer supplierId, HttpServletRequest request) {
        System.out.println("修改查询界面");
        System.out.println(supplierId);
        SupplierTable supplierTable = supplierTableService.selectByPrimaryKey(supplierId);
        request.setAttribute("supplierTable",supplierTable);
        System.out.println("修改 查询界面");
        System.out.println(supplierTable.getSupplierName());
        return  "market/providerUpdate";
    }
    @RequestMapping(value = "/updateByPrimaryKey")
    public Msg updateByPrimaryKey(@ModelAttribute SupplierTable record) {
        System.out.println(
                "修改界面"
        );
        System.out.println(record.getSupplierName());
        Integer updateId = supplierTableService.updateByPrimaryKey(record);

        return Msg.success().add("data", updateId);
    }

    @RequestMapping(value="/updateByExampleSelective",method=RequestMethod.PUT)
    public Msg updateByExampleSelective(@ModelAttribute SupplierTable supplierTable){
        SupplierTableExample example = new SupplierTableExample();

        Integer updateId = supplierTableService.updateByExampleSelective(supplierTable,example);
        return  Msg.success().add("data",updateId);
    }
    @RequestMapping(value="/updateByPrimaryKeySelective")
    public Msg updateByPrimaryKeySelective(@ModelAttribute SupplierTable supplierTable){
        System.out.println("updateByPrimaryKeySelective+++++++++++++++++++"+supplierTable);
        Integer updateId = supplierTableService.updateByPrimaryKeySelective(supplierTable);
        return Msg.success().add("data",updateId);
    }
    @RequestMapping(value="/updateByExample",method=RequestMethod.PUT)
    public Msg updateByExample(@ModelAttribute SupplierTable supplierTable){
        System.out.println("修改界面");
        SupplierTableExample example = new SupplierTableExample();

        Integer updateId = supplierTableService.updateByExample(supplierTable,example);
        return Msg.success().add("data",updateId);
    }


}
