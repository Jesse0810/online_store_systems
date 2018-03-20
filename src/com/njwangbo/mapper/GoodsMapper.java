package com.njwangbo.mapper;

import java.util.List;

import com.njwangbo.pojo.Goods;
import com.njwangbo.pojo.GridCondition;

public interface GoodsMapper {
	
	public Goods queryGoodsById(Goods goods);
	
	public int insertGoods(Goods goods);

	public int deleteGoods(Goods goods);
	
	public int deleteGoodsByTypeID(Goods goods);
	
	public int updateGoods(Goods goods);
	
	public int updateGoodsPurchases(Goods goods);
	
	public int updateGoodsStock(Goods goods);
	
	public List<Goods> queryGoodsForGridByCondition(GridCondition condition);
	
	public List<Goods> queryGoodsByCondition(GridCondition condition);
	
	public int queryGoodsCount(GridCondition condition);
	
	public List<Goods> queryGoodsByPurchases(GridCondition condition);
	
	public Goods queryGoodsByName(Goods goods);
}
