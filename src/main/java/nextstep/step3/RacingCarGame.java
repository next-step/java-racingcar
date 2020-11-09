package nextstep.step3;

import nextstep.step3.domain.RacingCar;
import nextstep.step3.domain.RacingCars;
import nextstep.step3.domain.RandomGenerator;
import nextstep.step3.view.InputView;
import nextstep.step3.view.ResultView;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RacingCarGame {
	private static final String INPUT_CARNAME_REQUIRED = "자동차 이름은 필수 입력 입니다.";
	private static final String CARNAME_IS_BELOW_FIVE = "자동차 이름은 5자를 넘길 수 없습니다.";
	private static final String TRY_NUMBER_MUST_POSITIVE = "시도 횟수는 양수이어야 합니다.";

	public static void main(String[] args) {
		InputView inputView = new InputView(new Scanner(System.in));
		startGame(inputView.getInputMessageCarName(), inputView.getInputMessageTryNumber());
	}

	protected static void startGame(String carName, int tryNumber) {
		List<String> carNames = getCarNames(carName);
		validate(carNames, tryNumber);
		RacingCars racingCars = new RacingCars(carNames);
		tryRacing(tryNumber, racingCars);
	}

	protected static List<String> getCarNames(String inputCarNames) {
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

	private static void validate(List<String> carNames, int tryNumber) {
		if (carNames.size() == 0) {
			throw new IllegalArgumentException(INPUT_CARNAME_REQUIRED);
		}
		if (tryNumber < 0) {
			throw new IllegalArgumentException(TRY_NUMBER_MUST_POSITIVE);
		}
	}

	private static void tryRacing(int tryNumber, RacingCars racingCars) {
		System.out.println("실행 결과");
		ResultView resultView = new ResultView();
		IntStream.range(0, tryNumber).forEach(i ->  {
			racingCarMove(racingCars);
			printRacingResult(racingCars, resultView);
		});
		printRacingWinners(racingCars, resultView);
	}

	private static void racingCarMove(RacingCars racingCars) {
		RandomGenerator randomGenerator = new RandomGenerator();
		racingCars.getRacingCars().forEach( car -> {
			car.move(randomGenerator.getRandomNumber());
		});
	}

	private static void printRacingResult(RacingCars racingCars, ResultView resultView) {
		resultView.showRacingResult(racingCars);
	}

	private static void printRacingWinners(RacingCars racingCars, ResultView resultView) {
		int maxPoint = racingCars.getRacingCars().stream()
				.max(Comparator.comparing(RacingCar::getPoint)).get().getPoint();
		List<String> winnerList = racingCars.getRacingCars().stream()
				.filter(car -> maxPoint == car.getPoint())
				.map(RacingCar::getName)
				.collect(Collectors.toList());
		resultView.printRacingWinner(winnerList);
	}
}
