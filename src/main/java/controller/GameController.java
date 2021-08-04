package controller;

import domain.Participants;
import domain.Winner;
import util.StringUtil;
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

    public void init() throws IllegalArgumentException {
        String[] carNames = StringUtil.participantsSplit(inputView.participantInputView());

        for (int count = 0; count < carNames.length; count++) {
            participant.addParticipants(carNames[count]);
        }
        int gameCount = inputView.playInputView();
        for (int count = 0; count < gameCount; count++) {
            participant.playGame();
            ResultView.racingView(participant.readParticipants());
        }
        winners.createWinnersData(participant.readParticipants(), participant.readWinnerCarDistance());
        ResultView.winnersView(winners.readWinners());
    }


}
