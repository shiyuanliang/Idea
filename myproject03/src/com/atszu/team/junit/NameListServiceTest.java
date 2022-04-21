/**
 * 
 */
package com.atszu.team.junit;

import com.atszu.team.domain.Employee;
import com.atszu.team.service.NameListService;
import com.atszu.team.service.TeamException;
import org.junit.Test;

/**   
 * @ClassName:  NameListServiceTest   
 * @Description:對NameListService類的測試  
 * @author: lsy
 * @date:   2021年12月7日 上午11:10:11      
 * @Copyright:  
 */
public class NameListServiceTest {
	@org.junit.Test
	public void testGetAllEmployees() {
		NameListService service = new NameListService();
		Employee[] employees = service.getAllEmployees();
		for(int i = 0;i<employees.length;i++) {
			System.out.println(employees[i]);
		}
	}
	
	@Test
	public void testGetEmployee() {
		NameListService service = new NameListService();
		
		int id = 15;
		try {
			Employee employ = service.getEmployee(id);
			System.out.println(employ);
		}catch(TeamException e){
			System.out.println(e.getMessage());
		}
	}
}
