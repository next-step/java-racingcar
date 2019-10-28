package step3;

import step3.view.ResultView;

import java.util.*;

public class RacingGame {
	private ResultView resultView;
	private List<Car> carList = new ArrayList<>();
	private int time;    // 이동 횟수

	public RacingGame(String inputCarName, int inputTime) {
		validate(inputCarName, inputTime);
		initCarList(inputCarName);
		this.time = inputTime;
		resultView = new ResultView(time);
	}

	private void initCarList(String inputCarName) {
		Arrays.stream(inputCarName.split(",")).forEach(name -> {
			carList.add(new Car(name));
		});
	}

	private void validate(String inputCarName, int inputTime) {
		if (inputCarName.trim().length() < 1) {
			throw new IllegalArgumentException("차량 이름 없음");
		}

		if (inputTime < 1) {
			throw new IllegalArgumentException("횟수 오류");
		}
	}

	// 실행
	public void run() {
		for (int i = 0; i < time; i++) {
			moveCar();
		}
		checkWinner();
		resultView.showResult(carList);
	}

	private void moveCar() {
		for (Car car : carList) {
			car.move();
		}
	}

	private void checkWinner() {
		int maxPosition = Collections.max(carList, Comparator.comparing(car -> car.getPosition())).getPosition();

		carList.forEach(car -> {
			car.setIsWinner(car.getPosition() == maxPosition);
		});
	}

	public List<Car> getCarList() {
		return carList;
	}
}
