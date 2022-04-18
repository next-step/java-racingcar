package racingcar.view;

import java.util.List;

public class ResultView {

	private ResultView() {}

	public static void print(Results results) {
		System.out.println("\n실행결과");
		results.print();
	}
}
