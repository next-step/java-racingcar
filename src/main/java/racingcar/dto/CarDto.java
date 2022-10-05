package racingcar.dto;

public class CarDto {

	private final String name;
	private final Integer position;

	public CarDto(String name, Integer position) {
		this.name = name;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public Integer getPosition() {
		return position;
	}
}
