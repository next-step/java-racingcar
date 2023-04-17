package step3_racingcar.dto;

import step3_racingcar.domain.Car;

public class CarDTO {
	private final int position;

	public CarDTO(Car car) {
		this.position = car.getPosition();
	}

	public int getPosition() {
		return position;
	}

}
