package racinggame;

import java.util.List;
import racinggame.domain.Car;

public class RacingGameConsole {

	public static void main(String[] args) {
		InputView inputView = new InputView();
		int carNumber = inputView.inputNumber("자동차 대수는 몇 대 인가요?");
		int time = inputView.inputNumber("시도할 회수는 몇 회 인가요?");
		RacingGame racingGame = new RacingGame(carNumber, time);
		ResultView resultView = new ResultView();
		do {
			List<Car> cars = racingGame.move();
			resultView.print(cars);
		} while(!racingGame.isOver());
	}
}
