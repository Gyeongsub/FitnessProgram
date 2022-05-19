package net.scit.realestate.service;

import java.util.List;

import net.scit.realestate.vo.RealEstate;

public interface RealEstateService {
		// 등록 (Create)
		public int regist(RealEstate realEstate);
		
		// 조회 (Read)
		public RealEstate selectOne(String address);
		
		// 전체 조회
		public List<RealEstate> selectAll();
		
		// 번외(소설전체나, 잡지 전체만 보고 싶을 때)
		public List<RealEstate> selectByBuyingAndSelling(); 
		public List<RealEstate> selectByCharter();
		public List<RealEstate> selectByMonthlyRent();
		
		// 삭제 (Delete)
		public int delete(String address);
		
		// 수정	(Update)
		public int update(RealEstate realEstate); 
}
