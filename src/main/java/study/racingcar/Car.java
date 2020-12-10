package study.racingcar;

import java.util.Random;

public class Car {
	private int position;
	private int fuelGage;
	private final int gasMileage;
	private static final int INITIAL_GAS_MILEAGE = 4;
	private final Random random = new Random();

	public Car() {
		this.position = 0;
		this.fuelGage = 0;
		this.gasMileage = INITIAL_GAS_MILEAGE;
	}

	public void fillUpFuel(int fuel) {
		fuelGage = fuel;
	}

	public void pushGasPedal() {
		if (gasMileage <= fuelGage)
			advanced();
	}

	public void advanced() {
		this.position += 1;
	}

	public int getPosition() {
		return position;
	}

}
