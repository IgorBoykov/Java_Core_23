package Task1;

import java.util.Scanner;
import java.util.function.Supplier;

public class Application {

	public static void main(String[] args) {

		VerhovnaRada vr = new VerhovnaRada();

		Supplier<Integer> menu = () -> {
			System.out.println("������ 1 ��� ������ �������");
			System.out.println("������ 2 ��� �������� ��������� �������");
			System.out.println("������ 3 ��� ������� ��  �������");
			System.out.println("������ 4 ��� �������� ��������� �������");
			System.out.println("������ 5 ��� ������� ��������� �������");
			System.out.println("������ 6 ��� ������ �������� � �������");
			System.out.println("������ 7 ��� �������� �������� � �������");
			System.out.println("������ 8 ��� ������� ������ ���������");
			System.out.println("������ 9 ��� ������� ���������� ���������");
			Scanner sc = new Scanner(System.in);
			int number = sc.nextInt();
			return number;
		};

		while (true) {

			switch (menu.get()) {
			case 1: {
				vr.addFraction();
				break;
			}
			case 2: {
				vr.deleteFraction();
				break;
			}
			case 3: {
				vr.printAllFraction();
				break;
			}
			case 4: {
				vr.deleteAllDeputatFromFraction();
				break;
			}
			case 5: {
				vr.printEnteredFraction();
				break;
			}
			case 6: {
				vr.addDeputatToFraction();
				break;
			}
			case 7: {
				vr.deleteDeputatFromFraction();
				break;
			}
			case 8: {
				vr.printAllBriberInFraction();
				break;
			}
			case 9: {
				vr.printMainBriberInFraction();
				break;
			}
			}
		}

	}

}