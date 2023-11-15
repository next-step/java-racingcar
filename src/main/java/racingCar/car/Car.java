package racingCar.car;

import racingCar.util.NumberSupplier;

public class Car {
	private static final int FORWARD_CONDITION_NUM = 3;

	public int distance;
	public CarName carName;
	private final NumberSupplier numberSupplier;

	public Car(int distance, NumberSupplier numberSupplier) {
		this.distance = distance;
		this.numberSupplier = numberSupplier;
	}

	public Car(int distance, NumberSupplier numberSupplier, CarName carName) {
		this.distance = distance;
		this.numberSupplier = numberSupplier;
		this.carName = carName;
	}

	public void move() {
		int randomNumber = numberSupplier.get();
		if (randomNumber > FORWARD_CONDITION_NUM) {
			distance++;
		}
	}
}
