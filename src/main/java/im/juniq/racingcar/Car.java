package im.juniq.racingcar;

public class Car {
	private static final int CAR_NAME_LENGTH_LIMIT = 5;
	private String name;
	private int position = 0;
	private MovingStrategy movingStrategy;

	public Car(String name) {
		checkCarName(name);
		this.name = name;
		this.movingStrategy = new RandomNumberMovingStrategy();
	}

	public Car(String name, MovingStrategy movingStrategy) {
		checkCarName(name);
		this.name = name;
		this.movingStrategy = movingStrategy;
	}

	private void checkCarName(String name) {
		if (name.length() > CAR_NAME_LENGTH_LIMIT) {
			throw new IllegalArgumentException("자동차 이름은 5자 이하이어야 합니다.");
		}
	}

	public void move() {
		if (movingStrategy.isMoving()) {
			position++;
		}
	}

	public void move(MovingStrategy movingStrategy) {
		if (movingStrategy.isMoving()) {
			position++;
		}
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
