package controller;

import domain.Car;
import domain.Winner;
import util.RandomNumUtil;
import util.StringUtil;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GameController {

    List<Car> participant;
    private int gameCount;
    private InputView inputView;
    private Winner winners;

    public GameController() {
        participant = new ArrayList<>();
        inputView = new InputView();
        winners = new Winner();
    }

    public void init() throws IllegalArgumentException {
        String[] carNames = StringUtil.participants(inputView.participantInputView());

        for (int count = 0; count < carNames.length; count++) {
            participant.add(new Car(carNames[count]));
        }
        gameCount = inputView.playInputView();
        for (int count = 0; count < gameCount; count++) {
            playGame();
            ResultView.racingView(participant);
        }
        winners.createWinnersData(participant, readWinnerCarDistance());
        ResultView.winnersView(winners.readWinners());
    }

    public void playGame() {
        for(int count = 0; count < participant.size(); count++) {
            participant.get(count).carMoveBehavior(RandomNumUtil.makeRandomNumber());
        }
    }

    public int readWinnerCarDistance() {
        participant.sort(Comparator.comparing(Car::readCarDistance).reversed());
        return participant.get(0).readCarDistance();
    }

}
