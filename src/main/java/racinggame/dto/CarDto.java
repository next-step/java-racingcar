package racinggame.dto;

import racinggame.domain.Car;

public class CarDto {

	private String name;
	private Integer position;

	public CarDto(Car car) {
		name = car.getName();
		position = car.getCurrentPosition();
	}

	public String print(String displayString) {
		StringBuilder status = new StringBuilder(name).append(" : ");
		for(int i = 0; i < position; i++) {
			status.append(displayString);
		}
		return status.toString();
	}
}
