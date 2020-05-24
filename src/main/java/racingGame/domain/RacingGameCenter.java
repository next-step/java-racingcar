package racingGame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGameCenter {
	private int countOfTime;
	private List<RacingCar> racingCars;
	private ScoreBoard scoreBoard;
	
	public RacingGameCenter(int countOfCar, int countOfTime) {
		this.countOfTime = countOfTime;
		racingCars = new ArrayList<RacingCar>();
		
		for(int i = 0 ; i < countOfCar ; i++) {
			racingCars.add(new RacingCar(countOfTime));
		}
		scoreBoard = new ScoreBoard(countOfCar, countOfTime);
	}

	public String[][] gameStart() {
		for(int i = 0 ; i < countOfTime ; i++) {
			gameNRound(i);
		}
		return scoreBoard.registScore(racingCars);
	}

	private void gameNRound(int round) {
		for(int j = 0 ; j < racingCars.size() ; j++) {
			racingCars.get(j).move(round);
		}
	}
}
