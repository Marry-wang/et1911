package com.etoak.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.etoak.bean.Car;
import com.etoak.bean.CarVo;
import com.etoak.bean.PageVo;
import com.etoak.mapper.CarMapper;
import com.etoak.service.CarService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
	CarMapper carMapper;

	@Override
	public int addCar(Car car) {
		// TODO Auto-generated method stub
		return carMapper.addCar(car);
	}

	@Override
	public PageVo<CarVo> queryList(int pageNum, int pageSize, CarVo carVo) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum,pageSize);
		
		List<CarVo> carList=carMapper.queryList(carVo);
		
		PageInfo<CarVo> pageInfo=new PageInfo<CarVo>(carList);
		
		
		return new PageVo<CarVo>(pageInfo.getPageNum(),pageInfo.getPageSize(),
				carList,
				pageInfo.getTotal(),
				pageInfo.getPages(),
				pageInfo.isIsFirstPage(),
				pageInfo.isIsLastPage()
				);
	}

	@Override
	public List<String> getAllBrand() {
		// TODO Auto-generated method stub
		return carMapper.getAllBrand();
	}

	@Override
	public List<String> getSeriesByBrand(String brand) {
		// TODO Auto-generated method stub
		return carMapper.getSeriesByBrand(brand);
	}
	
	

}
