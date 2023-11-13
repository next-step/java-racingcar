package racingCar;

import racingCar.game.RacingCarGame;

public class RacingApplication { // 자동차 경주를 시작한다.
	public static void main(String[] args) {
		RacingCarGame racingCarGame = new RacingCarGame();
		racingCarGame.run();
	}
}
