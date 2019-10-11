package com.sist.dao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.sist.vo.RestaurantVO;
import com.sist.vo.ThemeTourVO;
import com.sist.vo.TouristattrVO;

import java.util.*;
@Repository
public class RestMongDAO {
	
	@Autowired
	private MongoTemplate mt;
	
	 public int RestTotalPage() {
	      int total=0;
	      //쿼리문없을때..일반쿼리
	      Query query=new Query();
	      int count=(int)mt.count(query, "Restaurant");
	      total=(int)(Math.ceil(count/12.0)); //총페이지 구하는 방법
	      return total;
	   }
	 public RestaurantVO rest_detail(String dataSid){
		 RestaurantVO vo = new RestaurantVO();
		 BasicQuery query = new BasicQuery("{dataSid:'"+dataSid+"'}");
		 vo=mt.findOne(query, RestaurantVO.class,"Restaurant");
		 System.out.println(vo.getDataSid());
		 return vo;
	 }
	 /*
	  * public List<NewsVO> newsListData(int page){
		List<NewsVO> list = new ArrayList<NewsVO>();
		int rowSize=10;
		int skip = (page * rowSize) - rowSize;
		Query query = new Query();
		query.with(new Sort(Sort.Direction.ASC,"no"));
		query.skip(skip).limit(rowSize);
		list = mt.find(query, NewsVO.class,"news");
		return list;
	}
	  */
	 public List<ThemeTourVO> themeListData(int page){
		 List<ThemeTourVO> list = new ArrayList<ThemeTourVO>();
		 int rowSize=12;
		 int skip = (page * rowSize) - rowSize;
		 Query query = new Query();
		 query.skip(skip).limit(rowSize);
		 list = mt.find(query, ThemeTourVO.class,"ThemeTour");
		 System.out.println("테마여행 크기"+list.size());
		 return list;
	 }
	 public int themeTotalpage(){
		 int total=0;
	      //쿼리문없을때..일반쿼리
	      Query query=new Query();
	      int count=(int)mt.count(query, "ThemeTour");
	      total=(int)(Math.ceil(count/12.0)); //총페이지 구하는 방법
	      return total;
	 }
	 
	 public List<TouristattrVO> touristattr(int page){
		 List<TouristattrVO> list = new ArrayList<TouristattrVO>();
		 int rowSize=12;
		 int skip = (page * rowSize) - rowSize;
		 Query query = new Query();
		 query.skip(skip).limit(rowSize);
		 list = mt.find(query, TouristattrVO.class,"TouristattrVO");
		 System.out.println("테마여행 크기"+list.size());
		 return list;
	 }

}
