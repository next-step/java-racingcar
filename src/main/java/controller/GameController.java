package controller;

import domain.Car;
import domain.MovingStragey;
import domain.Winner;
import util.CarNameUtil;
import util.RandomNumUtil;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private List<Car> participants;
    private InputView inputView;
    private Winner winners;

    public GameController() {
        participants = new ArrayList<>();
        inputView = new InputView();
        winners = new Winner();
    }

    public void playRacingGame() throws IllegalArgumentException {
        String[] carNames = CarNameUtil.participantsSplit(inputView.participantInputView());

        for (int count = 0; count < carNames.length; count++) {
            participants.add(new Car(carNames[count]));
        }
        startGame(inputView.playInputView());
        endGameResult();
    }

    public void startGame(int gameCount) {
        for (int count = 0; count < gameCount; count++) {
            racing();
            ResultView.racingView(participants);
        }
    }

    private void racing() {
        for (Car entryCar : participants) {
            entryCar.move(new MovingStragey() {
                @Override
                public int carMove() {
                    return super.carMove();
                }
            });
        }
    }

    public void endGameResult() {
        winners.createWinnersData(participants);
        ResultView.winnersView(winners.readWinners());
    }

}
