/**
 * 
 */
package com.atszu.team.domain;

import com.atszu.team.service.Status;

/**   
 * @ClassName:  Programmer   
 * @Description:TODO(描述这个类的作用)   
 * @author: lsy
 * @date:   2021年11月30日 下午9:33:39      
 * @Copyright:  
 */
public class Programmer extends Employee {
	private int memberId;
	private Status status = Status.FREE;
	private Equipment  equipment;
	public Programmer() {
		super();
	}
	public Programmer(int id, String name, int age, double salary, Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Equipment getEquipment() {
		return equipment;
	}
	
	
	public int getMemberld() {
		return memberId;
	}


	public void setMemberld(int memberld) {
		this.memberId = memberld;
	}

	@Override
	public String toString() {
		return getDetails() + "\t程序员\t" + status +"\t\t\t"+ equipment.getDescription();
	}
	
	
	public String getDetailsForTeam() {
		return getMemberld()+"/"+this.toString();
	}
	
}
