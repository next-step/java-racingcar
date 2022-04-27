package racingcar.ui;

import racingcar.domain.CarStadium;
import racingcar.domain.Cars;

public class ResultView {
	private final InputView inputView;

	public ResultView(InputView inputView) {
		this.inputView = inputView;
	}

	public void showResult() {
		CarStadium carStadium = new CarStadium();

		executionResult();
		raceStart(carStadium);
		showWinners(carStadium);
	}

	private void executionResult() {
		System.out.println();
		System.out.println("실행 결과");
	}

	private void raceStart(CarStadium carStadium) {
		Cars cars = carStadium.carComes(inputView.getCarNames());
		for (int i = 0; i < inputView.getRounds(); i++) {
			carStadium.race();
			showMove(cars);
			System.out.println();
		}
	}

	private void showMove(Cars cars) {
		for (int i = 0; i < cars.count(); i++) {
			System.out.println(cars.get(i).name() + ": " + cars.get(i).carStatus());
		}
	}

	private void showWinners(CarStadium carStadium) {
		String winners = carStadium.showWinners();
		System.out.println("우승자는 " + winners + " 입니다");
	}
}
