package nextstep.step3;

import nextstep.step3.domain.RacingCars;
import nextstep.step3.domain.RandomGenerator;
import nextstep.step3.view.ResultView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCarController {

	private static final String INPUT_CARNAME_REQUIRED = "자동차 이름은 필수 입력 입니다.";
	private static final String CARNAME_IS_BELOW_FIVE = "자동차 이름은 5자를 넘길 수 없습니다.";
	private static final String TRY_NUMBER_MUST_POSITIVE = "시도 횟수는 양수이어야 합니다.";

	public void startGame(String carName, int tryNumber) {
		List<String> carNames = getCarNames(carName);
		validate(carNames, tryNumber);
		RacingCars racingCars = new RacingCars(carNames);
		tryRacing(tryNumber, racingCars);
	}

	protected List<String> getCarNames(String inputCarNames) {
		if (inputCarNames.isEmpty()) {
			throw new IllegalArgumentException(INPUT_CARNAME_REQUIRED);
		}
		String[] names = inputCarNames.split(",");
		return Stream.of(names)
				.peek(name -> {
					if (name.length() > 5) {
						throw new IllegalArgumentException(CARNAME_IS_BELOW_FIVE);
					}
				})
				.collect(Collectors.toList());
	}

	protected void validate(List<String> carNames, int tryNumber) {
		if (carNames.size() == 0) {
			throw new IllegalArgumentException(INPUT_CARNAME_REQUIRED);
		}
		if (tryNumber < 0) {
			throw new IllegalArgumentException(TRY_NUMBER_MUST_POSITIVE);
		}
	}

	private void tryRacing(int tryNumber, RacingCars racingCars) {
		System.out.println("실행 결과");
		ResultView resultView = new ResultView();
		for(int i = 0; i < tryNumber; i++) {
			racingCarMove(racingCars);
			resultView.showRacingResult(racingCars);
		}
		resultView.printRacingWinner(racingCars.getRacingWinnerNames());
	}

	private void racingCarMove(RacingCars racingCars) {
		RandomGenerator randomGenerator = new RandomGenerator();
		racingCars.getRacingCars().forEach( car -> car.move(randomGenerator.getRandomNumber()));
	}
}
