package step3.controller;

import step3.domain.Participants;
import step3.domain.RacingGame;
import step3.view.InputView;
import step3.view.ResultView;

import java.io.IOException;

/*
	Q) 4단계 슬라이드에 Controller에서 View와 Domain에 접근해서 처리하는 식의
 	그림이 있어서 그와 비슷하게 Controller를 만들어서 해봤습니다.
 	View와 Domain이 서로 의존하는 경우 없이 controller에서 모두 처리했는데
 	요구 조건에 적합하게 구현한 것인지 잘 모르겠습니다.
 */
public class RacingController {

	public static void main(String[] args) throws IOException {
		RacingGame racingGame = new RacingGame();
		Participants participants = new Participants();

		String[] participantNames = InputView.getParticipantNames();
		int turnCount = InputView.getTurnCount();

		participants.register(participantNames);

		while (turnCount-- > 0) {
			racingGame.doTurn(participants);
			ResultView.printRacingStatus(participants);
		}

		ResultView.printWinner(participants.getWinners());
	}

}
