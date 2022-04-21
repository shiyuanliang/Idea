/**
 * 
 */
package com.atszu.team.domain;

/**   
 * @ClassName:  Printer   
 * @Description: 打印机的信息  
 * @author: lsy
 * @date:   2021年11月30日 下午9:21:38      
 * @Copyright:  
 */
public class Printer implements Equipment {
	private String name;
	private String type;
	
	public Printer(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	public Printer() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return name + "(" + type + ")";
	}
	

}
