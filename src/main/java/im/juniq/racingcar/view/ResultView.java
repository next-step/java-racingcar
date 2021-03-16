package im.juniq.racingcar.view;

import java.util.List;

public class ResultView {
	public void printScore(List<String> carsStatus) {
		carsStatus.forEach(System.out::println);
		System.out.println();
	}

	public void printWinner(List<String> winners) {
		for (int i = 0; i < winners.size(); i++) {
			addSeparatorIfNotFirst(i);
			System.out.print(winners.get(i));
		}
		System.out.println("가 최종 우승했습니다.");
	}

	private void addSeparatorIfNotFirst(int index) {
		if (index != 0) {
			System.out.print(", ");
		}
	}
}
