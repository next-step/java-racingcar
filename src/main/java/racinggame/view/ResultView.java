package racinggame.view;

import racinggame.car.CarDTO;

import java.util.List;
import java.util.StringJoiner;

/**
 * Created by hspark on 03/11/2018.
 */
public class ResultView {

	public static final String CAR_TRAIL_STRING = "-";

	public static void printGameResult(List<CarDTO> cars) {
		for (CarDTO car : cars) {
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

	public static void printTopRankingList(List<CarDTO> cars) {
		StringJoiner joiner = new StringJoiner(", ");
		for (CarDTO car : cars) {
			joiner.add(car.getName());
		}
		System.out.println(String.format("%s가 최종 우승했습니다.", joiner.toString()));
	}

}
