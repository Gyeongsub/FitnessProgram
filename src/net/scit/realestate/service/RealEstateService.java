package net.scit.realestate.service;

import java.util.List;

import net.scit.realestate.vo.RealEstate;

public interface RealEstateService {
		// ��� (Create)
		public int regist(RealEstate realEstate);
		
		// ��ȸ (Read)
		public RealEstate selectOne(String address);
		
		// ��ü ��ȸ
		public List<RealEstate> selectAll();
		
		// ����(�Ҽ���ü��, ���� ��ü�� ���� ���� ��)
		public List<RealEstate> selectByBuyingAndSelling(); 
		public List<RealEstate> selectByCharter();
		public List<RealEstate> selectByMonthlyRent();
		
		// ���� (Delete)
		public int delete(String address);
		
		// ����	(Update)
		public int update(RealEstate realEstate); 
}
