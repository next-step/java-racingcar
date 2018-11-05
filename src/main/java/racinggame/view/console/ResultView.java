package racinggame.view.console;

import java.util.List;
import java.util.StringJoiner;
import racinggame.domain.RacingGameResult;
import racinggame.dto.CarDto;

public class ResultView {

	public static void printHeader() {
		System.out.println("실행 결과");
	}

	public static void print(RacingGameResult racingGameResult) {
		List<CarDto> cars = racingGameResult.getCars();
		for(CarDto car : cars) {
			System.out.println(car.getStatus());
		}
		System.out.println();
	}

	public static void printRacingResult(RacingGameResult racingGameResult) {
		StringJoiner names = new StringJoiner(", ");
		List<CarDto> winners = racingGameResult.getWinners();
		for(CarDto car : winners) {
			names.add(car.getName());
		}
		System.out.println(String.format("%s가 최종 우승했습니다.",names.toString()));
	}
}
