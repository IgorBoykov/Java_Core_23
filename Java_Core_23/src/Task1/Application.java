package Task1;

import java.util.Scanner;
import java.util.function.Supplier;

public class Application {

	public static void main(String[] args) {

		VerhovnaRada vr = new VerhovnaRada();

		Supplier<Integer> menu = () -> {
			System.out.println("Введіть 1 щоб додати фракцію");
			System.out.println("Введіть 2 щоб видалити конкретну фракцію");
			System.out.println("Введіть 3 щоб вивести усі  фракції");
			System.out.println("Введіть 4 щоб очистити конкретну фракцію");
			System.out.println("Введіть 5 щоб вивести конкретну фракцію");
			System.out.println("Введіть 6 щоб додати депутата в фракцію");
			System.out.println("Введіть 7 щоб видалити депутата з фракції");
			System.out.println("Введіть 8 щоб вивести список хабарників");
			System.out.println("Введіть 9 щоб вивести найбільшого хабарника");
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