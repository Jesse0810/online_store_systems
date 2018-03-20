package com.njwangbo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njwangbo.mapper.CartMapper;
import com.njwangbo.mapper.OrderChildMapper;
import com.njwangbo.mapper.OrderMapper;
import com.njwangbo.pojo.Cart;
import com.njwangbo.pojo.GridCondition;
import com.njwangbo.pojo.Order;
import com.njwangbo.pojo.OrderChild;
import com.njwangbo.service.OrderService;

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderChildMapper orderChildMapper;
	@Autowired
	private CartMapper cartMapper;
	
	@Override
	public Order queryOrderById(Order order) {
		
		return orderMapper.queryOrderById(order);
	}

	@Override
	public int insertOrder(Order order,List<Cart> cartList) {
		int count = 0;
		count = orderMapper.insertOrder(order);
		
		for (Cart cart : cartList) {
			OrderChild child = new OrderChild();
			child.setCartId(cart.getId());
			child.setPrice(cart.getGoodsPrice());
			child.setOrderId(order.getId());
			orderChildMapper.insertOrderChild(child);
			cart.setState(0);
			cartMapper.updateCartByUserANDState(cart);
		}
		
		return count;
	}

	@Override
	public int deleteOrder(Order order) {
		int count = 0;
		OrderChild child = new OrderChild();
		child.setOrderId(order.getId());
		orderChildMapper.deleteOrderChildByOrderId(child);
		count = orderMapper.deleteOrder(order);
		return count;
	}

	@Override
	public int updateOrder(Order order) {
		int count = 0;
		
//		for (Cart cart : cartList) {
//			OrderChild child = new OrderChild();
//			child.setCartId(cart.getId());
//			child.setPrice(cart.getGoodsPrice());
//			child.setOrderId(order.getId());
//			orderChildMapper.updateOrderChild(child);
//		}
		
		count = orderMapper.updateOrder(order);
		
		return count;
	}

	@Override
	public List<Order> queryOrderForGridByCondition(GridCondition condition) {
		
		return orderMapper.queryOrderForGridByCondition(condition);
	}

	@Override
	public List<Order> queryOrderByCondition(GridCondition condition) {
		
		return orderMapper.queryOrderByCondition(condition);
	}

	@Override
	public int queryOrderCount(GridCondition condition) {
		
		return orderMapper.queryOrderCount(condition);
	}

}
