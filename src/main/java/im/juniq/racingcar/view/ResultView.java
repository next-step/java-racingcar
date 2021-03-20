package im.juniq.racingcar.view;

import java.util.List;

import im.juniq.racingcar.domain.Name;
import im.juniq.racingcar.domain.Score;

public class ResultView {
	public void printScore(List<Score> scores) {
		scores.forEach(score -> System.out.println(score.name() + " : " + positionGraph(score)));
		System.out.println();
	}

	private String positionGraph(Score score) {
		String positionGraph = "";
		for (int i = 0; i < score.position(); i++) {
			positionGraph += "-";
		}
		return positionGraph;
	}

	public void printWinner(List<Name> winners) {
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
