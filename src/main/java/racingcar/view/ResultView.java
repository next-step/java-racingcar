package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.RacingCar;

public class ResultView {
	public void outputResult(List<RacingCar> racingCars) {
		String result = racingCars.stream().map(racingCar ->
			racingCar.getRacingCarDashString()
		).collect(Collectors.joining("\n"));
		System.out.println(result + "\n");
	}
}
