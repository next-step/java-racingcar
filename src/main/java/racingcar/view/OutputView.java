package racingcar.view;

import static java.lang.System.*;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.CarDTO;
import racingcar.Result;

public class OutputView {

	private static final String PROGRESS_INDICATOR = "-";
	private static final String RESULT_MESSAGE = lineSeparator() + "실행 결과";

	public void promptCarCount() {
		System.out.println("자동차 대수는 몇 대 인가요?");
	}

	public void promptTrialCount() {
		System.out.println("시도할 회수는 몇 회 인가요?");
	}

	public void printResults(List<Result> results) {
		System.out.println(RESULT_MESSAGE);

		String resultString = results.stream()
			.map(Result::getCarDTOs)
			.map(this::getResultString)
			.collect(Collectors.joining(lineSeparator()));
		System.out.print(resultString);
	}

	private String getResultString(List<CarDTO> carDTOs) {
		return carDTOs.stream()
			.map(CarDTO::getPosition)
			.map(this::getProgressString)
			.collect(Collectors.joining());
	}

	private String getProgressString(Integer position) {
		return PROGRESS_INDICATOR.repeat(position) + lineSeparator();
	}
}
