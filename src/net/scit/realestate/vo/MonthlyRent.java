package net.scit.realestate.vo;

public class MonthlyRent extends RealEstate{
	private int monthlyRent;
	
	public MonthlyRent() {}
	public MonthlyRent(int monthlyRent) {
		this.monthlyRent = monthlyRent;
	}
	public MonthlyRent(String address, String houseType, int size, int monthlyRent) {
		super(address, houseType, size);
		this.monthlyRent = monthlyRent;
	}
	
	public void setMonthlyRent(int monthlyRent) {
		this.monthlyRent = monthlyRent;
	}
	public int getMonthlyRent() {
		return this.monthlyRent;
	}
	
	@Override
	public String toString() {
		return super.toString() + "¿ù¼¼ : " + this.monthlyRent;
	}
}
