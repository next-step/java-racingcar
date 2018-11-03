package racinggame.car;

/**
 * Created by hspark on 03/11/2018.
 */
public class CarDTO {

	private String name;
	private int position;

	public static CarDTO of(Car car) {
		CarDTO carDTO = new CarDTO();
		carDTO.setPosition(car.getPosition());
		carDTO.setName(car.getName());
		return carDTO;
	}

	public String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	private void setPosition(int position) {
		this.position = position;
	}

	public int getPosition() {
		return position;
	}
}
