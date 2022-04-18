package racingcar.view;

import java.util.List;

public class Result {
	private final List<String> results;

	public Result(List<String> results) {
		this.results = results;
	}

	public void print() {
		for (String result : results) {
			System.out.println(result);
		}
		System.out.println();
	}
}
