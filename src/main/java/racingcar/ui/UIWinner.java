package racingcar.ui;

import java.util.List;
import java.util.stream.Collectors;

import racingcar.model.Car;

public class UIWinner {
	public static void printResult(List<Car> winners) {
		List<String> names = winners.stream().map(Car::name).collect(Collectors.toList());
		System.out.println(String.join(",", names) + " 가 최종 우승했습니다.");
	}
}
