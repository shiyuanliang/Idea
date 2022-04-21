/**
 * 
 */
package com.atszu.team.service;

/**   
 * @ClassName:  TeamException   
 * @Description: 自定义异常类
 * @author: lsy
 * @date:   2021年12月7日 上午10:42:40      
 * @Copyright:  
 */
public class TeamException extends Exception{
	static final long serialVersionUID = -338751629948L;
	
	public TeamException() {
		super();
	}
	
	
	public TeamException(String msg) {
		super(msg);
	}
}
