package com.entity.vo;

import com.entity.ChathelperEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 聊天助手表
 * @author 
 * @email 
 * @date 2024-04-17 21:50:48
 */
public class ChathelperVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 回复
	 */
	
	private String reply;
				
	
	/**
	 * 设置：回复
	 */
	 
	public void setReply(String reply) {
		this.reply = reply;
	}
	
	/**
	 * 获取：回复
	 */
	public String getReply() {
		return reply;
	}
			
}
