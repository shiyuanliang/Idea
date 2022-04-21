/**
 * 
 */
package com.atszu.team.view;

import com.atszu.team.domain.Employee;
import com.atszu.team.service.NameListService;
import com.atszu.team.service.TeamException;
import com.atszu.team.service.TeamService;

/**   
 * @ClassName:  TeamView   
 * @Description:TODO(描述这个类的作用)   
 * @author: lsy
 * @date:   2021年12月7日 下午4:41:54      
 * @Copyright:  
 */
public class TeamView {
	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();
	
	
	public void enterMainMenu() {
		boolean exitFlag = true;
		char readMenuSelection = 0;
		
		while(exitFlag) {
			if(readMenuSelection!='1') {
				listAllEmployees();
			}
			System.out.println("-------------------------------------------------------------------------------");
			System.out.print("1-团队列表  2-添加团队成员  3-删除团队成员 4-退出   请选择(1-4)：");
			readMenuSelection = TSUtility.readMenuSelection();
			switch(readMenuSelection) {
			case '1':
				getTeam();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break;
			case '4':
				System.out.println("确认是否退出(Y/N):");
				char isExit = TSUtility.readConfirmSelection();
				if(isExit=='Y') {
					exitFlag=false;
				}
				break;
			}
		}
		
	}
	
	private void listAllEmployees() {
		System.out.println("-------------------------------开发团队调度软件--------------------------------\n");
		System.out.println("ID\t姓名\t年龄\t工资\t职位\t状态\t奖金\t股票\t领用设备");
		for(int i=0;i<listSvc.getAllEmployees().length;i++) {
			System.out.println(listSvc.getAllEmployees()[i]);
		}

	}
	
	private void getTeam() {
		System.out.println("--------------------团队成员列表---------------------");
		if(teamSvc.getTeam().length==0||teamSvc.getTeam()==null) {
			System.out.println("开发团队目前没有成员！");
			return;
		}
		System.out.println("TDI/ID  姓名	年龄	工资	职位	状态	奖金	股票	领用设备\r\n"
				+ "");
		for(int i =0;i<teamSvc.getTeam().length;i++) {
			System.out.println(teamSvc.getTeam()[i].getDetailsForTeam());
		}
	}
	
	private void addMember() {
		System.out.println("--------------------添加成员---------------------\n");
		System.out.print("请输入要添加的员工ID：");
		int id = TSUtility.readInt();
		
		try {
			Employee emp = listSvc.getEmployee(id);
			teamSvc.addMember(emp);
			System.out.print("添加成功");
			TSUtility.readReturn();
		} catch (TeamException e) {
			System.out.println("添加失败，原因："+e.getMessage());
			TSUtility.readReturn();
		}
	}
	
	private void deleteMember() {
		System.out.println("--------------------删除成员---------------------\n");
		System.out.print("请输入要删除的员工TID：");
		int tId = TSUtility.readInt();
		
		System.out.println("确认是否删除(Y/N):");
		char isDelete = TSUtility.readConfirmSelection();
		if(isDelete=='N') {
			return;
		}else {
			try {
				teamSvc.removeMember(tId);
				System.out.println("删除成功");
				TSUtility.readReturn();
			} catch (TeamException e) {
				System.out.println("删除失败，原因："+e.getMessage());
				TSUtility.readReturn();
				
			}
		}
		
	}
	
	public static void main(String[] args) {
		TeamView teamView = new TeamView(); 
		teamView.enterMainMenu();
	}
}
