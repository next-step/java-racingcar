package step4.model;

import java.util.List;

public class Cars {
	private final List<Car> cars;

	public Cars(final List<Car> list){
		this.cars = list;
	}

	public List<Car> getCars() {
		return cars;
	}
}
