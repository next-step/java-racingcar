package controller;

import domain.Car;
import util.RandomNumUtil;
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

    public void init() {
        InputView inputView = new InputView();
        int playerCount = inputView.carInputView();
        gameCount = inputView.playInputView();

        for (int count = 0; count < playerCount; count++) {
            participant.add(new Car());
        }

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
