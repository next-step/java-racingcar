package racingGame.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGameCenter {
	private int countOfTime;
	private List<RacingCar> racingCars;
	private ScoreBoard scoreBoard;
	
	public RacingGameCenter(String carNameString, int countOfTime) {
		this.countOfTime = countOfTime;
		this.racingCars = new ArrayList<RacingCar>();
		
		String[] carNames = carNameString.split(",");
		
		for(int i = 0 ; i < carNames.length ; i++) {
			racingCars.add(new RacingCar(countOfTime, carNames[i]));
		}
		scoreBoard = new ScoreBoard(carNames, countOfTime);
	}

	public ScoreBoard gameStart() {
		for(int i = 0 ; i < countOfTime ; i++) {
			gameNRound(i);
		}
		return scoreBoard;
	}

	private void gameNRound(int round) {
		for(int j = 0 ; j < racingCars.size() ; j++) {
			racingCars.get(j).move(round);
			scoreBoard.registScore(racingCars, round);
		}
	}
}
