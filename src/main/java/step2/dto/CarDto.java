package step2.dto;

import step2.domain.Car;

public class CarDto {

	private final String name;
	private final int step;

	private CarDto(String name, int step) {
		this.name = name;
		this.step = step;
	}

	static CarDto of(Car car) {
		return new CarDto(car.getName(), car.getStep());
	}

	public String getName() {
		return name;
	}

	public int getStep() {
		return step;
	}

}
