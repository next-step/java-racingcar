package simpleracing.execute;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import simpleracing.input.CarRacingInitValue;

public class CarRacingGame implements CarGame {
	private static final String WINNER_CONTENT = "우승자는 %s입니다.";

	String result = "";
	private List<Car> cars;
	private Movable moving = new RacingMoving();

	public CarRacingGame(CarRacingInitValue initValue) {
		this.cars = generateCarsForRacing(initValue);
	}

	@Override
	public void play() {
		cars.stream()
			.forEach(car -> {
				car.play(moving);
				result += car.getName() + " : " + car.getLocation() + "\n";
			});
	}

	@Override
	public void judge(CarRacingReferee referee) {
		result += String.format(WINNER_CONTENT, referee.judge(cars)
													   .stream()
													   .map(car -> car.getName())
													   .collect(Collectors.joining("와 ")));
	}

	@Override
	public String getRacingResult() {
		return this.result;
	}

	private List<Car> generateCarsForRacing(CarRacingInitValue initValue) {
		return IntStream.range(0, initValue.getCarCount())
						.mapToObj(carNumber -> new Car(initValue.getNames()
																.get(carNumber)
																.trim()))
						.collect(toList());
	}

}
