package com.njwangbo.mapper;

import com.njwangbo.pojo.OrderChild;

public interface OrderChildMapper {
	public OrderChild queryOrderChildById(OrderChild orderChild);
	
	public int insertOrderChild(OrderChild orderChild);
	
	public int deleteOrderChild(OrderChild orderChild);
	
	public int updateOrderChild(OrderChild orderChild);
	
	public int deleteOrderChildByOrderId(OrderChild orderChild);
}
