package im.juniq.racingcar.view;

import java.util.List;

import im.juniq.racingcar.domain.CarState;

public class ResultView {
	public void printScore(List<CarState> carStates) {
		carStates.forEach(carState ->
			System.out.println(carState.name() + " : " + positionGraph(carState.position())));
		System.out.println();
	}

	private String positionGraph(int position) {
		String positionGraph = "";
		for (int i = 0; i < position; i++) {
			positionGraph += "-";
		}
		return positionGraph;
	}

	public void printWinner(List<CarState> winners) {
		for (int i = 0; i < winners.size(); i++) {
			addSeparatorIfNotFirst(i);
			System.out.print(winners.get(i).name());
		}
		System.out.println("가 최종 우승했습니다.");
	}

	private void addSeparatorIfNotFirst(int index) {
		if (index != 0) {
			System.out.print(", ");
		}
	}
}
