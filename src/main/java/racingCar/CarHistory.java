package racingCar;

/**
 * @author : byungkyu
 * @date : 2020/12/09
 * @description :
 **/
public class CarHistory {
	private String name;
	private int position;

	public CarHistory(Car car) {
		this.name = car.getName();
		this.position = car.getPosition();
	}

	public String getName() {
		return name;
	}

	public int getPosition() {
		return position;
	}
}
