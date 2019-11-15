package step3.view;

import step3.domain.Car;
import step3.domain.Participants;

import java.util.List;

public class ResultView {

	/*
		Q) 출력 처리도 도메인 객체로 메시지를 보내서 처리하는게 맞나요?
		도메인 객체 내부에 출력용 메서드를 만들고 메시지를 보내서 처리하면
		ResultView의 존재 의미가 있는지 좀 의문이 드네요.
		그리고 ResultView에서 데이터를 받아와서 출력을 하자니 Getter를 사용하게
		되는 문제점이 발생합니다.
	 */
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
