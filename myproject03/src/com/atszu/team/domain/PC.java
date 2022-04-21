/**
 * 
 */
package com.atszu.team.domain;

/**   
 * @ClassName:  PC   
 * @Description:台式机的信息   
 * @author: lsy
 * @date:   2021年11月30日 下午9:04:03      
 * @Copyright:  
 */
public class PC implements Equipment {
	
	private String model; // 机器型号
	
	private String display;//显示器名称
	
	public PC(String model, String display) {
		super();
		this.model = model;
		this.display = display;
	}
	
	public PC() {
		super();
	}
	
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return model + "("+display+")";
	}
	
}
