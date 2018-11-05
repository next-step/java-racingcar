package racinggame.dto;

import racinggame.domain.Car;

public class CarDto {

	private String name;
	private Integer position;

	public CarDto(Car car) {
		name = car.getName();
		position = car.getCurrentPosition();
	}

	public String getStatus() {
		StringBuilder status = new StringBuilder(name).append(" : ");
		for(int i = 0; i < position; i++) {
			status.append("-");
		}
		return status.toString();
	}

	public String getName() {
		return name;
	}

	public Integer getPosition() {
		return position;
	}
}
