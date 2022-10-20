package racingcar.view;

import java.util.List;

import racingcar.dto.Result;

public interface OutputView {
	void printWinners(List<String> names);

	void printResults(List<Result> results);
}
