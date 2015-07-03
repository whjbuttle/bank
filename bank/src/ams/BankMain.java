package ams;

import java.util.Scanner;

// 이클립스 코드 자동정렬 단축키 : CTRL + SHIFT + F

public class BankMain {
	public static void main(String[] args) {
		Bank bank = new Bank(100);

		Scanner scanner = new Scanner(System.in);
		int accountNo = (int) ((Math.random() * 999999) + 11110);

		String strAccountNo = String.valueOf(accountNo);
		System.out.println("예금주 이름 : ");
		String name = scanner.next();
		System.out.println("비밀번호 : ");
		String pass = scanner.next();
		System.out.println("예금액 : ");
		int inputMoney = scanner.nextInt();

		bank.openAccount(strAccountNo, name, pass, inputMoney);
		
		//searchByName(bank, scanner);
		
		//searchByNo(bank, scanner);

		//searchList(bank);
	
		
		System.out.println("=== 계좌 삭제 ===");
		System.out.println("삭제하려는 계좌번호 입력");
		String deleteAccount = scanner.next();
		Account account1 = bank.searchAccountNo(deleteAccount);
		if (account1 != null) {
			boolean isClose = bank.closeAccount(deleteAccount);
			if (isClose) {
				System.out.println("삭제 완료");
			} else {
				System.out.println("삭제가 불가능합니다. 전산팀에 문의바랍니다.");
			}
		} else {
			System.out.println("삭제하려고 조회한 계좌가 존재하지 않습니다.");
		}
	
	}



	private static void searchList(Bank bank) {
		System.out.println("=== 계좌번호 전체 목록 출력 ===");
		BankBook[] list = bank.getBankBooklist();
		if (list != null) {
			for (int i = 0; i < bank.getCount(); i++) {
				System.out.println(list[i].toString());
			}
		} else {
			System.out.println("계좌가 하나도 없습니다.");
		}
	}

	// 메소드 리팩토링 기법 : ALT + SHIFT + M

	private static void searchByNo(Bank bank, Scanner scanner) {
		System.out.println("=== 계좌번호 조회(번호 입력) ===");
		System.out.println("=== 계좌번호 입력 : ");
		String searchAccountNo = scanner.next();
		
		Account account = bank.searchAccountNo(searchAccountNo);
		if (account != null) {
			System.out.println(account.toString());
		} else {
			System.out.println("조회결과가 없습니다.");
		}
	}
	
	
	
	private static void searchByName(Bank bank, Scanner scanner) {
		System.out.println("=== 계좌번호 조회 (이름입력)===");
		String inputName = scanner.next();
		BankBook[] bankBooks = (BankBook[]) bank
				.searchAccountsByName(inputName);	// CTRL을 누른 채로 메소드 클릭
		if (bankBooks != null) {
			for (int i = 0; i < bankBooks.length; i++) {
				System.out.println(bankBooks[i].toString());
			}
		} else {
			System.out.println("조회이름 없음");
		}
	}

	
		
		
}
