package service;

import domain.RacingCar;
import util.RandomNumberGenerator;
import view.InputView;
import view.OutputView;


import java.util.List;

public class RacingCarService {
    private static final int STANDARD_MOVE_COUNT = 4;

    public static void main(String[] args) {
        int createCarCount = InputView.inputCarCount();
        int number = InputView.inputTryNumber();

        List<RacingCar> cars = RacingCar.createCarsByCount(createCarCount);
        printExecutionResult(cars, number);
    }

    private static void printExecutionResult(List<RacingCar> cars, int number) {
        System.out.println("실행 결과");
        for (int i = 0; i < number; i++) {
            for (RacingCar car : cars) {
                int moveCount = RandomNumberGenerator.generateRandomNumber();
                if (isMoveAvailable(moveCount)) {
                    car.moveForward();
                }
            }
            OutputView.printCarsPositionStatus(cars);
        }
    }

    private static boolean isMoveAvailable(int moveCount) {
        return moveCount >= STANDARD_MOVE_COUNT;
    }
}
