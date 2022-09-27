package game.domain;

import game.io.input.Input;
import game.io.output.InputView;
import game.io.output.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private List<Car> cars = new ArrayList<>();
    private RacingGameRule racingGameRule;
    private int round;
    private final static int CHANGE_LOCATION_BOUND = 10;

    public static void start(RacingGameRule racingGameRule) {
        RacingGame racingGame = new RacingGame(racingGameRule);
        racingGame.makeCar(racingGame.inputNumberOfCar());
        racingGame.setRound(racingGame.inputNumberOfRound());
        racingGame.progressGame();
    }

    public RacingGame(RacingGameRule racingGameRule) {
        this.racingGameRule = racingGameRule;
    }

    private void progressGame() {
        ResultView.startGame();
        for (int i = 0; i < round(); i++) {
            progressRound(cars());
            ResultView.printCarsStatus(cars());
            ResultView.finishRound();
        }
    }

    private void progressRound(List<Car> cars) {
        for (Car car : cars) {
            changeCarLocation(car);
        }
    }

    private void changeCarLocation(Car car) {
        if (racingGameRule.isForward(pickRandomNumber(CHANGE_LOCATION_BOUND))) {
            car.forward();
        }
    }


    private int pickRandomNumber(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }


    public int inputNumberOfCar() {
        InputView.printInputCarGuide();
        return Input.inputPositiveNumber();
    }

    public int inputNumberOfRound() {
        InputView.printInputRoundGuide();
        return Input.inputPositiveNumber();
    }

    public void makeCar(int inputPositiveNumber) {
        for (int i = 0; i < inputPositiveNumber; i++) {
            cars.add(new Car());
        }
    }

    public void setRound(int number) {
        round = number;
    }

    public List<Car> cars() {
        return cars;
    }

    public int round() {
        return round;
    }

}
