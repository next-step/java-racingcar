package nextstep.step3.view;

import nextstep.step3.domain.RacingCars;

import java.util.List;
import java.util.stream.IntStream;

public class ResultView {
	private static final String MOVE_TAB = "-";

	public void showRacingResult(RacingCars racingCars) {
		StringBuilder sb = new StringBuilder();
		racingCars.getRacingCars().forEach(car -> {
							sb.append(car.getName());
							sb.append(" : ");
							sb.append(printRacingPoint(car.getPoint()));
							sb.append("\n");
						}
				);
		System.out.println(sb.toString());
	}

	private String printRacingPoint(int point) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < point ; i++) {
			sb.append(MOVE_TAB);
		}
		return sb.toString();
	}

	public void printRacingWinner(List<String> winners) {
		System.out.println(String.join(",", winners) + "가 최종우승 했습니다.");
	}

}
