package racingGame.domain;

import java.util.List;

public class ScoreBoard {
	private String[] carNames;
	private String[][] scores;
	private String winnerName;
	
	public ScoreBoard(String[] carNames, int countOfTime) {
		this.carNames = carNames;
		this.scores = new String[carNames.length][countOfTime];
		this.winnerName = "";
	}
	
	public ScoreBoard registScore(List<RacingCar> racingCars) {
		for(int i = 0 ; i < racingCars.size() ; i++) {
			scores[i] = racingCars.get(i).getRoundPositions();
		}
		return this;
	}
	
	public String[][] makeScoreBoard(){
		registWinner();
		for(int i = 0; i < carNames.length; i++) {
			scores[i][0] = (carNames[i] + " : " + scores[i][0]);
		}
		return scores;
	}
	
	public String registWinner() {
		for(int i = 0; i < carNames.length; i++) {
			winnerName = makingWinnerList(i);
		}
		return winnerName;
	}

	private String makingWinnerList(int targetPosition) {
		int winnerPosition = getWinnerCount();
		if(winnerPosition == getCarPositionCount(targetPosition)) {
			winnerName = addComma(winnerName);
			winnerName += carNames[targetPosition];
		}
		return winnerName;
	}

	private String addComma(String winnerName) {
		if(!"".equals(winnerName)) {
			winnerName += ",";
		}
		return winnerName;
	}

	private int getWinnerCount() {
		int winnerPosition = 0;
		
		for(int i = 0; i < carNames.length; i++) {
			int curPosition = getCarPositionCount(i);
			winnerPosition = compareWinnerPosition(winnerPosition, curPosition);
		}
		
		return winnerPosition;
	}

	private int compareWinnerPosition(int winnerPosition, int curPosition) {
		if(winnerPosition < curPosition) {
			winnerPosition = curPosition;
		}
		return winnerPosition;
	}

	public String getWinner() {
		return winnerName;
	}

	public int getCarPositionCount(int idx) {
		String targetPositionString = "";
		for(int i = 0; i < scores[idx].length; i++) {
			targetPositionString += scores[idx][i]; 
		}
		return targetPositionString.length();
	}
}
