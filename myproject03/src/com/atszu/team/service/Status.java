/**
 * 
 */
package com.atszu.team.service;

/**   
 * @ClassName:  Status   
 * @Description:TODO(描述这个类的作用)   
 * @author: lsy
 * @date:   2021年11月30日 下午9:35:13      
 * @Copyright:  
 */
//public class Status {
//	private final String NAME;
//	private Status(String name) {
//		this.NAME = name;
//	}
//	public static final Status FREE = new Status("FREE");
//	public static final Status VOCATION = new Status("VOCATION");
//	public static final Status BUSY = new Status("BUSY");
//	public String getNAME() {
//		return NAME;
//	}
//	@Override
//    public String toString() {
//        return NAME;
//    }
//
//}

public  enum  Status {
	FREE("FREE"),BUSY("BUSY"),VOCATION("VOCATION");
	private  String NAME;
	private  Status(String Name){
		this.NAME = Name;
	}
	public  String getNAME(){
		return  NAME;
	}

	@Override
	public String toString() {
		return NAME;
	}}
