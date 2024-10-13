package step4.domain.builder;

import step4.domain.car.Car;
import step4.domain.movestrategy.CarMoveStrategy;

public class CarBuilder {
	private String name;
	private int speed;
	private CarMoveStrategy moveStrategy;

	public CarBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public CarBuilder setSpeed(int speed) {
		this.speed = speed;
		return this;
	}

	public CarBuilder setStrategy(CarMoveStrategy strategy) {
		this.moveStrategy = strategy;
		return this;
	}

	public Car build() {
		return new Car(name, moveStrategy, speed);
	}
}
