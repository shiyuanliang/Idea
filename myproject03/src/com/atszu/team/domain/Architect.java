/**
 * 
 */
package com.atszu.team.domain;

/**   
 * @ClassName:  Architect   
 * @Description:TODO(描述这个类的作用)   
 * @author: lsy
 * @date:   2021年12月6日 下午6:29:52      
 * @Copyright:  
 */
public class Architect extends Designer{
	private int stock;

	public Architect() {
		super();
	}

	public Architect(int id, String name, int age, double salary, Equipment equiqment, double bonus, int stock) {
		super(id, name, age, salary, equiqment, bonus);
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getDetails() + "\t架构师\t" + getStatus() +"\t"+getBonus()+"\t"+stock+"\t"+ getEquipment().getDescription();
	}
}
