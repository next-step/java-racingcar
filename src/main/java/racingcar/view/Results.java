package racingcar.view;

import java.util.ArrayList;
import java.util.List;

public class Results {
	private final List<Result> results;

	public Results() {
		this.results = new ArrayList<>();
	}

	public void add(Result result) {
		results.add(result);
	}

	public void print() {
		for (Result result : results) {
			result.print();
		}
	}

	public int size() {
		return results.size();
	}
}
