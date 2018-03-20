package com.njwangbo.mapper;

import java.util.List;

import com.njwangbo.pojo.GridCondition;
import com.njwangbo.pojo.Review;

public interface ReviewMapper {
	public Review queryReviewById(Review review);
	
	public int insertReview(Review review);

	public int deleteReview(Review review);
	
	public int updateReview(Review review);
	
	public List<Review> queryReviewForGridByCondition(GridCondition condition);
	
	public List<Review> queryReviewByCondition(GridCondition condition);
	
	public int queryReviewCount(GridCondition condition);

}
