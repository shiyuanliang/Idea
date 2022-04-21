/**
 * 
 */
package com.atszu.team.domain;

/**   
 * @ClassName:  Designer   
 * @Description:TODO(描述这个类的作用)   
 * @author: lsy
 * @date:   2021年12月6日 下午6:26:05      
 * @Copyright:  
 */
public class Designer extends Programmer {
	private double bonus;

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public Designer() {
		super();
	}
	public Designer(int id, String name, int age, double salary, Equipment equiqment, double bonus) {
		super(id, name, age, salary, equiqment);
		this.bonus = bonus;
	}
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getDetails() + "\t设计师\t" + getStatus() +"\t"+bonus+"\t\t"+ getEquipment().getDescription();
	}
}
