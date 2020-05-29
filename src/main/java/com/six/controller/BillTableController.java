package com.six.controller;

import com.six.bean.BillTable;
import com.six.bean.BillTableExample;
import com.six.service.BillTableService;
import com.six.util.Msg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/billTable")
public class BillTableController {
    @Autowired
   private BillTableService billTableService;

    //查全
    @RequestMapping(value="/countByExample",method= RequestMethod.GET)
    public Msg countByExample(@ModelAttribute BillTable billTable){
                 BillTableExample example = new BillTableExample();
                 long l = billTableService.countByExample(example);
                return Msg.success().add("data",l);


    }
/*    @RequestMapping(value="/deleteByExample",method=RequestMethod.DELETE)
    public Msg deleteByExample(@ModelAttribute BillTable billTable){

        BillTableExample example = new BillTableExample();


        Integer count = billTableService.deleteByExample(example);

        return Msg.success().add("data",count);
    }*/

    @RequestMapping(value="/deleteByPrimaryKey",method=RequestMethod.DELETE)
    public Msg deleteByPrimaryKey(Integer id){

          Integer count = billTableService.deleteByPrimaryKey(id);

            return Msg.success().add("data",count);
    }

   /* @RequestMapping(value="/insert",method=RequestMethod.POST)
    public Msg insert(@ModelAttribute BillTable billTable){
        Integer count = billTableService.insert(billTable);
        return Msg.success().add("data",count);

    }*/

    @RequestMapping(value="/insertSelective",method=RequestMethod.POST)
    public Msg insertSelective(@ModelAttribute BillTable billTable){
        Integer count = billTableService.insertSelective(billTable);
        return Msg.success().add("data",count);
    }

    @RequestMapping(value="/selectByExample",method=RequestMethod.GET)
    public Msg selectByExample(@ModelAttribute BillTable billTable){
        BillTableExample example = new BillTableExample();
        List<BillTable> list = billTableService.selectByExample(example);
        return Msg.success().add("data",list);
    }




    @RequestMapping(value="/selectByPrimaryKey",method=RequestMethod.GET)
    public Msg selectByPrimaryKey(Integer id){
        BillTable billTable = billTableService.selectByPrimaryKey(id);
        return Msg.success().add("data",billTable);
    }

    @RequestMapping(value="/updateByPrimaryKey",method=RequestMethod.PUT)
    public Msg updateByPrimaryKey(@ModelAttribute  BillTable record){
        Integer updateId = billTableService.updateByPrimaryKey(record);

        return  Msg.success().add("data",updateId);
    }
    @RequestMapping(value="/updateByExampleSelective",method=RequestMethod.PUT)
    public Msg updateByExampleSelective(@ModelAttribute BillTable billTable){
        BillTableExample example = new BillTableExample();

        Integer updateId = billTableService.updateByExampleSelective(billTable,example);
        return  Msg.success().add("data",updateId);
    }
    @RequestMapping(value="/updateByPrimaryKeySelective",method=RequestMethod.PUT)
    public Msg updateByPrimaryKeySelective(@ModelAttribute BillTable billTable){
        Integer updateId = billTableService.updateByPrimaryKeySelective(billTable);
        return Msg.success().add("data",updateId);
    }
    @RequestMapping(value="/updateByExample",method=RequestMethod.PUT)
    public Msg updateByExample(@ModelAttribute BillTable billTable){
        BillTableExample example = new BillTableExample();

        Integer updateId = billTableService.updateByExample(billTable,example);
        return Msg.success().add("data",updateId);
    }


}
