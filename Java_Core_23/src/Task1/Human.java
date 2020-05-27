package Task1;

public class Human {

	private int mass;
	private int height;

	public Human() {
	}

	public Human(int mass, int height) {
		super();
		this.mass = mass;
		this.height = height;
	}

	public int getMass() {
		return mass;
	}

	public void setMass(int mass) {
		this.mass = mass;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return "Human [mass=" + mass + ", height=" + height + "]";
	}

}
