package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.ZhenduanjiluDao;
import com.entity.ZhenduanjiluEntity;
import com.service.ZhenduanjiluService;
import com.entity.vo.ZhenduanjiluVO;
import com.entity.view.ZhenduanjiluView;

@Service("zhenduanjiluService")
public class ZhenduanjiluServiceImpl extends ServiceImpl<ZhenduanjiluDao, ZhenduanjiluEntity> implements ZhenduanjiluService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ZhenduanjiluEntity> page = this.selectPage(
                new Query<ZhenduanjiluEntity>(params).getPage(),
                new EntityWrapper<ZhenduanjiluEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ZhenduanjiluEntity> wrapper) {
		  Page<ZhenduanjiluView> page =new Query<ZhenduanjiluView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ZhenduanjiluVO> selectListVO(Wrapper<ZhenduanjiluEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ZhenduanjiluVO selectVO(Wrapper<ZhenduanjiluEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ZhenduanjiluView> selectListView(Wrapper<ZhenduanjiluEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ZhenduanjiluView selectView(Wrapper<ZhenduanjiluEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
