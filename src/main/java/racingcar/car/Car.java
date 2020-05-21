package racingcar.car;

import java.util.Random;

public class Car {
	private int position;
	private int moveAbility;
	public static final int DEFAULT_CAR_POSITION = 1;
	public static final int DEFAULT_CAR_ABILITY = 1;
	public static final int DEFAULT_VALID_MOVING_NUMBER = 4;

	public Car() {
		this(DEFAULT_CAR_POSITION, DEFAULT_CAR_ABILITY);
	}
	
	public Car(int position , int ability) {
		this.position = position;
		this.moveAbility = ability;
	}
	
	public void move(int power) {
		if (power > DEFAULT_VALID_MOVING_NUMBER) {
			position += moveAbility;
		}
	}

	public int getPosition() {
		return this.position;
	}
}
