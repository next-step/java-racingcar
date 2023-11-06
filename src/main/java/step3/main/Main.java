package step3.main;

import step3.input.InputView;
import step3.input.UserInput;
import step3.racingcar.RacingCar;
import step3.random.RandomValueGenerator;
import step3.result.ResultView;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //inputView
        final UserInput userInput = InputView.input();

        List<RacingCar> cars = makeCars(userInput.getCarNumber());

        //게임 실행
        startRacing(cars, userInput.getTryNumber());
    }

    private static void startRacing(final List<RacingCar> cars, final int tryNumber) {
        //resultView
        System.out.println("실행 결과");

        for (int i = 0; i < tryNumber; i++) {
            tryMove(cars);
            ResultView.printTryResult(cars);
        }
    }

    private static List<RacingCar> makeCars(final int carNumber) {
        List<RacingCar> cars = new ArrayList<>();

        for (int i = 0; i < carNumber; i++) {
            cars.add(new RacingCar());
        }

        return cars;
    }

    private static void tryMove(final List<RacingCar> cars) {
        for (RacingCar car : cars) {
            car.moveIfInRange(RandomValueGenerator.generateRandomValueFromZeroToNine());
        }
    }
}
