package racing.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racing.domain.Car;
import racing.domain.Cars;
import racing.utils.Validation;

public class RacingView {

	public static final String CAR_EMPTY_MESSAGE = "자동차는 최소 1대 이상이어야 한다.";
	public static final String INT_MIS_TYPE_MATCH_MESSAGE = "해당 문자는 숫자만 사용 가능합니다.";

	private static final String FIRST_REQUEST = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
	private static final String SECOND_REQUEST = "시도할 회수는 몇회인가요?";
	private static final String RESULT_MESSAGE = "실행_결과";
	private static final String WINNER_MESSAGE = " 가 최종 우승했습니다.";
	private final Scanner scanner;

	public RacingView() {
		scanner = new Scanner(System.in);
	}

	public String firstRequestView() {
		System.out.println(FIRST_REQUEST);
		String inputValue = scanner.next();
		Validation.validEmptyCheck(inputValue, CAR_EMPTY_MESSAGE);
		return inputValue;
	}

	public int secondRequestView() {
		System.out.println(SECOND_REQUEST);
		String inputValue = scanner.next();
		Validation.validIntTypeMatchCheck(inputValue, INT_MIS_TYPE_MATCH_MESSAGE);
		return toInt(inputValue);
	}

	public void racingStartView() {
		System.out.println(RESULT_MESSAGE);
	}

	public void racingResultView(Cars cars) {
		for (Car car : cars.getInformation()) {
			System.out.println(car.printCarName() + intResultToStringResult(car.printPosition()));
		}
		racingRoundClear();
	}

	public void racingRoundClear() {
		System.out.print("\n");
	}

	public void racingWinnerView(List<Car> winnerPlayer) {
		String winners = getWinnerNames(winnerPlayer);
		System.out.println(winners + WINNER_MESSAGE);
	}

	private String getWinnerNames(List<Car> winnerPlayer) {
		return winnerPlayer.stream().map(Car::printCarName).collect(Collectors.joining(","));
	}

	private String intResultToStringResult(int resultRacing) {
		return IntStream.range(0, resultRacing).mapToObj(i -> "-").collect(Collectors.joining());
	}

	public int toInt(String value) {
		return Integer.parseInt(value);
	}

}
