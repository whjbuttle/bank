package ams;
/*
 Date: 20150625
 Author: itbank
 Story: ���� �����ڴ� ��� ����
*/
public interface BankRole {
	// ���°������
	public void openAccount(String accountNo, String ownerName, String password, int restMoney);
	
	// ���¹�ȣ�� Ư������ ��ȸ(�˻�) ���
	public Account searchAccountNo(String accountNo);
	
	// ������ �̸����� �� ����� ������ �ִ� ���� ��ȸ
	public Account[] searchAccountsByName(String ownerName);
	
	// ���¹�ȣ�� Ư������ ���(����) ���
	public boolean closeAccount(String accountNo);
}
