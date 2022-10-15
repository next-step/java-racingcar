package racingcar.view;

import static java.lang.System.*;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.dto.CarDto;
import racingcar.result.Result;

public class OutputView {

	private static final String PROGRESS_INDICATOR = "-";
	private static final String RESULT_MESSAGE = lineSeparator() + "실행 결과";
	private static final String RESULT_SEPARATOR = " : ";

	public void promptTrialCount() {
		System.out.println("시도할 회수는 몇 회 인가요?");
	}

	public void promptNames() {
		System.out.println("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
	}

	public void printWinners(List<String> names) {
		String winners = String.join(", ", names);
		System.out.println(winners + "가 최종 우승했습니다.");
	}

	public void printResults(List<Result> results) {
		System.out.println(RESULT_MESSAGE);

		String resultStrings = results.stream()
			.map(this::getResults)
			.collect(Collectors.joining(lineSeparator()));
		System.out.println(resultStrings);
	}

	private String getResults(Result result) {
		List<CarDto> carDtos = result.getCarDtos();
		return carDtos.stream()
			.map(this::getResult)
			.collect(Collectors.joining());
	}

	private String getResult(CarDto carDto) {
		return carDto.getName() + RESULT_SEPARATOR + getProgress(carDto) + lineSeparator();
	}

	private String getProgress(CarDto carDto) {
		return PROGRESS_INDICATOR.repeat(carDto.getPosition());
	}
}
