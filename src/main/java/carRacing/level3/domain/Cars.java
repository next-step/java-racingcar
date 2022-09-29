package carRacing.level3.domain;

import carRacing.level3.service.MovingStartegy;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {
	private List<Car> carList;

	public Cars(List<Car> carList) {
		this.carList = carList;
	}

	public Cars prepare(int carSum) {
		return new Cars(IntStream.range(0,carSum)
			.mapToObj(index -> new Car())
			.collect(Collectors.toList()));
	}

	public void moveCarLocation(MovingStartegy movingStartegy) {
		carList.forEach(car -> car.moveLocation(movingStartegy));
	}

	public int carLocation(int carNum){
		return carList.get(carNum).carLocation();
	}

}

