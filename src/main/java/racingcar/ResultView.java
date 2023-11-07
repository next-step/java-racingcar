package racingcar;

import java.util.List;

public class ResultView {
	public void showRoundsResult(List<Round> rounds) {
		for (Round round : rounds) {
			showProgressByCar(round.getCars());
			System.out.println("");
		}
	}

	private void showProgressByCar(List<Car> cars) {
		for (Car car : cars) {
			System.out.println(
				new StringBuilder()
					.append(car.getName())
					.append(" : ")
					.append("-".repeat(car.getLocation()))
			);
		}
	}

	public void showWinners(List<Car> winners) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < winners.size(); i++) {
			sb.append(winners.get(i).getName());
			if (i != winners.size() -1) {
				sb.append(", ");
			}
		}
		sb.append("가 최종 우승했습니다!");
		System.out.println(sb);
	}
}
