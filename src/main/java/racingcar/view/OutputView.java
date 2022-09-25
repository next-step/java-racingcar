package racingcar.view;

import java.util.ArrayList;
import java.util.List;

public class OutputView {

	private static final String PROGRESS_INDICATOR = "-";
	private static final String RESULT_MESSAGE = "\n실행 결과";

	public void promptCarCount() {
		System.out.println("자동차 대수는 몇 대 인가요?");
	}

	public void promptTrialCount() {
		System.out.println("시도할 회수는 몇 회 인가요?");
	}

	public void printResultMessage() {
		System.out.println(RESULT_MESSAGE);
	}

	public void printResult(List<Integer> positions) {
		List<String> progressStrings = new ArrayList<>();
		for (Integer position : positions) {
			progressStrings.add(getProgressString(position));
		}
		String result = String.join(System.lineSeparator(), progressStrings);
		System.out.println(result);
		System.out.println();
	}

	private String getProgressString(Integer position) {
		return PROGRESS_INDICATOR.repeat(position);
	}
}
