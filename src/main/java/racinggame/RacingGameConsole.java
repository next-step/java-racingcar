package racinggame;

import java.util.List;
import racinggame.domain.Car;

public class RacingGameConsole {

	public static void main(String[] args) {
		InputView inputView = new InputView();

		String carNames = inputView.inputString("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		int time = inputView.inputNumber("시도할 회수는 몇 회 인가요?");
		RacingGame racingGame = new RacingGame(carNames, time);

		ResultView resultView = new ResultView();
		resultView.printHeader();
		do {
			List<Car> cars = racingGame.move();
			resultView.print(cars);
		} while(!racingGame.isOver());
		resultView.printRacingResult(racingGame.getRacingGameResult());
	}
}
