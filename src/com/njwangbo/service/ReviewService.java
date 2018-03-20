package com.njwangbo.service;

import java.util.List;

import com.njwangbo.pojo.GridCondition;
import com.njwangbo.pojo.Review;

public interface ReviewService {
public Review queryReviewById(Review review);
	
	public int insertReview(Review review,String[] fileImgName, String tomcatPath);

	public int deleteReview(Review review, String tomcatPath);
	
	public int updateReview(Review review,String[] fileImgName, String tomcatPath);
	
	public List<Review> queryReviewForGridByCondition(GridCondition condition);
	
	public List<Review> queryReviewByCondition(GridCondition condition);
	
	public int queryReviewCount(GridCondition condition);
}
