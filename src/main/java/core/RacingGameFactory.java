package core;

import static domain.Car.createCarList;
import static view.ResultView.createResultView;

import domain.Car;
import domain.UserInput;
import java.util.List;

public class RacingGameFactory {

    private final static String RESULT_MESSAGE = "실행 결과";

    public static void makeARace(UserInput userInput) {

        int numbersOfCar = userInput.getCarNumber();
        int attemptCount = userInput.getAttemptCount();

        List<Car> carList = createCarList(numbersOfCar);

        startRace(carList, attemptCount);
    }

    private static void startRace(List<Car> carList, int cycleSize) {
        System.out.println(RESULT_MESSAGE);
        for (int i = 0; i < cycleSize; i++) {
            moveCarEachCycle(carList);
            createResult(carList);
        }
    }

    private static void createResult(List<Car> carList) {
        createResultView(carList);
    }

    private static void moveCarEachCycle(List<Car> carList) {
        carList.forEach(Car::attemptMove);
    }
}
