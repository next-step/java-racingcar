package racingcar.ui;

import racingcar.domain.CarStadium;

public class ResultView {
	private final InputView inputView;

	public ResultView(InputView inputView) {
		this.inputView = inputView;
	}

	public void showResult() {
		CarStadium carStadium = new CarStadium(inputView);

		System.out.println();
		System.out.println("실행 결과");

		carStadium.racingStart();
	}
}
