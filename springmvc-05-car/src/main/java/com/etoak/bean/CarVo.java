package com.etoak.bean;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarVo  extends Car{
	private String levelName;
	private String gearboxName;
	private String outputVolumeName;
	
	@JsonIgnore
	private List<Map<String,Integer>>priceMapList;
	
	//前端车龄
	@JsonIgnore
	public String vehicleAge;
	
	//传到SQL条件
	@JsonIgnore
	private Integer startYear;
	//传到SQL条件
	@JsonIgnore
	private Integer endYear;
	
	
	
}
