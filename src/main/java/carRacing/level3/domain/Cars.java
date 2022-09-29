package carRacing.level3.domain;

import carRacing.level3.service.MovingStrategy;
import carRacing.level3.service.RandomMovingStrategy;
import carRacing.level3.service.output.OutPutView;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Cars {

	private static final Integer DEFAULT_CAR_SUM = 0;

	private List<Car> carList;

	public Cars(List<Car> carList) {
		this.carList = carList;
	}

	public Cars prepare(int totalCarNum) {
		return new Cars(IntStream.range(DEFAULT_CAR_SUM, totalCarNum)
			.mapToObj(index -> new Car())
			.collect(Collectors.toList()));
	}

	public void moveCarLocation(MovingStrategy movingStartegy) {

		carList.forEach(car -> {
			car.moveLocation(movingStartegy);
			car.showMovement(new OutPutView());
		});
		new OutPutView().printSpace();
	}

	public int carLocation(int carNum) {
		return carList.get(carNum).carLocation();
	}

}

