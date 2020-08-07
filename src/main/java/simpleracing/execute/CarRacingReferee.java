package simpleracing.execute;

import static java.util.stream.Collectors.toList;

import java.util.Comparator;
import java.util.List;

import simpleracing.exception.CarRacingException;

public class CarRacingReferee {

	private List<Car> winner;

	public List<Car> announceWinner() {
		if (winner == null || winner.isEmpty()) {
			throw new CarRacingException("아직 경기가 끝나지 않아 결과가 나오지 않았습니다.");
		}

		return this.winner;
	}

	public void judgeRacingResult(List<Car> cars) {
		int distanceOfWinner = getDistanceOfWinner(cars);

		this.winner = cars.stream()
						  .filter(car -> getDistanceOf(car) == distanceOfWinner)
						  .collect(toList());
	}

	private int getDistanceOf(Car car) {
		return car.getLocation()
				  .length();
	}

	private int getDistanceOfWinner(List<Car> cars) {
		return cars.stream()
				   .max(Comparator.comparingInt(car -> getDistanceOf(car)))
				   .get()
				   .getLocation().length();
	}
}
