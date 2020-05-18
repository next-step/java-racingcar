package racingGame.domain;

public class RacingGameCenter {
	private int countOfCar;
	private int countOfTime;
	private String[][] scoreBoard;
	
	public RacingGameCenter(int countOfCar, int countOfTime) {
		this.countOfTime = countOfTime;
		this.countOfCar = countOfCar;
	}

	public String[][] gameStart() {
		scoreBoard = new String[countOfTime][countOfCar];
		for(int i=0;i<countOfTime;i++) {
			gameNRound(i);
		}
		return scoreBoard;
	}

	private void gameNRound(int round) {
		RacingCar racingCar = new RacingCar();
		for(int j=0;j<countOfCar;j++) {
			scoreBoard[round][j] = racingCar.move();
		}
	}
}
