package game;

import game.view.InputView;
import game.view.ResultView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private List<Car> cars = new ArrayList<>();
    private int round;
    private final static int CHANGE_LOCATION_BOUND = 10;

    public static void start() {
        RacingGame racingGame = new RacingGame();
        racingGame.makeCar(racingGame.inputNumberOfCar());
        racingGame.setRound(racingGame.inputNumberOfRound());
        racingGame.progressGame();
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

    public void changeCarLocation(Car car) {
        if(isForward(pickRandomNumber(CHANGE_LOCATION_BOUND))){
            car.forward();
        }
    }

    public boolean isForward(int number) {
        return number >= 4;
    }

    private int pickRandomNumber(int bound) {
        Random random = new Random();
        return random.nextInt(bound);
    }


    private int inputNumberOfCar() {
        InputView.printInputCarGuide();
        return Input.inputPositiveNumber();
    }

    private int inputNumberOfRound() {
        InputView.printInputRoundGuide();
        return Input.inputPositiveNumber();
    }

    private void makeCar(int inputPositiveNumber) {
        for (int i = 0; i < inputPositiveNumber; i++) {
            cars.add(new Car());
        }
    }

    private void setRound(int number) {
        round = number;
    }

    public List<Car> cars() {
        return cars;
    }

    public int round() {
        return round;
    }
}
