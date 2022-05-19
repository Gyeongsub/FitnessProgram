package net.scit.realestate.service;

import java.util.ArrayList;
import java.util.List;

import net.scit.realestate.vo.BuyingAndSelling;
import net.scit.realestate.vo.Charter;
import net.scit.realestate.vo.MonthlyRent;
import net.scit.realestate.vo.RealEstate;

public class RealEstateServiceImpl implements RealEstateService {

	List<RealEstate> realEstateList = new ArrayList<RealEstate>();
	
	@Override
	public int regist(RealEstate realEstate) {
		if(realEstateList.add(realEstate)) return 1; //add의 리컨값이 boolean이므로 boolean을 굳이 선언하지 않음
		return 0;
	}

	@Override
	public RealEstate selectOne(String address) {
		if(realEstateList.size() < 1) {
			return null;
		}
		int idx = searchPositionOfRealEstate(address);

		if(idx == -1)
			return null;
		
		return realEstateList.get(idx);
	}

	@Override
	public List<RealEstate> selectAll() {
		return realEstateList;
	}
	
	private int searchPositionOfRealEstate(String address) {		
		for(int i = 0 ; i < realEstateList.size(); i++) {
			if(realEstateList.get(i).getAddress().equals(address)) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public int delete(String address) {
		if(realEstateList.isEmpty()) {
			return -1;
		}
		
		int idx = searchPositionOfRealEstate(address);
		
		if(idx == -1) {
			return -1;
		}
		
		realEstateList.remove(idx);
		
	
		return 1;
	}

	@Override
	public int update(RealEstate realEstate) {
		if(realEstateList.isEmpty()) {
			return -1;
		}
		
		int idx = searchPositionOfRealEstate(realEstate.getAddress());
		
		if(idx == -1) return -1;
		
		realEstateList.set(idx, realEstate);
		
		return 1;
	}

	@Override
	public List<RealEstate> selectByBuyingAndSelling() {
		List<RealEstate> BuyingAndSellingList = new ArrayList<RealEstate>();
		
		for(RealEstate realEstate : realEstateList) {
			if(realEstate instanceof BuyingAndSelling) {
				BuyingAndSellingList.add(realEstate);
			}
		}
		
		return BuyingAndSellingList;
	}

	@Override
	public List<RealEstate> selectByCharter() {
		List<RealEstate> CharterList = new ArrayList<RealEstate>();
		
		for(RealEstate realEstate : realEstateList) {
			if(realEstate instanceof Charter) {
				CharterList.add(realEstate);
			}
		}
		
		return CharterList;
	}

	@Override
	public List<RealEstate> selectByMonthlyRent() {
		List<RealEstate> MonthlyRentList = new ArrayList<RealEstate>();
		
		for(RealEstate realEstate : realEstateList) {
			if(realEstate instanceof MonthlyRent) {
				MonthlyRentList.add(realEstate);
			}
		}
		
		return MonthlyRentList;
	}

}
