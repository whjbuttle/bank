package ams;

public class BankBook implements Account{
	
	private String accountNo;	
	private String ownerName;	
	private String password;	
	private int restMoney;

	public BankBook(String accountNo, String ownerName, String password, int restMoney) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.password = password;
		this.restMoney = restMoney;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRestMoney() {
		return restMoney;
	}

	public void setRestMoney(int restMoney) {
		this.restMoney = restMoney;
	}

	@Override
	public void deposit(int money) {
		if (money <= 0) {
			System.out.println("입금액은 0보다 커야합니다.");
		} else {
			this.restMoney += money;
		}
	}

	@Override
	public void withdraw(int money) {
		if (money <= 0) {
			System.out.println("출금액은 0보다 커야합니다.");
		} else if (getRestMoney() <= money) {
			System.out.println("출금액이 잔액보다 큽니다.");
		} else {
			this.restMoney -= money;
		}
	}
	
	// 자바 API 중에서 java.lang.Object 클래스의 메소드인 toString() 을 오버라이딩 하였다
	@Override
	public String toString(){
		return "입출금 계좌\n"
				+ "계좌번호 : " + getAccountNo() + "\n"
				+ "계좌명 : " + getOwnerName() + "\n"
				+ "비밀번호 : ******** \n" 
				+ "잔액 : " + getRestMoney() + "\n";
	}

}
