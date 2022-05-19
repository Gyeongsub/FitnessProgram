package net.scit.realestate.ui;

import java.util.List;
import java.util.Scanner;

import net.scit.realestate.service.RealEstateService;
import net.scit.realestate.service.RealEstateServiceImpl;
import net.scit.realestate.vo.BuyingAndSelling;
import net.scit.realestate.vo.Charter;
import net.scit.realestate.vo.MonthlyRent;
import net.scit.realestate.vo.RealEstate;

public class RealEstateUI {
	
	Scanner scanner = new Scanner(System.in);
	RealEstateService service = new RealEstateServiceImpl();
	
	public RealEstateUI() {
		// 임시 추가 코드
		BuyingAndSelling buyAndSell = new BuyingAndSelling("서울시 강남구","아파트",33,4400);
		service.regist(buyAndSell);
		
		Charter charter = new Charter("서울시 도봉구", "빌라", 25, 5000);
		service.regist(charter);
		
		MonthlyRent monthlyRent = new MonthlyRent("서울시 서대문구", "원룸", 8, 50);
		service.regist(monthlyRent);
		
		String choice;
		
		while(true) {
			mainMenu();
			choice = scanner.nextLine();
			switch(choice) {
			case "1" : insert(); break;
			case "2" : selectOne(); break;
			case "3" : update(); break;
			case "4" : delete(); break;
			case "5" : output(); break;
			case "9" : 
				System.out.println("** 프로그램을 종료합니다.");
				return;
			default : System.out.println("err) 메뉴를 다시선택하세요.");
			}
		}
	}
	
	private void update() {
		System.out.print("|수정 물건의 주소|");
		String searchAddress = scanner.nextLine();
		
		RealEstate realEstate = service.selectOne(searchAddress);
		
		if(realEstate == null) {
			System.out.println("찾는 물건이 없습니다.");
			return;
		}
		
		System.out.println("등록된 정보");
		System.out.println("========================");
		System.out.println(realEstate);
		System.out.println("========================");
		
		if(realEstate instanceof BuyingAndSelling) {
			System.out.print("|매매 가격|");
			((BuyingAndSelling)realEstate).setPrice(Integer.parseInt(scanner.nextLine())); //버퍼 남기는 것 방지
		} else if(realEstate instanceof Charter) {
			System.out.print("|전세보증금|");
			((Charter) realEstate).setDepositMoney(Integer.parseInt(scanner.nextLine()));
		} else if(realEstate instanceof MonthlyRent) {
			System.out.print("|월세|");
			((MonthlyRent) realEstate).setMonthlyRent(Integer.parseInt(scanner.nextLine()));
		}
	}

	private void delete() {
		System.out.print("|삭제할 건물의 주소|");
		String searchAddress = scanner.nextLine();
		
		if(service.selectOne(searchAddress) == null) {
			System.out.println("삭제 할 아이디가 존재하지 않습니다.");
			return;
		}
		
		service.delete(searchAddress);
		System.out.println("정상 삭제 되었습니다.");
	}

	private void selectOne() {
		String choice;
		
		selectOneMenu();
		choice = scanner.nextLine();
		
		switch(choice) {
		case "0" : selectOneByAddress(); break;
		case "1" : selectByBuyingAndSelling(); break;
		case "2" : selectByCharter(); break;
		case "3" : selectByMonthlyRent(); break;
		default : System.out.println("err) 메뉴를 다시선택하세요.");
		}
		
	}
	
	private void selectOneMenu() {
		System.out.println("-----------------------------");
		System.out.println("  부동산 중계 관리 시스템");
		System.out.println("-----------------------------");
		System.out.println("0. 주소로 검색");
		System.out.println("1. 매매 물건 검색");
		System.out.println("2. 전세 물건 검색");
		System.out.println("3. 월세 물건 검색");
		System.out.println("-----------------------------");
		System.out.print("메뉴 번호를 선택하세요=> ");
	}
	
