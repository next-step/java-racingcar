package racinggame.view.console;

import racinggame.domain.RacingGame;
import racinggame.dto.RacingGameInfo;

public class RacingGameConsole {

	public static void main(String[] args) {
		String carNames = InputView.inputString("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
		int time = InputView.inputNumber("시도할 회수는 몇 회 인가요?");
		RacingGameInfo racingGameInfo = new RacingGameInfo(carNames, time);
		RacingGame racingGame = new RacingGame(racingGameInfo);

		ResultView.printHeader();
		do {
			racingGame.move();
			ResultView.print(racingGame.getRacingGameResult());
		} while(!racingGame.isOver());
		ResultView.printRacingResult(racingGame.getRacingGameResult());
	}
}
