package carRacing.level3.model;

import carRacing.level3.model.strategy.MovingStrategy;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

	private List<Car> carList;

	public Cars(List<Car> carList) {
		this.carList = carList;
	}

	public void initiateCars(List<String> carNameList) {
		this.carList = IntStream.range(0, carNameList.size())
			.mapToObj(index -> new Car(carNameList.get(index)))
			.collect(Collectors.toList());
	}

	public void moveCarLocation(MovingStrategy movingStrategy) {
		carList.forEach(car ->
			car.moveLocation(movingStrategy));
	}

	public int maxCarLocation() {
		return carList.stream()
			.mapToInt(car -> car.carLocation())
			.max()
			.getAsInt();
	}

	public int carLocation(int carNum) {
		return carList.get(carNum).carLocation();
	}

	public String carName(int carNum) {
		return carList.get(carNum).carName();
	}

	public int totalNum() {
		return carList.size();
	}

}

