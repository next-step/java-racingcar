package racing.domain;

public class Car implements Comparable<Car> {

	private static final int START_POINT = 0;
	private static final int MOVE_PIVOT = 4;

	private final RandomNum randomNum;
	private CarName name;
	private int location;

	public Car(String name, RandomNum randomNum) {
		this(name, START_POINT, randomNum);
	}

	public Car(String name, int location, RandomNum randomNum) {
		this.name = new CarName(name);
		this.location = location;
		this.randomNum = randomNum;
	}

	public void move() {
		if (isMovable(randomNum.getRandomNumber())) {
			moveForward();
		}
	}

	private boolean isMovable(int randomNum) {
		return randomNum >= MOVE_PIVOT;
	}

	private void moveForward() {
		this.location += 1;
	}

	public int getLocation() {
		return location;
	}

	public String getName() {
		return name.getName();
	}

	@Override
	public int compareTo(Car car) {
		if (this.location > car.getLocation())
			return 1;
		else if (this.location < car.getLocation())
			return -1;
		return 0;
	}
}
