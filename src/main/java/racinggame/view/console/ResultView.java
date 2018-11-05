package racinggame.view.console;

import racinggame.domain.RacingGameResult;
import racinggame.domain.car.CarDTO;

import java.util.StringJoiner;

/**
 * Created by hspark on 03/11/2018.
 */
public class ResultView {

	public static final String CAR_TRAIL_STRING = "-";

	public static void printGameResult(RacingGameResult racingGameResult) {
		for (CarDTO car : racingGameResult.getCarDTOList()) {
			printCar(car);
		}
		System.out.println();
	}

	private static void printCar(CarDTO car) {
		System.out.print(String.format("%s : ", car.getName()));
		for (int i = 0; i < car.getPosition(); i++) {
			System.out.print(CAR_TRAIL_STRING);
		}
		System.out.println();
	}

	public static void printTopRankingList(RacingGameResult racingGameResult) {
		StringJoiner joiner = new StringJoiner(", ");
		for (CarDTO car : racingGameResult.getTopRankingCarDTOList()) {
			joiner.add(car.getName());
		}
		System.out.println(String.format("%s가 최종 우승했습니다.", joiner.toString()));
	}

}
