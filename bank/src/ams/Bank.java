package ams;

public class Bank implements BankRole {
	private BankBook[] bankBooklist;	// ������ ����Ʈ�� �����ϴ� �迭
	private int count;					// ���� �������� ����
	
	public Bank(int count) {
		bankBooklist = new BankBook[count];
		/*
		 �迭������
		 �迭�� �޼ҵ� �Ʒ� ���������� ����� ����� int[] nums = new int[10];
		 ������ ���� �� bankBookList �迭�� �ʵ忡 ����� �ν��Ͻ� �����Դϴ�.
		 �ν��Ͻ������� �����ڸ� ���� �ʱ�ȭ �Ϸ��� ��� ���� ����ó�� �մϴ�
		 �׸��� �迭 ������ ���ڸ� ǥ���ϴ� count �� �ݵ�� �ʵ忡 �������־���մϴ�.
		 */
		
	}
	
	public BankBook[] getBankBooklist() {
		return bankBooklist;
	}

	public int getCount() {
		return count;
	}


	@Override
	public void openAccount(String accountNo, String ownerName, String password, int restMoney) {
		// ��������� Account Ŭ������ ��ü�� ���� �����ϰ� �ذ�
		Account bankBook = new BankBook(accountNo, ownerName, password, restMoney);
		// ĳ���� : ū ������ ��ü�� ���� ������ �������� �� �� �߻��ϴ� ������ �ذ��ϱ� ���� �ʿ��� ���
		bankBooklist[count] = (BankBook) bankBook;
		count++;	// ���尳���� ������Ų��
		System.out.println(bankBook.toString() + "���� ���� ����");
	}

	@Override
	public Account searchAccountNo(String accountNo) {
		Account searchAccount = null;	// ���������� 
		/*
		 �������� ����(������)�� ���� 3������ �ִ�
		 1. Ŭ���� ���� : ������Ʈ ��ü�� ����		ex) static �̶� Ű����� ����� Pay.TAX
		 2. �ν��Ͻ� ���� : Ŭ���� ���ο� ����		ex) �ʵ忡 ����� static�� ���� ����
		 3. ����(����)���� : �޼ҵ� ���ο� ����	ex) searchAccount
		 */
		for(int i = 0; i < getCount(); i++){
			// bankBookList[] �� bankBookList �� ����ִ� ���尴ü �ϳ��� ����ŵ�ϴ�.
			// equals() �� �ڹ�API �� �ִ� java.lang.String Ŭ������ �޼ҵ�� ��Ʈ�� ���� �񱳸� �Ѵ�. ������ true�� ����
			if (bankBooklist[i].getAccountNo().equals(accountNo)) {
				searchAccount = bankBooklist[i];
				return searchAccount;
				// ã���� �ϴ� ���¸� ã���� ���� ��ȯ�ϰ� for���� �����Ѵ�
			}
		}
		return searchAccount;
	}

	@Override
	public Account[] searchAccountsByName(String ownerName) {
		int tempCount = searchCountByName(ownerName);
		if(tempCount == 0){
			return null;
		}
		BankBook[] tempList = new BankBook[tempCount];
		tempCount = 0;
		for(int i = 0; i < getCount(); i++){
			
			if (bankBooklist[i].getOwnerName().equals(ownerName)){
				tempList[tempCount] = bankBooklist[i];
				tempCount++;
			}
		}
		return tempList;
	}

	private int searchCountByName(String ownerName) {
		int searchCount = 0;	// ���������� ������ �ʱ�ȭ ==> �ڹٹ���
		for (int i = 0; i < getCount(); i++) {
			searchCount++;
		}
		return searchCount;
	}

	@Override
	public boolean closeAccount(String accountNo) {
		boolean isClose = false;	
		// boolean Ÿ���� ����Ʈ ���� false �̴�. ���� �������� �ʱ�ȭ�� false�� �Ѵ�
		for (int i = 0; i < getCount(); i++) {
			if (bankBooklist[i].getAccountNo().equals(accountNo)) {
				isClose = true;
				// �迭���� ��Ҹ� �����ϴ� for�� ����
				for(int j = i; i < getCount()-1; j++){	// �� i���� �����ϴ��� �˾ƾ�
					bankBooklist[j] = bankBooklist[j+1];
				}
				count --;
			}
		}
		return isClose;
	}
	
}
