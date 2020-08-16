package core;

import view.InputView;
import view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RacingGame {

    List<Car> carList;

    RacingGame(int carCount) {
        carList = new ArrayList<>();
        IntStream.range(0,carCount).forEach(i -> carList.add(new Car(0)));
    }

    void startGame(int round) {
        IntStream.range(0,round).forEach(i -> startRound());
    }

    void startRound() {
        carList.stream().forEach(car -> car.carAction(new Random().nextInt(10)));
        ResultView.printOutputValue(carList);

    }

    public static void main(String args[]) {
        GameSettings gameSettings = InputView.getInputValue();
        RacingGame racingGame = new RacingGame(gameSettings.carCount);
        racingGame.startGame(gameSettings.round);
    }
}


