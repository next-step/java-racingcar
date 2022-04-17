package racingcar.view;

import java.util.List;

public class Result {
	private static final String START_CHARACTER = "|";
	private final List<String> results;

	public Result(List<String> results) {
		this.results = results;
	}

	public void print() {
		for (String result : results) {
			System.out.println(START_CHARACTER + result);
		}
		System.out.println();
	}
}
