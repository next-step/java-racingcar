package step3.controller;

import step3.domain.Participants;
import step3.domain.RacingGame;
import step3.domain.Winners;
import step3.view.InputView;
import step3.view.ResultView;

import java.io.IOException;

public class RacingController {

	public static void main(String[] args) throws IOException {
		Participants participants = new Participants(InputView.getParticipantNames());
		int turnCount = InputView.getTurnCount();

		while (turnCount-- > 0) {
			RacingGame.doTurn(participants);
			ResultView.printRacingStatus(participants);
		}

		Winners winners = new Winners();
		winners.findWinners(participants.getParticipants());
//		ResultView.printWinner(participants.getWinners());
		ResultView.printWinner(winners.getWinners());
	}

}
