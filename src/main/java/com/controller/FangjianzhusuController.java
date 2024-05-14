
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 住宿信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/fangjianzhusu")
public class FangjianzhusuController {
    private static final Logger logger = LoggerFactory.getLogger(FangjianzhusuController.class);

    @Autowired
    private FangjianzhusuService fangjianzhusuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private FangjianService fangjianService;
    @Autowired
    private YonghuService yonghuService;



    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("员工".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = fangjianzhusuService.queryPage(params);

        //字典表数据转换
        List<FangjianzhusuView> list =(List<FangjianzhusuView>)page.getList();
        for(FangjianzhusuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        FangjianzhusuEntity fangjianzhusu = fangjianzhusuService.selectById(id);
        if(fangjianzhusu !=null){
            //entity转view
            FangjianzhusuView view = new FangjianzhusuView();
            BeanUtils.copyProperties( fangjianzhusu , view );//把实体数据重构到view中

                //级联表
                FangjianEntity fangjian = fangjianService.selectById(fangjianzhusu.getFangjianId());
                if(fangjian != null){
                    BeanUtils.copyProperties( fangjian , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setFangjianId(fangjian.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(fangjianzhusu.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody FangjianzhusuEntity fangjianzhusu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,fangjianzhusu:{}",this.getClass().getName(),fangjianzhusu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("员工".equals(role))
            fangjianzhusu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<FangjianzhusuEntity> queryWrapper = new EntityWrapper<FangjianzhusuEntity>()
            .eq("fangjian_id", fangjianzhusu.getFangjianId())
            .eq("yonghu_id", fangjianzhusu.getYonghuId())
            .eq("fangjianzhusu_name", fangjianzhusu.getFangjianzhusuName())
            .eq("fangjianzhusu_phone", fangjianzhusu.getFangjianzhusuPhone())
            .eq("zhusu_number", fangjianzhusu.getZhusuNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangjianzhusuEntity fangjianzhusuEntity = fangjianzhusuService.selectOne(queryWrapper);
        if(fangjianzhusuEntity==null){
            fangjianzhusu.setCreateTime(new Date());
            fangjianzhusuService.insert(fangjianzhusu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody FangjianzhusuEntity fangjianzhusu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,fangjianzhusu:{}",this.getClass().getName(),fangjianzhusu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("员工".equals(role))
//            fangjianzhusu.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<FangjianzhusuEntity> queryWrapper = new EntityWrapper<FangjianzhusuEntity>()
            .notIn("id",fangjianzhusu.getId())
            .andNew()
            .eq("fangjian_id", fangjianzhusu.getFangjianId())
            .eq("yonghu_id", fangjianzhusu.getYonghuId())
            .eq("fangjianzhusu_name", fangjianzhusu.getFangjianzhusuName())
            .eq("fangjianzhusu_phone", fangjianzhusu.getFangjianzhusuPhone())
            .eq("zhusu_number", fangjianzhusu.getZhusuNumber())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        FangjianzhusuEntity fangjianzhusuEntity = fangjianzhusuService.selectOne(queryWrapper);
        if(fangjianzhusuEntity==null){
            fangjianzhusuService.updateById(fangjianzhusu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        fangjianzhusuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<FangjianzhusuEntity> fangjianzhusuList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            FangjianzhusuEntity fangjianzhusuEntity = new FangjianzhusuEntity();
//                            fangjianzhusuEntity.setFangjianId(Integer.valueOf(data.get(0)));   //房间 要改的
//                            fangjianzhusuEntity.setYonghuId(Integer.valueOf(data.get(0)));   //员工 要改的
//                            fangjianzhusuEntity.setFangjianzhusuName(data.get(0));                    //预约用户名称 要改的
//                            fangjianzhusuEntity.setFangjianzhusuPhone(data.get(0));                    //联系方式 要改的
//                            fangjianzhusuEntity.setFangjianzhusuTime(sdf.parse(data.get(0)));          //预约时间 要改的
//                            fangjianzhusuEntity.setZhusuNumber(Integer.valueOf(data.get(0)));   //住宿天数 要改的
//                            fangjianzhusuEntity.setCreateTime(date);//时间
                            fangjianzhusuList.add(fangjianzhusuEntity);


                            //把要查询是否重复的字段放入map中
                                //联系方式
                                if(seachFields.containsKey("fangjianzhusuPhone")){
                                    List<String> fangjianzhusuPhone = seachFields.get("fangjianzhusuPhone");
                                    fangjianzhusuPhone.add(data.get(0));//要改的
                                }else{
                                    List<String> fangjianzhusuPhone = new ArrayList<>();
                                    fangjianzhusuPhone.add(data.get(0));//要改的
                                    seachFields.put("fangjianzhusuPhone",fangjianzhusuPhone);
                                }
                        }

                        //查询是否重复
                         //联系方式
                        List<FangjianzhusuEntity> fangjianzhusuEntities_fangjianzhusuPhone = fangjianzhusuService.selectList(new EntityWrapper<FangjianzhusuEntity>().in("fangjianzhusu_phone", seachFields.get("fangjianzhusuPhone")));
                        if(fangjianzhusuEntities_fangjianzhusuPhone.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(FangjianzhusuEntity s:fangjianzhusuEntities_fangjianzhusuPhone){
                                repeatFields.add(s.getFangjianzhusuPhone());
                            }
                            return R.error(511,"数据库的该表中的 [联系方式] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        fangjianzhusuService.insertBatch(fangjianzhusuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
