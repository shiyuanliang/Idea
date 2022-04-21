/**
 * 
 */
package com.atszu.team.domain;

/**   
 * @ClassName:  NoteBook   
 * @Description: 笔记本的信息  
 * @author: lsy
 * @date:   2021年11月30日 下午9:16:05      
 * @Copyright:  
 */
public class NoteBook  implements Equipment {
	private String model;
	private double price;
	
	
	public NoteBook() {
		super();
	}
	public NoteBook(String model, double price) {
		super();
		this.model = model;
		this.price = price;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String getDescription() {
		// TODO Auto-generated method stub
		return model + "(" + price+ ")";
	}

}