	private void selectOneByAddress() {
		System.out.print("찾을 주소를 입력 해 주세요 : ");
		RealEstate realEstate = service.selectOne(scanner.nextLine());
		
		if(realEstate == null) {
			System.out.println("찾을 주소가 존재하지 않습니다.");
			return;
		}
		
		System.out.println(realEstate);
	}
	
	private void selectByBuyingAndSelling() {
		List<RealEstate> buyingAndSellingList = service.selectByBuyingAndSelling();
		
		for(RealEstate realEstate : buyingAndSellingList) {
			System.out.println(realEstate);
		}
	}
	
	private void selectByCharter() {
		List<RealEstate> charterList = service.selectByCharter();
		
		for(RealEstate realEstate : charterList) {
			System.out.println(realEstate);
		}
	}
	
	private void selectByMonthlyRent() {
		List<RealEstate> monthlyRentList = service.selectByMonthlyRent();
		
		for(RealEstate realEstate : monthlyRentList) {
			System.out.println(realEstate);
		}
	}
	

	private void output() {
		List<RealEstate> realEsateList = service.selectAll();
		
		for(RealEstate realEstate : realEsateList) {
			System.out.println(realEstate);
		}
		System.out.println();
	}

	private void insertRealEstate(String choice) {
		System.out.println("-----------------------------");
		System.out.println("  부동산 매물 정보 등록");
		System.out.println("-----------------------------");
		System.out.print("> 주소 : ");
		String address = scanner.nextLine();
		
		if(service.selectOne(address) != null) {
			System.out.println("** 중복된 주소가 있습니다. 다시 입력해 주세요.");
			return;
		}
		
		System.out.print("> 주거형태 : ");
		String houseType = scanner.nextLine();
		System.out.print("> 크기 : ");
		int size = Integer.parseInt(scanner.nextLine());
		
		if(choice.equals("BuyingAndSelling")) {
			System.out.print("매매 가격 : ");
			int price = Integer.parseInt(scanner.nextLine());
			service.regist(new BuyingAndSelling(address, houseType, size, price));
			
		} else if(choice.equals("Charter")) {
			System.out.print("전세보증금 : ");
			int depositMoney = Integer.parseInt(scanner.nextLine());
			service.regist(new Charter(address, houseType, size, depositMoney));
			
		} else if(choice.equals("MonthlyRent")) {
			System.out.print("월세 : ");
			int monthlyRent = Integer.parseInt(scanner.nextLine());
			service.regist(new MonthlyRent(address, houseType, size, monthlyRent));
		}
	}
	
	private void insert() {
		String choice;
		
		while(true) {
			insertMenu();
			choice = scanner.nextLine();
			switch(choice) {
			case "1" : insertRealEstate("BuyingAndSelling"); break;
			case "2" : insertRealEstate("Charter"); break;
			case "3" : insertRealEstate("MonthlyRent"); break;
			case "4" : return;
			default : System.out.println("err) 메뉴를 다시선택하세요.");
			}
		}
	}
	
	private void insertMenu() {
		System.out.println("-----------------------------");
		System.out.println("  부동산 매물 정보 등록");
		System.out.println("-----------------------------");
		System.out.println("1. 매매");
		System.out.println("2. 전세");
		System.out.println("3. 월세");
		System.out.println("4. 상위메뉴");
		System.out.print("메뉴 번호를 선택하세요=> ");
	}

	private void mainMenu() {
		System.out.println("-----------------------------");
		System.out.println("  부동산 중계 관리 시스템");
		System.out.println("-----------------------------");
		System.out.println("1. 등록");
		System.out.println("2. 검색");
		System.out.println("3. 수정");
		System.out.println("4. 삭제(거래완료)");
		System.out.println("5. 전체 출력");
		System.out.println("9. 종료");
		System.out.println("-----------------------------");
		System.out.print("메뉴 번호를 선택하세요=> ");
	}
}
