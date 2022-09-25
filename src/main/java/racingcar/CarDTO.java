package racingcar;

public class CarDTO {

	private final int position;

	public CarDTO(Car car) {
		this.position = car.getPosition();
	}

	public int getPosition() {
		return position;
	}
}
