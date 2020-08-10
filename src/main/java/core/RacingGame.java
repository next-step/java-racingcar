package core;

import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    static List<Car> carList;

    RacingGame() {
        InputView.getInputValue();
        carList = new ArrayList<>();
        for(int index = 1; index <= Value.getCarCount() ; index++) {
            carList.add(new Car());
        }
    }

    void startGame() {
        for(int index = 1; index <= Value.getRound() ; index++) {
            startRound();
            ResultView.println();
        }
    }

    static void startRound() {
        for(Car car : carList) {
            int randNum = new Random().nextInt(10);

            car.getRoundResult().add(compareRandNum(randNum));
            ResultView.printOutputValue(car.getRoundResult());
        }
    }

    public static String compareRandNum(int randNum) {
        if(randNum >= 4) {
            return "-";
        }
        return "";
    }

    public static void main(String args[]) {
        RacingGame racingGame = new RacingGame();
        racingGame.startGame();
    }
}


