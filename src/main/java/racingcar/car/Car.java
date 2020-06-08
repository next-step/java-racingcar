package racingcar.car;

public class Car implements Comparable<Car>{

	public static final int DEFAULT_CAR_POSITION = 1;
	public static final int DEFAULT_CAR_ABILITY = 1;
	public static final int DEFAULT_VALID_MOVING_NUMBER = 4;
	private int position;
	private int moveAbility;
	private String name;

	public Car(String name) {
		this(DEFAULT_CAR_POSITION, DEFAULT_CAR_ABILITY, name);
	}

	public Car(int position, int ability, String name) {
		this.position = position;
		this.moveAbility = ability;
		this.name = name;
	}

	public void move(int power) {
		if (power > DEFAULT_VALID_MOVING_NUMBER) {
			position += moveAbility;
		}
	}

	public int getPosition() {
		return this.position;
	}

	public String getName() {
		return this.name;
	}

	@Override
	public int compareTo(Car otherCar) {
		return Integer.compare(this.position , otherCar.getPosition());
	}

	public boolean isEqualPosition(int otherPosition){
		return this.position == otherPosition ? true : false;
	}
}
