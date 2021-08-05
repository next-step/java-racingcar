package controller;

import domain.Participants;
import domain.Winner;
import util.CarNameUtil;
import view.InputView;
import view.ResultView;

public class GameController {

    private Participants participant;
    private InputView inputView;
    private Winner winners;

    public GameController() {
        participant = new Participants();
        inputView = new InputView();
        winners = new Winner();
    }

    public void playRacingGame() throws IllegalArgumentException {
        String[] carNames = CarNameUtil.participantsSplit(inputView.participantInputView());

        for (int count = 0; count < carNames.length; count++) {
            participant.addParticipants(carNames[count]);
        }
        startGame(inputView.playInputView());
        endGameResult();
    }

    public void startGame(int gameCount) {
        for (int count = 0; count < gameCount; count++) {
            participant.playGame();
            ResultView.racingView(participant.readParticipants());
        }
    }

    public void endGameResult() {
        winners.createWinnersData(participant.readParticipants(),
                participant.readWinnerCarDistance());

        ResultView.winnersView(winners.readWinners());
    }


}
