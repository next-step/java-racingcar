package step3;

import java.util.List;

public class ResultView {

	public static List<Car> printRacingStatus(List<Car> participants) {
		for (Car car : participants) {
			car.printCarStatus();
		}
		System.out.println();
		return participants;
	}

	public static void printWinner(List<String> winners) {
		String winner = winners.stream().reduce((s, s2) -> s + ", " + s2).orElse("");
		System.out.println(winner + "가 최종 우승했습니다.");
	}
}
