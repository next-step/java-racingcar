package racingcar.view;

import java.util.List;

public class RoundResult {
	private final List<String> results;

	public RoundResult(List<String> results) {
		this.results = results;
	}

	public void print() {
		for (String result : results) {
			System.out.println(result);
		}
		System.out.println();
	}
}
