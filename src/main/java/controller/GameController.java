package controller;

import domain.Car;
import util.RandomNumUtil;
import util.StringUtil;
import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    List<Car> participant;
    private int gameCount;

    public GameController() {
        participant = new ArrayList<>();
    }

    public void init() throws IllegalArgumentException {
        InputView inputView = new InputView();
        String[] carNames = StringUtil.participants(inputView.participantInputView());

        for (int count = 0; count < carNames.length; count++) {
            participant.add(new Car(carNames[count]));
        }

        gameCount = inputView.playInputView();

        for (int count = 0; count < gameCount; count++) {
            playGame();
            ResultView.racingView(participant);
        }
    }

    public void playGame() {
        for(int count = 0; count < participant.size(); count++) {
            participant.get(count).carMoveBehavior(RandomNumUtil.makeRandomNumber());
        }
    }

}
