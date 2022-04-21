/**
 * 
 */
package com.atszu.team.service;

import com.atszu.team.domain.Architect;
import com.atszu.team.domain.Designer;
import com.atszu.team.domain.Employee;
import com.atszu.team.domain.Programmer;

/**   
 * @ClassName:  TeamService   
 * @Description:TODO(描述这个类的作用)   
 * @author: lsy
 * @date:   2021年12月7日 上午11:52:22      
 * @Copyright:  
 */
public class TeamService {
	private static int counter = 1;
	private final int MAX_MEMBER = 5;
	private Programmer[] team = new Programmer[MAX_MEMBER];
	private int total = 0;
	public TeamService() {
		super();
	}
	
	public int getTotal() {
		return total;
	}

	public Programmer[] getTeam() {
		Programmer[] team = new Programmer[total];
		for(int i = 0;i<total;i++) {
			team[i] = this.team[i];
		}
		return team;
	}
	
	
	public void addMember(Employee e) throws TeamException {
//		失败信息包含以下几种：
//		成员已满，无法添加
		if(total==MAX_MEMBER) {
			throw new TeamException("成员已满，无法添加");
		}
//		该成员不是开发人员，无法添加
		if(!(e instanceof Programmer)) {
			throw new TeamException("该成员不是开发人员，无法添加");
		}
//		该员工已在本开发团队中
		if(isExit(e)) {
			throw new TeamException("该员工已在本开发团队中");
		}
//		该员工已是某团队成员 
//		该员正在休假，无法添加
		Programmer p = (Programmer) e;
		//if(p.getStatus().getNAME().equals("VOCATION")) {  防止出现空指针
		if("BUSY".equals(p.getStatus().getNAME())) {
			throw new TeamException("该员工已是某团队成员");
		}else if("VOCATION".equals(p.getStatus().getNAME())) {
			throw new TeamException("该员正在休假，无法添加");
		}
//		团队中至多只能有一名架构师
//		团队中至多只能有两名设计师
//		团队中至多只能有三名程序员
		
//		获取team中已有成员中架构师，设计师，程序员的人数
		int  numOfPro = 0, numOfDes = 0, numOfArch = 0;
		for(int i = 0;i<total;i++) {
			if(team[i] instanceof Architect) {
				numOfArch++;
			}else if(team[i] instanceof Designer) {
				numOfDes++;
			}else {
				numOfPro++;
			}
		}
		
		if(p instanceof Architect) {
			if(numOfArch==1) {
				throw new TeamException("团队中至多只能有一名架构师");
			}
		}else if(p instanceof Designer) {
			if(numOfDes==2) {
				throw new TeamException("团队中至多只能有两名设计师");
			}
		}else {
			if(numOfPro==3) {
				throw new TeamException("团队中至多只能有三名程序员");
			}
		}
		
		//将p添加到team中
		team[total++] = p;
		p.setStatus(Status.BUSY);
		p.setMemberld(counter++);	
	}

	/**   
	 * @Title: isExit   
	 * @Description: TODO(描述这个方法的作用)   
	 * @param: @param e
	 * @param: @return      
	 * @return: boolean      
	 * @throws   
	 */
	private boolean isExit(Employee e) {
		// TODO Auto-generated method stub
		for(int i = 0;i<total;i++) {
			if(team[i].getId()==e.getId()) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @Title: removeMember   
	 * @Description: 从团队中删除成员  
	 * @param: @param memberId      
	 * @return: void      
	 * @throws
	 */
	public void removeMember(int memberId) throws TeamException{
		int i =0;
		for(i=0;i<total;i++) {
			if(team[i].getMemberld()==memberId) {
				team[i].setStatus(Status.FREE);
				break;
			}
		}
		if(i==total) {
			throw new TeamException("找不到指定memberId的员工，删除失败");
		}
		for(int j=i+1;j<total;j++) {
			team[j-1]= team[j];
		}
		team[--total]=null;
	}
}
