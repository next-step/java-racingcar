package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.RacingCar;

public class ResultView {
	private static final String EXECUTE_RESULT = "실행 결과";

	public void outputResult(List<RacingCar> racingCars) {
		String result = racingCars.stream().map(racingCar ->
			racingCar.getRacingCarDashString()
		).collect(Collectors.joining("\n"));
		System.out.println(result + "\n");
	}

	public void outputStatement() {
		System.out.println("\n" + EXECUTE_RESULT);
	}
}
