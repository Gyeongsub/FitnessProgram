package net.scit.realestate.vo;

public class Charter extends RealEstate{
	private int depositMoney;
	
	public Charter() {}
	public Charter(int depositMoney) {
		this.depositMoney = depositMoney;
	}
	public Charter(String address, String houseType, int size, int depositMoney) {
		super(address, houseType, size);
		this.depositMoney = depositMoney;
	}
	
	public void setDepositMoney(int depositMoney) {
		this.depositMoney = depositMoney;
	}
	public int getDepositMoney() {
		return this.depositMoney;
	}
	
	
	@Override
	public String toString() {
		return super.toString() + "전세보증금 : " + this.depositMoney;
	}
}
