package step3.view;

import step3.domain.Car;
import step3.domain.Participants;

import java.util.List;

public class ResultView {

	public static void printRacingStatus(Participants participants) {
		for (Car car : participants.getParticipants()) {
			System.out.println(getCarStatus(car));
		}
		System.out.println();
	}

	private static String getCarStatus(Car car) {
		StringBuilder sb = new StringBuilder();

		sb.append(car.getName()).append(" : ");
		for (int i = 0, len = car.getPosition(); i < len; i++) {
			sb.append("-");
		}
		return sb.toString();
	}

	public static void printWinner(List<String> winners) {
		String winner = winners.stream()
				.reduce((s, s2) -> s + ", " + s2)
				.orElse("");
		System.out.println(winner + "가 최종 우승했습니다.");
	}
}
