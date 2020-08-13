package simpleracing.output;

import simpleracing.execute.CarGame;

public class CarRacingOutput {

	private CarGame racingGame;

	public CarRacingOutput(CarGame racingGame) {
		this.racingGame = racingGame;
	}

	public void render() {
		System.out.println("실행 결과");
		System.out.println(racingGame.getRacingResult());
	}
}
