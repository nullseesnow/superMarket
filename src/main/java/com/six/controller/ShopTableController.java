package com.six.controller;

import com.alibaba.fastjson.JSONObject;
import com.six.bean.ShopTable;
import com.six.bean.ShopTableExample;
import com.six.ocr.Check;
import com.six.service.ShopTableService;
import com.six.util.LayUiBean;
import com.six.util.Msg;
import com.sun.xml.internal.bind.v2.schemagen.XmlSchemaGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;
//@RestController
@Controller
@RequestMapping("/shopTable")
public class ShopTableController {
    @Autowired
   private ShopTableService shopTableService;
//分页
    @RequestMapping(value = "/selectByPage")
    @ResponseBody
    public LayUiBean selectByPage(ShopTable shopTable,String sname){
        System.out.println("sname-----------------"+sname);
        System.out.println(sname.length());
        Integer page = shopTable.getPage();
        Integer limit =shopTable.getLimit();
        System.out.println("进入了分页：page---"+page+"-limit----"+limit);
        long offset=(page-1)*4;
        shopTable.setOffset(offset);
        //查总条数
        long count =shopTableService.selectCount(null);
        List<ShopTable> productInfos = null ;
        if("".equals(sname)|| null == sname||sname.length()<1){
            productInfos =shopTableService.selectByPage(shopTable);
        }
        if(!"".equals(sname)|| null != sname){
            productInfos =shopTableService.selectByPage2(shopTable,sname);
        }
        //封装layui表格 所需要的 json 字符串
        LayUiBean layUiBean =new LayUiBean();
        layUiBean.setData(productInfos);
        layUiBean.setMsg("success");
        layUiBean.setCode(0);
        layUiBean.setCount(count);
        return layUiBean;

    }
    //查数
    @ResponseBody
    @RequestMapping(value="/countByExample",method= RequestMethod.GET)
    public Msg countByExample(@ModelAttribute ShopTable shopTable){
                 ShopTableExample example = new ShopTableExample();
                 long l = shopTableService.countByExample(example);
                return Msg.success().add("data",l);


    }
/*    @RequestMapping(value="/deleteByExample",method=RequestMethod.DELETE)
    public Msg deleteByExample(@ModelAttribute ShopTable shopTable){

        ShopTableExample example = new ShopTableExample();


        Integer count = shopTableService.deleteByExample(example);

        return Msg.success().add("data",count);
    }*/

    @RequestMapping(value="/deleteByPrimaryKey")
    @ResponseBody
    public Msg  deleteByPrimaryKey(Integer shopId){
          Integer count = shopTableService.deleteByPrimaryKey(shopId);
            if(count>0){
                return Msg.success().add("data",count);
            }else {
                return Msg.fail();
            }

    }

   @RequestMapping(value="/insert",method=RequestMethod.POST)
    public String  insert(@ModelAttribute ShopTable shopTable){
        Integer count = shopTableService.insert(shopTable);
        return "market/shopList";

    }

    @RequestMapping(value="/insertSelective",method=RequestMethod.POST)
    public Msg insertSelective(@ModelAttribute ShopTable shopTable){
        Integer count = shopTableService.insertSelective(shopTable);
        return Msg.success().add("data",count);
    }

    @RequestMapping("/selectByExample")
    @ResponseBody
    public Msg selectByExample(@ModelAttribute ShopTable shopTable, HttpServletRequest request){
        System.out.println("shopTable------------------------"+shopTable);
        ShopTableExample example = new ShopTableExample();
        List<ShopTable> list = shopTableService.selectByExample(example);
        request.setAttribute("shopList",list);
        System.out.println("list"+list);
        return Msg.success().add("data",list);
    }





    @RequestMapping(value="/selectByPrimaryKey",method=RequestMethod.GET)
    public Msg selectByPrimaryKey(Integer id){
        ShopTable shopTable = shopTableService.selectByPrimaryKey(id);
        return Msg.success().add("data",shopTable);
    }
    //商品
    @RequestMapping(value="/updateByPrimaryKey",method=RequestMethod.POST)
    public String updateByPrimaryKey(@ModelAttribute  ShopTable record){
        Integer updateId = shopTableService.updateByPrimaryKey(record);
        if(updateId>0){
            return "market/shopList";
        }
        return "market/404";
    }
    @RequestMapping(value="/updateByExampleSelective",method=RequestMethod.PUT)
    public Msg updateByExampleSelective(@ModelAttribute ShopTable shopTable){
        ShopTableExample example = new ShopTableExample();

        Integer updateId = shopTableService.updateByExampleSelective(shopTable,example);
        return  Msg.success().add("data",updateId);
    }
    @RequestMapping(value="/updateByPrimaryKeySelective",method=RequestMethod.PUT)
    public Msg updateByPrimaryKeySelective(@ModelAttribute ShopTable shopTable){
        Integer updateId = shopTableService.updateByPrimaryKeySelective(shopTable);
        return Msg.success().add("data",updateId);
    }
    @RequestMapping(value="/updateByExample",method=RequestMethod.PUT)
    public Msg updateByExample(@ModelAttribute ShopTable shopTable){
        ShopTableExample example = new ShopTableExample();

        Integer updateId = shopTableService.updateByExample(shopTable,example);
        return Msg.success().add("data",updateId);
    }

//图片上传

@ResponseBody
@RequestMapping(value="/upload",method=RequestMethod.POST)
public String  upload(HttpServletRequest request, @RequestParam("file") MultipartFile file) throws Exception {
    //如果文件不为空，写入上传路径
    System.out.println("进入上传");
    System.out.println("判断路径是否为空----y/n");
    if (!file.isEmpty()) {
        System.out.println("y");
        //上传文件路径
        String path= request.getServletContext().getRealPath("WEB-INF/res/static/upImg");
            /*String path1=request.getServletPath();
            System.out.println("path1"+path1);*/
        System.out.println("path"+path);
        //上传文件名
        String filename = file.getOriginalFilename();
        File filepath = new File(path, filename);
        System.out.println("filename:" + filename);
        System.out.println("filepath:" + filepath);

        //判断路径是否存在，如果不存在就创建一个
        if (!filepath.getParentFile().exists()) {
            filepath.getParentFile().mkdirs();
        }
        //将上传文件保存到一个目标文件当中
//D:\Users\28606\IdeaProjects\superMarket
        file.transferTo(new File("F:\\WorkSpace\\IdeaProjects\\superMarket\\target\\superMarket\\WEB-INF\\res\\static\\upImg"+ File.separator + filename));
        //file.transferTo(new File(path+ File.separator + filename));
        String newUrl="../../res/static/upImg/"+filename;
        return newUrl;
    }
    return "market/404";
}

    @RequestMapping("/mohuByAI")
    @ResponseBody
    public Msg mohu(String fname){
        System.out.println("进入mohuByAI"+fname);
        String imgName = Check.findImgName(fname);

        System.out.println("人生巅峰=-----------------"+imgName+"----------------");

        return Msg.success().add("shopName",imgName);
    }
}
