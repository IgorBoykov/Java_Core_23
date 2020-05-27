package Task1;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class VerhovnaRada {

	Fraction fraction;
	ArrayList<Fraction> fractions = new ArrayList<Fraction>();

	Supplier<Fraction> getFraction = () -> {
		Scanner sc = new Scanner(System.in);
		System.out.println("Введіть назву фракції");
		String newFraction = sc.nextLine();
		return new Fraction(newFraction);
	};

	public Optional<Fraction> findFraction() {
		Fraction fractionType = getFraction.get();
		Predicate<Fraction> isPredicateFraction = f -> f.getName().equalsIgnoreCase(fractionType.getName());
		Optional<Fraction> fractionFound = fractions.stream().filter(isPredicateFraction).findFirst();
		return fractionFound;
	}

	public void addFraction() {
		Fraction fraction = getFraction.get();
		boolean isCreated = false;

		isCreated = fractions.stream().anyMatch(f -> f.getName().equalsIgnoreCase(fraction.getName()));

		if (!isCreated) {
			fractions.add(fraction);
			System.out.println("Фракцію створено");
		} else {
			System.out.println("Фракція вже існує");
		}

	}

	public void deleteFraction() {
		Optional<Fraction> fractionToDelete = findFraction();

		if (fractionToDelete.isPresent()) {
			fractions.remove(fractionToDelete.get());
			System.out.println("Фракцію " + fractionToDelete.get().toString() + " видалено");
		} else {
			System.out.println("Фракції не існує");
		}
	}

	public void printAllFraction() {
		fractions.forEach(System.out::println);
	}

	public void printEnteredFraction() {
		Optional<Fraction> enteredFraction = findFraction();

		if (enteredFraction.isPresent()) {
			System.out.println(enteredFraction.get().toString());
			enteredFraction.get().printAllDeputat();
		} else {
			System.out.println("Фракцій немає");
		}
	}

	public void deleteAllDeputatFromFraction() {
		Optional<Fraction> enteredFraction = findFraction();

		if (enteredFraction.isPresent()) {
			enteredFraction.get().deleteAllDeputat();
		} else {
			System.out.println("Депутатів немає");
		}
	}

	public void addDeputatToFraction() {
		Optional<Fraction> enteredFraction = findFraction();

		if (enteredFraction.isPresent()) {
			enteredFraction.get().addDeputat();
			System.out.println("Депутата додано до фракції");
		} else {
			System.out.println("Фракції не існує");
		}
	}

	public void deleteDeputatFromFraction() {
		Optional<Fraction> enteredFraction = findFraction();

		if (enteredFraction.isPresent()) {
			enteredFraction.get().deleteDeputat();
		} else {
			System.out.println("Фракції не існує");
		}
	}

	public void printAllBriberInFraction() {
		Optional<Fraction> enteredFraction = findFraction();

		if (enteredFraction.isPresent()) {
			enteredFraction.get().printAllBriber();
		} else {
			System.out.println("Хабарників немає");
		}
	}

//9 - Print main bribe taker in faction
	public void printMainBriberInFraction() {
		Optional<Fraction> enteredFraction = findFraction();

		if (enteredFraction.isPresent()) {
			enteredFraction.get().printMostBriberTaker();
		} else {
			System.out.println("Такої фракції немає");
		}
	}

//6 - Print all deputy in faction	
	public void printAllDeputatInFraction() {
		Optional<Fraction> enteredFraction = findFraction();

		if (enteredFraction.isPresent()) {
			enteredFraction.get().printAllDeputat();
		} else {
			System.out.println("Депутатів в фракції немає");
		}
	}

	@Override
	public String toString() {
		return "VerhovnaRada [fraction=" + fraction + "]";
	}

}
