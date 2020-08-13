package simpleracing.domain.tools;

import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.List;

public class CarRacingReferee implements Referee<Car> {

	@Override
	public List<Car> judge(List<Car> cars) {
		int distanceOfWinner = getDistanceOfWinner(cars);

		return cars.stream()
				   .filter(car -> car.getLocation() == distanceOfWinner)
				   .collect(toList());
	}

	private int getDistanceOfWinner(List<Car> cars) {
		return cars.stream()
				   .max(Comparator.comparingInt(car -> car.getLocation()))
				   .get()
				   .getLocation();
	}
}
