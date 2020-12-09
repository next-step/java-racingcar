package racingCar;

import java.util.Random;

/**
 * @author : byungkyu
 * @date : 2020/12/07
 * @description :
 **/
public class Car {
	private static final int MOVABLE_MINIMUM_VALUE = 4;
	private static final int CAR_NAME_LENGTH_MAXIMUM_VALUE = 5;
	private int position;
	private String name;

	public Car() {
		position = 0;
	}

	public Car(String carName) {
		validateCarName(carName);
		this.name = carName;
		this.position = 0;
	}

	private void validateCarName(String carName) {
		if (carName.length() > CAR_NAME_LENGTH_MAXIMUM_VALUE)
			throw new IllegalArgumentException("자동차의 이름은 5자를 초과할 수 없습니다.");
	}

	public Car(Car copyCar) {
		this.name = copyCar.name;
		this.position = copyCar.position;
	}

	public void move(int arg) {
		if (isMovable(arg)) {
			position++;
		}
	}

	private boolean isMovable(int arg) {
		return arg >= MOVABLE_MINIMUM_VALUE;
	}

	public void randomMove() {
		Random random = new Random();
		int condition = random.nextInt(10);
		move(condition);
	}

	public int getPosition() {
		return position;
	}

	public String getName() {
		return name;
	}
}
