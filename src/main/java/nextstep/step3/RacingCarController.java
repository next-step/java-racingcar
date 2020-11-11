package nextstep.step3;

import nextstep.step3.domain.RacingCars;
import nextstep.step3.view.ResultView;

public class RacingCarController {
	private static final String TRY_NUMBER_MUST_POSITIVE = "시도 횟수는 양수이어야 합니다.";

	public void startGame(String carName, int tryNumber) {
		validate(tryNumber);
		RacingCars racingCars = new RacingCars(carName);
		tryRacing(tryNumber, racingCars);
	}

	protected void validate(int tryNumber) {
		if (tryNumber < 0) {
			throw new IllegalArgumentException(TRY_NUMBER_MUST_POSITIVE);
		}
	}

	private void tryRacing(int tryNumber, RacingCars racingCars) {
		System.out.println("실행 결과");
		ResultView resultView = new ResultView();
		for(int i = 0; i < tryNumber; i++) {
			racingCars.move();
			resultView.showRacingResult(racingCars);
		}
		resultView.printRacingWinner(racingCars.getRacingWinnerNames());
	}
}
