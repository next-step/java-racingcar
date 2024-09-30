package racingcar;

import java.util.Random;

public class RacingCar {
    public static void main(String[] args) {
        Race race = new Race(new Random());
        race.createCars(InputView.inputCarCount());
        ResultView.printResult(race, InputView.inputLoop());
    }

}
