package ams;

import java.util.Scanner;

// ��Ŭ���� �ڵ� �ڵ����� ����Ű : CTRL + SHIFT + F

public class BankMain {
	public static void main(String[] args) {
		Bank bank = new Bank(100);

		Scanner scanner = new Scanner(System.in);
		int accountNo = (int) ((Math.random() * 999999) + 11110);

		String strAccountNo = String.valueOf(accountNo);
		System.out.println("������ �̸� : ");
		String name = scanner.next();
		System.out.println("��й�ȣ : ");
		String pass = scanner.next();
		System.out.println("���ݾ� : ");
		int inputMoney = scanner.nextInt();

		bank.openAccount(strAccountNo, name, pass, inputMoney);
		
		//searchByName(bank, scanner);
		
		//searchByNo(bank, scanner);

		//searchList(bank);
	
		
		System.out.println("=== ���� ���� ===");
		System.out.println("�����Ϸ��� ���¹�ȣ �Է�");
		String deleteAccount = scanner.next();
		Account account1 = bank.searchAccountNo(deleteAccount);
		if (account1 != null) {
			boolean isClose = bank.closeAccount(deleteAccount);
			if (isClose) {
				System.out.println("���� �Ϸ�");
			} else {
				System.out.println("������ �Ұ����մϴ�. �������� ���ǹٶ��ϴ�.");
			}
		} else {
			System.out.println("�����Ϸ��� ��ȸ�� ���°� �������� �ʽ��ϴ�.");
		}
	
	}



	private static void searchList(Bank bank) {
		System.out.println("=== ���¹�ȣ ��ü ��� ��� ===");
		BankBook[] list = bank.getBankBooklist();
		if (list != null) {
			for (int i = 0; i < bank.getCount(); i++) {
				System.out.println(list[i].toString());
			}
		} else {
			System.out.println("���°� �ϳ��� �����ϴ�.");
		}
	}

	// �޼ҵ� �����丵 ��� : ALT + SHIFT + M

	private static void searchByNo(Bank bank, Scanner scanner) {
		System.out.println("=== ���¹�ȣ ��ȸ(��ȣ �Է�) ===");
		System.out.println("=== ���¹�ȣ �Է� : ");
		String searchAccountNo = scanner.next();
		
		Account account = bank.searchAccountNo(searchAccountNo);
		if (account != null) {
			System.out.println(account.toString());
		} else {
			System.out.println("��ȸ����� �����ϴ�.");
		}
	}
	
	
	
	private static void searchByName(Bank bank, Scanner scanner) {
		System.out.println("=== ���¹�ȣ ��ȸ (�̸��Է�)===");
		String inputName = scanner.next();
		BankBook[] bankBooks = (BankBook[]) bank
				.searchAccountsByName(inputName);	// CTRL�� ���� ä�� �޼ҵ� Ŭ��
		if (bankBooks != null) {
			for (int i = 0; i < bankBooks.length; i++) {
				System.out.println(bankBooks[i].toString());
			}
		} else {
			System.out.println("��ȸ�̸� ����");
		}
	}

	
		
		
}
