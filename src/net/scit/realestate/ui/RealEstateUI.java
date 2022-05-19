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
		// �ӽ� �߰� �ڵ�
		BuyingAndSelling buyAndSell = new BuyingAndSelling("����� ������","����Ʈ",33,4400);
		service.regist(buyAndSell);
		
		Charter charter = new Charter("����� ������", "����", 25, 5000);
		service.regist(charter);
		
		MonthlyRent monthlyRent = new MonthlyRent("����� ���빮��", "����", 8, 50);
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
				System.out.println("** ���α׷��� �����մϴ�.");
				return;
			default : System.out.println("err) �޴��� �ٽü����ϼ���.");
			}
		}
	}
	
	private void update() {
		System.out.print("|���� ������ �ּ�|");
		String searchAddress = scanner.nextLine();
		
		RealEstate realEstate = service.selectOne(searchAddress);
		
		if(realEstate == null) {
			System.out.println("ã�� ������ �����ϴ�.");
			return;
		}
		
		System.out.println("��ϵ� ����");
		System.out.println("========================");
		System.out.println(realEstate);
		System.out.println("========================");
		
		if(realEstate instanceof BuyingAndSelling) {
			System.out.print("|�Ÿ� ����|");
			((BuyingAndSelling)realEstate).setPrice(Integer.parseInt(scanner.nextLine())); //���� ����� �� ����
		} else if(realEstate instanceof Charter) {
			System.out.print("|����������|");
			((Charter) realEstate).setDepositMoney(Integer.parseInt(scanner.nextLine()));
		} else if(realEstate instanceof MonthlyRent) {
			System.out.print("|����|");
			((MonthlyRent) realEstate).setMonthlyRent(Integer.parseInt(scanner.nextLine()));
		}
	}

	private void delete() {
		System.out.print("|������ �ǹ��� �ּ�|");
		String searchAddress = scanner.nextLine();
		
		if(service.selectOne(searchAddress) == null) {
			System.out.println("���� �� ���̵� �������� �ʽ��ϴ�.");
			return;
		}
		
		service.delete(searchAddress);
		System.out.println("���� ���� �Ǿ����ϴ�.");
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
		default : System.out.println("err) �޴��� �ٽü����ϼ���.");
		}
		
	}
	
	private void selectOneMenu() {
		System.out.println("-----------------------------");
		System.out.println("  �ε��� �߰� ���� �ý���");
		System.out.println("-----------------------------");
		System.out.println("0. �ּҷ� �˻�");
		System.out.println("1. �Ÿ� ���� �˻�");
		System.out.println("2. ���� ���� �˻�");
		System.out.println("3. ���� ���� �˻�");
		System.out.println("-----------------------------");
		System.out.print("�޴� ��ȣ�� �����ϼ���=> ");
	}
	
	private void selectOneByAddress() {
		System.out.print("ã�� �ּҸ� �Է� �� �ּ��� : ");
		RealEstate realEstate = service.selectOne(scanner.nextLine());
		
		if(realEstate == null) {
			System.out.println("ã�� �ּҰ� �������� �ʽ��ϴ�.");
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
		System.out.println("  �ε��� �Ź� ���� ���");
		System.out.println("-----------------------------");
		System.out.print("> �ּ� : ");
		String address = scanner.nextLine();
		
		if(service.selectOne(address) != null) {
			System.out.println("** �ߺ��� �ּҰ� �ֽ��ϴ�. �ٽ� �Է��� �ּ���.");
			return;
		}
		
		System.out.print("> �ְ����� : ");
		String houseType = scanner.nextLine();
		System.out.print("> ũ�� : ");
		int size = Integer.parseInt(scanner.nextLine());
		
		if(choice.equals("BuyingAndSelling")) {
			System.out.print("�Ÿ� ���� : ");
			int price = Integer.parseInt(scanner.nextLine());
			service.regist(new BuyingAndSelling(address, houseType, size, price));
			
		} else if(choice.equals("Charter")) {
			System.out.print("���������� : ");
			int depositMoney = Integer.parseInt(scanner.nextLine());
			service.regist(new Charter(address, houseType, size, depositMoney));
			
		} else if(choice.equals("MonthlyRent")) {
			System.out.print("���� : ");
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
			default : System.out.println("err) �޴��� �ٽü����ϼ���.");
			}
		}
	}
	
	private void insertMenu() {
		System.out.println("-----------------------------");
		System.out.println("  �ε��� �Ź� ���� ���");
		System.out.println("-----------------------------");
		System.out.println("1. �Ÿ�");
		System.out.println("2. ����");
		System.out.println("3. ����");
		System.out.println("4. �����޴�");
		System.out.print("�޴� ��ȣ�� �����ϼ���=> ");
	}

	private void mainMenu() {
		System.out.println("-----------------------------");
		System.out.println("  �ε��� �߰� ���� �ý���");
		System.out.println("-----------------------------");
		System.out.println("1. ���");
		System.out.println("2. �˻�");
		System.out.println("3. ����");
		System.out.println("4. ����(�ŷ��Ϸ�)");
		System.out.println("5. ��ü ���");
		System.out.println("9. ����");
		System.out.println("-----------------------------");
		System.out.print("�޴� ��ȣ�� �����ϼ���=> ");
	}
}
