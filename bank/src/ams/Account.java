package ams;
/*
 Date: 20150625
 Author: itbank
 Story: 은행 고객 기능 정의
*/
public interface Account {
	public static final String BANK_NAME = "아이티뱅크";
	public void deposit(int money);
	public void withdraw(int money);
}
