package racingcar.view;

import static java.lang.System.*;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import racingcar.result.Result;

public class OutputView {

	private static final String PROGRESS_INDICATOR = "-";
	private static final String RESULT_MESSAGE = lineSeparator() + "실행 결과";
	private static final String RESULT_SEPARATOR = " : ";

	public void promptCarCount() {
		System.out.println("자동차 대수는 몇 대 인가요?");
	}

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
		System.out.print(resultStrings);
	}

	private String getResults(Result result) {
		Iterator<String> nameIterator = result.getNames().iterator();
		Iterator<Integer> positionIterator = result.getPositions().iterator();
		String resultString = "";
		while (nameIterator.hasNext() && positionIterator.hasNext()) {
			String name = nameIterator.next();
			Integer position = positionIterator.next();
			resultString += getResult(name, position);
		}
		return resultString;
	}

	private String getResult(String name, Integer position) {
		return name + RESULT_SEPARATOR + getProgress(position);
	}

	private String getProgress(Integer position) {
		return PROGRESS_INDICATOR.repeat(position) + lineSeparator();
	}
}
