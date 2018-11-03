package racinggame;

/**
 * Created by hspark on 03/11/2018.
 */
public class CarDTO {
	private int position;

	public static CarDTO of(Car car) {
		CarDTO carDTO = new CarDTO();
		carDTO.setPosition(car.getPosition());
		return carDTO;
	}

	private void setPosition(int position) {
		this.position = position;
	}

	public int getPosition() {
		return position;
	}
}
