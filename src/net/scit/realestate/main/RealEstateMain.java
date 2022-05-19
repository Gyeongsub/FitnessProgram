package net.scit.realestate.main;

import java.util.List;

import net.scit.realestate.service.RealEstateService;
import net.scit.realestate.service.RealEstateServiceImpl;
import net.scit.realestate.ui.RealEstateUI;
import net.scit.realestate.vo.BuyingAndSelling;
import net.scit.realestate.vo.Charter;
import net.scit.realestate.vo.MonthlyRent;
import net.scit.realestate.vo.RealEstate;

public class RealEstateMain {

	public static void main(String[] args) {
		new RealEstateUI();
	}

	/**
	 * 밑에는 전부 ServiceImpl 기능 테스트 코드 입니다.
	 * ServiceImpl을 만들고, UI를 만들기 전에 테스트 해주세요.
	**/
	
	// RealEstateService service = new RealEstateServiceImpl();
	
	// insert test ( ok )
	/*
	BuyingAndSelling buyAndSell = new BuyingAndSelling("서울시 강남구","아파트",33,4400);
	service.regist(buyAndSell);
	
	Charter charter = new Charter("서울시 도봉구", "빌라", 25, 5000);
	service.regist(charter);
	
	MonthlyRent monthlyRent = new MonthlyRent("서울시 서대문구", "원룸", 8, 50);
	service.regist(monthlyRent);
	*/
	
	// selectAll test ( ok )
	/*
	List<RealEstate> testList = service.selectAll();
	
	for(RealEstate re : testList) {
		System.out.println(re);
	}
	System.out.println();
	*/
	
	// selectOne test ( ok )
	/*
	System.out.println(service.selectOne("서울시 도봉구"));
	System.out.println(service.selectOne("서울시 강남구"));
	System.out.println(service.selectOne("서울시 서대문구"));
	*/
	
	// update test ( ok )
	/*
	RealEstate updateRealEstate;
	
	System.out.println("before update : " + service.selectOne("서울시 도봉구"));
	updateRealEstate = service.selectOne("서울시 도봉구");
	((Charter)updateRealEstate).setDepositMoney(1000);
			
	service.update(monthlyRent);
	
	System.out.println("after update : " + service.selectOne("서울시 도봉구"));
	*/
	
	// remove test ( ok )
	/*
	service.delete(service.selectOne("서울시 도봉구").getAddress());
	
	List<RealEstate> testList2 = service.selectAll();
	
	for(RealEstate re : testList2) {
		System.out.println(re);
	}
	System.out.println();
	*/
}
