package racinggame.view.console;

import java.util.List;
import racinggame.domain.Car;
import racinggame.domain.RacingGame;

public class RacingGameConsole {

	public static void main(String[] args) {
		String carNames = InputView.inputString("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		int time = InputView.inputNumber("시도할 회수는 몇 회 인가요?");
		RacingGame racingGame = new RacingGame(carNames, time);

		ResultView.printHeader();
		do {
			List<Car> cars = racingGame.move();
			ResultView.print(cars);
		} while(!racingGame.isOver());
		ResultView.printRacingResult(racingGame.getRacingGameResult());
	}
}
