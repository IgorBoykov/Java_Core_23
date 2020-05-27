package Task1;

import java.util.Scanner;
import java.util.function.Supplier;

public class Deputat extends Human {

	private String surname;
	private String name;
	private int age;
	public boolean bribeTaker;
	public int bribeSize;

	public Deputat(int mass, int height) {
		super(mass, height);
	}

	public Deputat(String surname, String name) {
		this.surname = surname;
		this.name = name;
	}

	public Deputat(int mass, int height, String surname, String name, int age, boolean bribeTaker) {
		super(mass, height);
		this.surname = surname;
		this.name = name;
		this.age = age;
		this.bribeTaker = bribeTaker;
	}

	public Deputat(int mass, int height, String surname, String name, int age, boolean bribeTaker, int bribeSize) {
		super(mass, height);
		this.surname = surname;
		this.name = name;
		this.age = age;
		this.bribeTaker = bribeTaker;
		this.bribeSize = bribeSize;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isBribeTaker() {
		return bribeTaker;
	}

	public void setBribeTaker(boolean bribeTaker) {
		this.bribeTaker = bribeTaker;
	}

	public int getBribeSize() {
		return bribeSize;
	}

	public void setBribeSize(int bribeSize) {
		this.bribeSize = bribeSize;
	}

	@Override
	public String toString() {
		return "Deputat [surname=" + surname + ", name=" + name + ", age=" + age + ", bribeTaker=" + bribeTaker
				+ ", bribeSize=" + bribeSize + "]";
	}

	Supplier<Integer> getBriebSum = () -> {
		Scanner sc = new Scanner(System.in);
		int sumBrieb = sc.nextInt();
		return sumBrieb;
	};

	public void takeBribe() {
		if (this.bribeTaker == false) {
			System.out.println("ƒепутат не бере хабар≥в");
		} else {
			System.out.println("яку суму хабар€ дати депутату?");
			int sumBribe = getBriebSum.get();
			if (sumBribe > 5000) {
				System.out.println("ƒепутата ув€знить пол≥ц≥€");
			} else {
				this.bribeSize = sumBribe;
				System.out.println("’абар передано");
			}
		}
	}

}
