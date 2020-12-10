package racingCar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import racingCar.domain.move.MoveUtil;

/**
 * @author : byungkyu
 * @date : 2020/12/07
 * @description :
 **/
public class Cars {

	private List<Car> cars;
	private int matchCount;
	private int lapCount;
	private RaceHistory raceHistory;
	private List<Car> winners;
	private int winnerPosition;

	public Cars(String[] carNames, int matchCount) {
		this.cars = new ArrayList<>();
		createCars(carNames);
		this.matchCount = matchCount;
		this.lapCount = 0;
		this.winnerPosition = 0;
		raceHistory = new RaceHistory();

	}

	public int getCount() {
		return cars.size();
	}

	public Cars race() {
		while (matchCount != lapCount) {
			runLap();
		}
		setWinners();
		return this;
	}

	private void setWinners() {
		winners = cars.stream().filter(car -> car.isWinner(winnerPosition))
			.collect(Collectors.toList());
	}

	public void runLap() {
		LapHistory lapHistory = new LapHistory();
		for (Car car : cars) {
			//car.randomMove();
			car.move();
			setWinnerPosition(car.getPosition());
			lapHistory.add(new CarHistory(car));
		}
		raceHistory.add(lapHistory);
		lapCount++;
	}

	private void setWinnerPosition(int position) {
		if (position > winnerPosition) {
			winnerPosition = position;
		}
	}

	public int getLapCount() {
		return lapCount;
	}

	private void createCars(String[] carNames) {
		MoveUtil moveUtil = new MoveUtil();
		IntStream.range(0, carNames.length).forEach(i -> cars.add(new Car(moveUtil, carNames[i])));
	}

	public RaceHistory getHistory() {
		return raceHistory;
	}

	public List<Car> get() {
		return cars;
	}

	public List<Car> getWinners() {
		return winners;
	}

}
