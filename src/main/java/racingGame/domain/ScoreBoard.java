package racingGame.domain;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
	List<Integer> score;

	public ScoreBoard(int inputCountOfCars, int inputCountOfTime) {
		score = new ArrayList<Integer>();
	}
}
