package racinggame.domain;

public class Car implements Comparable<Car> {

	public static final int MOVE_CONDITION = 4;

	private String name;
	private Integer position;

	public Car(String name) {
		this(name, 0);
	}

	public Car(String name, Integer position) {
		this.name = name;
		this.position = position;
	}

	public int move(int randomNumber) {
		if(!canMove(randomNumber)) {
			return position;
		}
		return ++position;
	}

	public boolean canMove(int randomNumber) {
		return randomNumber >= MOVE_CONDITION;
	}

	public String getName() {
		return name;
	}

	public int getCurrentPosition() {
		return position;
	}

	public boolean isSamePosition(Car car) {
		return position.equals(car.position);
	}

	@Override
	public int compareTo(Car car) {
		return position.compareTo(car.position);
	}
}
