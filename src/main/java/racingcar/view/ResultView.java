package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.RacingCar;
import racingcar.model.RacingCars;

public class ResultView {
	private static final String EXECUTE_RESULT = "실행 결과";
	private static final String OUTPUT_WINNER_STATEMENT = "가 최종 우승했습니다.";
	private static final int WINNER_STRING_START_INDEX = 1;

	public void outputResult(List<RacingCar> racingCars) {
		String result = racingCars.stream().map(racingCar ->
			racingCar.getCarName() + " : " + racingCar.getRacingCarDashString()
		).collect(Collectors.joining("\n"));
		System.out.println(result + "\n");
	}

	public void outputWinners(RacingCars racingCars) {
		String winnersString =  racingCars.getWinners().toString();
		System.out.println(winnersString.substring(WINNER_STRING_START_INDEX, winnersString.length() - 1) + OUTPUT_WINNER_STATEMENT);
	}

	public void outputStatement() {
		System.out.println("\n" + EXECUTE_RESULT);
	}
}
