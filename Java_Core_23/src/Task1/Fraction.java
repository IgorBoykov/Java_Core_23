package Task1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Fraction {

	Deputat deputat;
	private String name;

	ArrayList<Deputat> deputats = new ArrayList<Deputat>();

	Supplier<Deputat> createDeputat = () -> {
		Scanner sc = new Scanner(System.in);
		System.out.println("Введіть вагу депутата в кг");
		int mass = sc.nextInt();
		System.out.println("Введіть ріст депутата в см");
		int height = sc.nextInt();
		System.out.println("Введіть прізвище депутата");
		String surname = sc.next();
		System.out.println("Введіть ім'я депутата");
		String name = sc.next();
		System.out.println("ВВедіть вік депутата");
		int age = sc.nextInt();
		System.out.println("Чи являється депутат хабарником? true - якщо так ; false - якщо ні");
		boolean bribeTaker = sc.nextBoolean();
		return new Deputat(mass, height, surname, name, age, bribeTaker);
	};

	Supplier<Deputat> getDeputat = () -> {
		Scanner sc = new Scanner(System.in);
		System.out.println("Введіть прізвище депутата");
		String deputatSurName = sc.nextLine();
		System.out.println("Введіть імя депутата");
		String deputatName = sc.nextLine();
		return new Deputat(deputatSurName, deputatName);
	};

	public void addDeputat() {
		Deputat deputat = createDeputat.get();

		if (deputat.isBribeTaker()) {
			deputat.takeBribe();
		}
		deputats.add(deputat);
		System.out.println("Депутат дадано");
	}

	public void deleteDeputat() {
		Deputat deputatToDelete = getDeputat.get();

		Predicate<Deputat> isPredicate = dep -> (dep.getSurname().equalsIgnoreCase(deputatToDelete.getSurname())
				&& (dep.getName().equalsIgnoreCase(deputatToDelete.getName())));
		Optional<Deputat> findDeputat = deputats.stream().filter(isPredicate).findFirst();

		if (findDeputat.isPresent()) {
			deputats.remove(findDeputat.get());
			System.out.println("Дупутата " + findDeputat.get().getSurname().toString() + " "
					+ findDeputat.get().getName().toString() + " видалено");
		} else {
			System.out.println("Такого депутата не знайдено");
		}
	}

	public void printAllBriber() {
		List<Deputat> allBriber = deputats.stream().filter(Deputat::isBribeTaker).collect(Collectors.toList());
		allBriber.forEach(System.out::println);
	}

	public void printMostBriberTaker() {
		Comparator<Deputat> deputatBribeSizeComparator = (deputat1,
				deputat2) -> (deputat1.getBribeSize() > deputat2.getBribeSize() ? 1
						: (deputat1.getBribeSize() == deputat2.getBribeSize()) ? 0 : -1);
		Optional<Deputat> mostBriberTaker = deputats.stream().filter(Deputat::isBribeTaker)
				.max(deputatBribeSizeComparator);

		if (mostBriberTaker.isPresent()) {
			System.out.println("Найбільший хабарник - " + mostBriberTaker.get().toString());
		} else {
			System.out.println("Хабарників немає");
		}
	}

	public void printAllDeputat() {
		deputats.forEach(System.out::println);
	}

	public void deleteAllDeputat() {
		deputats.clear();
		System.out.println("Всіх депутатів виделено");
	}

	public Fraction(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Fraction [name=" + name + "]";
	}

	public String toStringAllDeputat() {
		return "Fraction [name=" + name + ": AllDeputat= " + deputats + "]";
	}

}
