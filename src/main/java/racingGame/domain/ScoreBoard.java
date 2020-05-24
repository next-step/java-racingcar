package racingGame.domain;

import java.util.List;

public class ScoreBoard {
	String[][] scores;

	public ScoreBoard(int countOfCar, int countOfTime) {
		scores = new String[countOfCar][countOfTime];
	}
	
	public ScoreBoard registScore(List<RacingCar> racingCars) {
		for(int i = 0 ; i < racingCars.size() ; i++) {
			scores[i] = racingCars.get(i).getRoundPositions();
		}
		return this;
	}
	
	public String[][] makeScoreBoard(){
		return scores;
	}
	
}
