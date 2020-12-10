package racingCar;

import racingCar.domain.Cars;
import racingCar.domain.Game;
import racingCar.view.View;

/**
 * @author : byungkyu
 * @date : 2020/12/07
 * @description :
 **/
public class RacingCarApplication {
	public static void main(String[] args) {
		Game game = new Game(View.requireCarNames(), View.inputMatchCount());
		Cars resultCars = game.start();
		View.printResult(resultCars);
	}
}
