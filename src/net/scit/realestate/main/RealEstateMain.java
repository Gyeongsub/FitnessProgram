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
	 * �ؿ��� ���� ServiceImpl ��� �׽�Ʈ �ڵ� �Դϴ�.
	 * ServiceImpl�� �����, UI�� ����� ���� �׽�Ʈ ���ּ���.
	**/
	
	// RealEstateService service = new RealEstateServiceImpl();
	
	// insert test ( ok )
	/*
	BuyingAndSelling buyAndSell = new BuyingAndSelling("����� ������","����Ʈ",33,4400);
	service.regist(buyAndSell);
	
	Charter charter = new Charter("����� ������", "����", 25, 5000);
	service.regist(charter);
	
	MonthlyRent monthlyRent = new MonthlyRent("����� ���빮��", "����", 8, 50);
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
	System.out.println(service.selectOne("����� ������"));
	System.out.println(service.selectOne("����� ������"));
	System.out.println(service.selectOne("����� ���빮��"));
	*/
	
	// update test ( ok )
	/*
	RealEstate updateRealEstate;
	
	System.out.println("before update : " + service.selectOne("����� ������"));
	updateRealEstate = service.selectOne("����� ������");
	((Charter)updateRealEstate).setDepositMoney(1000);
			
	service.update(monthlyRent);
	
	System.out.println("after update : " + service.selectOne("����� ������"));
	*/
	
	// remove test ( ok )
	/*
	service.delete(service.selectOne("����� ������").getAddress());
	
	List<RealEstate> testList2 = service.selectAll();
	
	for(RealEstate re : testList2) {
		System.out.println(re);
	}
	System.out.println();
	*/
}
