package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RaceMain {
	public static void main(String[] args) {
		int carNum = InputView.inputRacingCarNum();
		int forwardCount = InputView.inputTryCount();
		System.out.println();

		List<RacingCar> racingCars = new ArrayList<>();
		for (int i = 0 ; i < carNum ; i++) {
			racingCars.add(new RacingCar());
		}

		System.out.println("실행 결과");
		for (int i = 0 ; i < forwardCount ; i++) {
			for (int j = 0 ; j < carNum ; j++) {
				racingCars.get(j).forward();
			}
			ResultView.outputResult(racingCars);
		}
	}
}
