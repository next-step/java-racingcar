package carRacing.level3.model;

import carRacing.level3.model.strategy.MovingStrategy;
import java.util.List;

public class Cars {

	private List<Car> carList;

	public Cars(List<Car> carList) {
		this.carList = carList;
	}

	public void moveCarLocation(MovingStrategy movingStrategy) {
		carList.forEach(car ->
			car.moveLocation(movingStrategy));
	}

	public int carLocation(int carNum) {
		return carList.get(carNum).carLocation();
	}

}

