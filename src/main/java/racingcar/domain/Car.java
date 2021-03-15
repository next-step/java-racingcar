package racingcar.domain;

public class Car {
	private String carName;
	private int position;

	public Car() {
		this("undefined", 0);
	}

	public Car(String carName) {
		this(carName, 0);
	}

	public Car(String carName, int position) {
		if (carName == null) {
			carName = "undefined";
		}
		this.carName = carName;
		this.position = position;
	}

	public String getCarName() {
		return this.carName;
	}

	public int getPosition() {
		return this.position;
	}

	public void move() {
		this.position += 1;
	}

	public void moveOrStop(int randomNumber) {
		if (randomNumber >= 4) {
			this.move();
		}
	}

	public Car copy(Car car) {
		Car copyCar = new Car(car.getCarName());
		copyCar.position = car.getPosition();
		return copyCar;
	}
}
