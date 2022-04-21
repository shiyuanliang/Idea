/**
 * 
 */
package com.atszu.team.service;

import static com.atszu.team.service.Data.ARCHITECT;
import static com.atszu.team.service.Data.DESIGNER;
import static com.atszu.team.service.Data.EMPLOYEE;
import static com.atszu.team.service.Data.EMPLOYEES;
import static com.atszu.team.service.Data.NOTEBOOK;
import static com.atszu.team.service.Data.PC;
import static com.atszu.team.service.Data.PRINTER;
import static com.atszu.team.service.Data.PROGRAMMER;
import static com.atszu.team.service.Data.EQIPMENTS;
import com.atszu.team.domain.Architect;
import com.atszu.team.domain.Designer;
import com.atszu.team.domain.Employee;
import com.atszu.team.domain.Equipment;
import com.atszu.team.domain.NoteBook;
import com.atszu.team.domain.PC;
import com.atszu.team.domain.Printer;
import com.atszu.team.domain.Programmer;

/**   
 * @ClassName:  NameListService   
 * @Description: 负责将Data中的数据封装到Employee[]数组中  
 * @author: lsy
 * @date:   2021年12月6日 下午6:31:50      
 * @Copyright:  
 */
public class NameListService {
	private Employee[] employees;
	
	 
	public NameListService() {
//		根据项目提供的Data类构建相应大小的employees数组
//		再根据Data类中的数据构建不同的对象，包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
//		将对象存于数组中
		employees = new Employee[EMPLOYEES.length];
		for (int i = 0;i< EMPLOYEES.length;i++) {
			int type = Integer.parseInt(EMPLOYEES[i][0]);
			//获取Employee的4个基本信息
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);
			Equipment equipment;
			double bonus;
			int stock;
			
			switch(type) {
			case EMPLOYEE:
				employees[i] = new Employee(id,name,age,salary);
				break;
			case PROGRAMMER:
				equipment = creatEquipment(i);
				employees[i] = new Programmer(id,name,age,salary,equipment);
				break;
			case DESIGNER:
				equipment = creatEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				employees[i] = new Designer(id,name,age,salary,equipment,bonus);
				break;
			case ARCHITECT:
				equipment = creatEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				stock = Integer.parseInt(EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
				break;
			}
		}
	}


	/**   
	 * @Title: creatEquipment   
	 * @Description: 获取指定index位置上面的员工的设备 
	 * @param: @param i
	 * @param: @return      
	 * @return: Equipment      
	 * @throws   
	 */
	private Equipment creatEquipment(int i) {
		// TODO Auto-generated method stub
		int equipmentType = Integer.parseInt(EQIPMENTS[i][0]);
		String  arg1 = EQIPMENTS[i][1];
		String  arg2 = EQIPMENTS[i][2];
		switch(equipmentType) {
		case PC:
			PC pc = new PC(arg1,arg2);
			return pc;
		case NOTEBOOK:
			NoteBook notebook = new NoteBook(arg1,Double.parseDouble(arg2));
			return notebook;
		case PRINTER:
			Printer printer  = new Printer(arg1,arg2);
			return printer;
		}
		return null;
	}
	/**
	 * 
	 * @Title: getAllEmployees   
	 * @Description: 获得所有用户的信息 
	 * @param: @return      
	 * @return: Employee[]      
	 * @throws
	 */
	public Employee[] getAllEmployees() {
		return employees;
	}
	/**
	 * 
	 * @Title: getEmployee   
	 * @Description: 获取指定ID的员工信息
	 * @param: @param id
	 * @param: @return      
	 * @return: Employee      
	 * @throws TeamException 
	 * @throws
	 */
	public Employee getEmployee(int id) throws TeamException {
		for(int i = 0;i<employees.length;i++) {
			if(employees[i].getId()==id) {
				return employees[i];
			}
		}
		throw new TeamException("找不到指定员工");
	}
}
