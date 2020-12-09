package racingCar;

import java.util.Random;

/**
 * @author : byungkyu
 * @date : 2020/12/07
 * @description :
 **/
public class Car {
	private static final int MOVABLE_MINIMUM_VALUE = 4;
	private int position;

	public Car() {
		position = 0;
	}

	public Car(Car copyCar) {
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
}
