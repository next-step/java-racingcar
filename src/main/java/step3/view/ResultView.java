package step3.view;

import step3.domain.Car;
import step3.domain.Participants;

import java.util.List;

public class ResultView {

	// Q) 출력 처리도 도메인 객체로 메시지를 보내서 처리하는게 맞나요?
	public static void printRacingStatus(Participants participants) {
		for (Car car : participants.getParticipants()) {
			System.out.println(car.getCarStatus());
		}
		System.out.println();
	}

	public static void printWinner(List<String> winners) {
		String winner = winners.stream().reduce((s, s2) -> s + ", " + s2).orElse("");
		System.out.println(winner + "가 최종 우승했습니다.");
	}
}
