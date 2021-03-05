package camp.nextstep.edu.racingcar.view;

import java.util.List;

public class OutputView extends View {

	public void showResult() {
		out.println("실행 결과");
	}

	public void showCarSteps(List<String> carSteps) {
		carSteps.forEach(out::println);
		out.println();
	}
}
