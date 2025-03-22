package racingcar;

import java.util.List;
import java.util.stream.Stream;

import racingcar.domain.Cars;
import racingcar.domain.MovingStrategy;
import racingcar.domain.Race;
import racingcar.domain.RaceResult;
import racingcar.domain.RandomMovingStrategy;
import racingcar.view.OutputView;

public class RaceService {
	private final Race race;
	private final Cars cars;

	public RaceService(String carInput, int roundInput) {
		List<String> names = Stream.of(carInput.split(","))
			.map(String::trim)
			.toList();
		this.race = new Race(roundInput);
		this.cars = new Cars(names);
	}

	public void runRace() {
		OutputView.printResultMessage();
		while (race.hasRemainRound()) {
			runOneRound();
		}
		OutputView.printWinner(RaceResult.determineWinner(cars.getCarsNameAndLocation()));
	}

	private void runOneRound() {
		cars.moveCars(randomMovingStrategy());
		race.reduceRound();
		cars.getCarsNameAndLocation()
			.forEach(carInfo -> OutputView.printCarDistance(carInfo.name(), carInfo.location()));
		OutputView.printEndOneRound();
	}

	private MovingStrategy randomMovingStrategy() {
		return new RandomMovingStrategy();
	}

}
