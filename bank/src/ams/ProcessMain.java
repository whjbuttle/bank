package ams;

import java.util.Scanner;

// ��Ʈ�ѷ� ���� (������ ����ž)

public class ProcessMain {
	public static void main(String[] args) {
		Bank bank = new Bank(1000);
		Scanner scanner = new Scanner(System.in);
		int input = 0, key = 0;
		while (true) {	// ���ѷ���
			try {
				System.out.println("1.���°��� 2.������ȸ(��ȣ) 3.������ȸ(�̸�) 4.��ü��ȸ 5.���»���");
				input = scanner.nextInt();
				key = inputCheck(input,1,5);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("���ڸ� �Է°����մϴ�.");
				System.out.println("ProcessMain �� Try-catch �����߻�");
			}
			
			switch (key) {
			case 1:
				int accountNo = (int) ((Math.random() * 999999) + 11110);
				String strAccountNo = String.valueOf(accountNo);
				System.out.println("������ �̸� : ");
				String name = scanner.next();
				System.out.println("��й�ȣ : ");
				String pass = scanner.next();
				System.out.println("���ݾ� : ");
				int inputMoney = scanner.nextInt();
				bank.openAccount(strAccountNo, name, pass, inputMoney);
				break;
			
			case 2:
				System.out.println("=== ���¹�ȣ ��ȸ(��ȣ �Է�) ===");
				System.out.println("=== ���¹�ȣ �Է� : ");
				String searchAccountNo = scanner.next();
				
				Account account = bank.searchAccountNo(searchAccountNo);
				if (account != null) {
					System.out.println(account.toString());
				} else {
					System.out.println("��ȸ����� �����ϴ�.");
				}
				break;
				
			case 3:
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
				break;
			
			case 4:
				System.out.println("=== ���¹�ȣ ��ü ��� ��� ===");
				BankBook[] list = bank.getBankBooklist();
				if (list.length != 0) {
					for (int i = 0; i < bank.getCount(); i++) {
						System.out.println(list[i].toString());
					}
				} else {
					System.out.println("���°� �ϳ��� �����ϴ�.");
				}
				break;
				
			case 5:
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
				break;
				
			default:
				break;
			}
		}
	}

	private static int inputCheck(int input, int first, int last) {
		int key = input;
		if (key < first || key > last) {
			System.out.println("�ʱ�޴��� ���ù����� �Ѿ���ϴ�.");
			return 0;
		} else {
			return key;
		}
	}
	
	
}
