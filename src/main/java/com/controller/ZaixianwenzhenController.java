package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.ZaixianwenzhenEntity;
import com.entity.view.ZaixianwenzhenView;

import com.service.ZaixianwenzhenService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 在线问诊
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-17 21:50:48
 */
@RestController
@RequestMapping("/zaixianwenzhen")
public class ZaixianwenzhenController {
    @Autowired
    private ZaixianwenzhenService zaixianwenzhenService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ZaixianwenzhenEntity zaixianwenzhen,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yisheng")) {
			zaixianwenzhen.setYishenggonghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("huanzhe")) {
			zaixianwenzhen.setHuanzhezhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ZaixianwenzhenEntity> ew = new EntityWrapper<ZaixianwenzhenEntity>();

		PageUtils page = zaixianwenzhenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zaixianwenzhen), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ZaixianwenzhenEntity zaixianwenzhen, 
		HttpServletRequest request){
        EntityWrapper<ZaixianwenzhenEntity> ew = new EntityWrapper<ZaixianwenzhenEntity>();

		PageUtils page = zaixianwenzhenService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, zaixianwenzhen), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ZaixianwenzhenEntity zaixianwenzhen){
       	EntityWrapper<ZaixianwenzhenEntity> ew = new EntityWrapper<ZaixianwenzhenEntity>();
      	ew.allEq(MPUtil.allEQMapPre( zaixianwenzhen, "zaixianwenzhen")); 
        return R.ok().put("data", zaixianwenzhenService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ZaixianwenzhenEntity zaixianwenzhen){
        EntityWrapper< ZaixianwenzhenEntity> ew = new EntityWrapper< ZaixianwenzhenEntity>();
 		ew.allEq(MPUtil.allEQMapPre( zaixianwenzhen, "zaixianwenzhen")); 
		ZaixianwenzhenView zaixianwenzhenView =  zaixianwenzhenService.selectView(ew);
		return R.ok("查询在线问诊成功").put("data", zaixianwenzhenView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ZaixianwenzhenEntity zaixianwenzhen = zaixianwenzhenService.selectById(id);
        return R.ok().put("data", zaixianwenzhen);
    }

    /**
     * 前台详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ZaixianwenzhenEntity zaixianwenzhen = zaixianwenzhenService.selectById(id);
        return R.ok().put("data", zaixianwenzhen);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ZaixianwenzhenEntity zaixianwenzhen, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zaixianwenzhen);
        zaixianwenzhenService.insert(zaixianwenzhen);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ZaixianwenzhenEntity zaixianwenzhen, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(zaixianwenzhen);
        zaixianwenzhenService.insert(zaixianwenzhen);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ZaixianwenzhenEntity zaixianwenzhen, HttpServletRequest request){
        //ValidatorUtils.validateEntity(zaixianwenzhen);
        zaixianwenzhenService.updateById(zaixianwenzhen);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        zaixianwenzhenService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
