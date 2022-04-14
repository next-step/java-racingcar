package racingcar.ui;

import java.util.List;

public class ResultView {

	private ResultView() {}

	public static void print(List<Result> results) {
		System.out.println("\n실행결과");
		results.forEach(Result::print);
	}
}
