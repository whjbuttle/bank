package ams;

public class SelectionSort {
	public static void main(String[] args) {
		int length = 10;
		int[] arr = new int[length];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = (int) ((Math.random()*100)-1);
		}
		System.out.println("���� ��");
		for (int i : arr) {
			System.out.print(i + "\t");
		}
		System.out.println();
		System.out.println("���� ��");
		//������ ����
		int temp = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length; j++) {
				if (arr[i]>arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for (int i : arr) {
			System.out.print(i + "\t");
		}
	}
}
