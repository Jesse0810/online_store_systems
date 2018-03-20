package com.njwangbo.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.njwangbo.mapper.ReviewImgMapper;
import com.njwangbo.mapper.ReviewMapper;
import com.njwangbo.pojo.GridCondition;
import com.njwangbo.pojo.Review;
import com.njwangbo.pojo.ReviewImg;
import com.njwangbo.service.ReviewService;
import com.njwangbo.util.TypeConverter;

@Service("reviewService")
@Transactional
public class ReviewServiceImpl implements ReviewService {
	@Autowired
	private ReviewMapper reviewMapper;
	@Autowired
	private ReviewImgMapper reviewImgMapper;
	@Override
	public Review queryReviewById(Review review) {
		
		return reviewMapper.queryReviewById(review);
	}

	@Override
	public int insertReview(Review review,String[] fileImgName, String tomcatPath) {
		int count = 0;
		//添加商品
		count = reviewMapper.insertReview(review);
		
		String imgDir = "\\image\\review\\"+review.getId();
        System.out.println(imgDir);
      
        TypeConverter.createFile(imgDir,tomcatPath);
        TypeConverter.createFile(imgDir);
        
		for (int i = 0; i < fileImgName.length; i++) {
			try {
				String newFileImgName =TypeConverter.GenerateImage(fileImgName[i],imgDir, i,tomcatPath);
				ReviewImg img = new ReviewImg();
				img.setName(newFileImgName);
				img.setReviewId(review.getId());
				//添加商品图片
				reviewImgMapper.addReviewImg(img);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		
		return count;
	}

	@Override
	public int deleteReview(Review review,String tomcatPath) {
		int count = 0;
		
		ReviewImg reviewImg =  new ReviewImg();
		reviewImg.setReviewId(review.getId());
		
		String imgDir = "\\image\\review\\"+review.getId();				
		
		TypeConverter.deleteDir(new File(TypeConverter.BasePath+imgDir));
		TypeConverter.deleteDir(new File(tomcatPath+imgDir));
		
		reviewImgMapper.deleteImgByReviewId(reviewImg);
		
		count = reviewMapper.deleteReview(review);
		
		
		return count;
	}

	@Override
	public int updateReview(Review review,String[] fileImgName, String tomcatPath) {
		
		int count = 0;
		//添加商品
		count = reviewMapper.updateReview(review);
		ReviewImg imgdel = new ReviewImg();
		imgdel.setReviewId(review.getId());
		//根据商品id删除商品图片
		String imgDir = "\\image\\review\\"+review.getId();
        System.out.println(imgDir);
        for (int i = 0; i < fileImgName.length; i++) {
	        File uploadfile = new File(TypeConverter.BasePath+imgDir+"\\"+fileImgName[i]);
	    	if(uploadfile.exists()){
	    		fileImgName[i] = TypeConverter.GetImageStr(TypeConverter.BasePath+imgDir+"\\"+fileImgName[i]);
	    	}
        }
        TypeConverter.deleteDir(new File(TypeConverter.BasePath+imgDir));
		TypeConverter.deleteDir(new File(tomcatPath+imgDir));
        TypeConverter.createFile(imgDir,tomcatPath);
        TypeConverter.createFile(imgDir);
		reviewImgMapper.deleteImgByReviewId(imgdel);
//		String [] fileName = fileImgName.split(",");
		//创建商品图片
		for (int i = 0; i < fileImgName.length; i++) {
			try {
				String newFileImgName = TypeConverter.GenerateImage(fileImgName[i],imgDir, i,tomcatPath);
				ReviewImg img = new ReviewImg();
				img.setName(newFileImgName);
				img.setReviewId(review.getId());
				//添加商品图片
				reviewImgMapper.addReviewImg(img);
			} catch (Exception e) {
				
				e.printStackTrace();
			}			
		}		
		
		return count;
	}

	@Override
	public List<Review> queryReviewForGridByCondition(GridCondition condition) {
		// TODO Auto-generated method stub
		return reviewMapper.queryReviewForGridByCondition(condition);
	}

	@Override
	public int queryReviewCount(GridCondition condition) {
		// TODO Auto-generated method stub
		return reviewMapper.queryReviewCount(condition);
	}

	@Override
	public List<Review> queryReviewByCondition(GridCondition condition) {
		// TODO Auto-generated method stub
		return reviewMapper.queryReviewByCondition(condition);
	}


}
