package step3_racingcar.view;

import java.util.Map;
import java.util.Random;
import java.util.Set;

public class ResultView {
	private static final Random random = new Random();
	private static ResultView resultView;

	private ResultView() {
	}

	public static ResultView getInstance() {
		if (resultView == null) {
			resultView = new ResultView();
		}
		return resultView;
	}

	public void printResult()
	{

	}



}
