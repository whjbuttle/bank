package ams;

import java.util.Scanner;

// 컨트롤러 패턴 (공항의 관제탑)

public class ProcessMain {
	public static void main(String[] args) {
		Bank bank = new Bank(1000);
		Scanner scanner = new Scanner(System.in);
		int input = 0, key = 0;
		while (true) {	// 무한루프
			try {
				System.out.println("1.계좌개설 2.계좌조회(번호) 3.계좌조회(이름) 4.전체조회 5.계좌삭제");
				input = scanner.nextInt();
				key = inputCheck(input,1,5);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("숫자만 입력가능합니다.");
				System.out.println("ProcessMain 의 Try-catch 에러발생");
			}
			
			switch (key) {
			case 1:
				int accountNo = (int) ((Math.random() * 999999) + 11110);
				String strAccountNo = String.valueOf(accountNo);
				System.out.println("예금주 이름 : ");
				String name = scanner.next();
				System.out.println("비밀번호 : ");
				String pass = scanner.next();
				System.out.println("예금액 : ");
				int inputMoney = scanner.nextInt();
				bank.openAccount(strAccountNo, name, pass, inputMoney);
				break;
			
			case 2:
				System.out.println("=== 계좌번호 조회(번호 입력) ===");
				System.out.println("=== 계좌번호 입력 : ");
				String searchAccountNo = scanner.next();
				
				Account account = bank.searchAccountNo(searchAccountNo);
				if (account != null) {
					System.out.println(account.toString());
				} else {
					System.out.println("조회결과가 없습니다.");
				}
				break;
				
			case 3:
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
				break;
			
			case 4:
				System.out.println("=== 계좌번호 전체 목록 출력 ===");
				BankBook[] list = bank.getBankBooklist();
				if (list.length != 0) {
					for (int i = 0; i < bank.getCount(); i++) {
						System.out.println(list[i].toString());
					}
				} else {
					System.out.println("계좌가 하나도 없습니다.");
				}
				break;
				
			case 5:
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
				break;
				
			default:
				break;
			}
		}
	}

	private static int inputCheck(int input, int first, int last) {
		int key = input;
		if (key < first || key > last) {
			System.out.println("초기메뉴의 선택범위를 넘어섰습니다.");
			return 0;
		} else {
			return key;
		}
	}
	
	
}
