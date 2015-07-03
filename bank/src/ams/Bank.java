package ams;

public class Bank implements BankRole {
	private BankBook[] bankBooklist;	// 통장을 리스트로 관리하는 배열
	private int count;					// 통장 수량관리 변수
	
	public Bank(int count) {
		bankBooklist = new BankBook[count];
		/*
		 배열선언방법
		 배열이 메소드 아래 지역변수로 선언될 경우라면 int[] nums = new int[10];
		 하지만 지금 이 bankBookList 배열은 필드에 선언된 인스턴스 변수입니다.
		 인스턴스변수를 생성자를 통해 초기화 하려는 경우 위의 예시처럼 합니다
		 그리고 배열 내부의 숫자를 표시하는 count 를 반드시 필드에 선언해주어야합니다.
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
		// 통장생성을 Account 클래스의 객체를 통해 간단하게 해결
		Account bankBook = new BankBook(accountNo, ownerName, password, restMoney);
		// 캐스팅 : 큰 개념의 객체를 작은 범위에 담으려고 할 때 발생하는 문제를 해결하기 위해 필요한 기능
		bankBooklist[count] = (BankBook) bankBook;
		count++;	// 통장개수를 증가시킨다
		System.out.println(bankBook.toString() + "으로 계좌 개설");
	}

	@Override
	public Account searchAccountNo(String accountNo) {
		Account searchAccount = null;	// 지역변수로 
		/*
		 변수에는 영역(스코프)에 따라 3가지가 있다
		 1. 클래스 변수 : 프로젝트 전체에 적용		ex) static 이라 키워드로 선언된 Pay.TAX
		 2. 인스턴스 변수 : 클래스 내부에 적용		ex) 필드에 선언된 static이 없는 변수
		 3. 지역(로컬)변수 : 메소드 내부에 적용	ex) searchAccount
		 */
		for(int i = 0; i < getCount(); i++){
			// bankBookList[] 는 bankBookList 에 들어있는 통장객체 하나를 가리킵니다.
			// equals() 는 자바API 에 있는 java.lang.String 클래스의 메소드로 스트링 값의 비교를 한다. 같으면 true를 리턴
			if (bankBooklist[i].getAccountNo().equals(accountNo)) {
				searchAccount = bankBooklist[i];
				return searchAccount;
				// 찾고자 하는 계좌를 찾으면 값을 반환하고 for문을 종료한다
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
		int searchCount = 0;	// 지역변수는 무조건 초기화 ==> 자바문법
		for (int i = 0; i < getCount(); i++) {
			searchCount++;
		}
		return searchCount;
	}

	@Override
	public boolean closeAccount(String accountNo) {
		boolean isClose = false;	
		// boolean 타입의 디폴트 값은 false 이다. 따라서 지역변수 초기화는 false로 한다
		for (int i = 0; i < getCount(); i++) {
			if (bankBooklist[i].getAccountNo().equals(accountNo)) {
				isClose = true;
				// 배열에서 요소를 삭제하는 for문 패턴
				for(int j = i; i < getCount()-1; j++){	// 왜 i부터 시작하는지 알아야
					bankBooklist[j] = bankBooklist[j+1];
				}
				count --;
			}
		}
		return isClose;
	}
	
}
