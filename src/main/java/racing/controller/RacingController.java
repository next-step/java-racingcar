package racing.controller;

import racing.model.Car;
import racing.model.RacingCar;
import racing.view.InputView;
import racing.view.ResultView;

import java.util.Arrays;
import java.util.Scanner;

public class RacingController {
    private static final String ILLEGAL_NUMBER_OF_CARS = "유효하지 않은 자동차 대 수입니다.";
    private static final String ILLEGAL_RETRY_COUNT = "유효하지 않은 시도 횟수 입니다.";

    private Scanner scanner = new Scanner(System.in);

    private InputView inputView = new InputView();
    private ResultView resultView = new ResultView();

    private Car[] cars;
    private int retryCount;
    private int numberOfCars;

    public void start() {
        inputNumberOfCars();
        inputRetryCount();
        makeCars();
        run();
        scanner.close();
    }

    private void inputNumberOfCars() {
        inputView.printNumberOfCars();
        numberOfCars = getNumberOfCars();
    }

    private void inputRetryCount() {
        inputView.printRetryCount();
        retryCount = getRetryCount();
    }

    private void run() {
        resultView.printResultMessage();
        for (int retry = 0; retry < retryCount; retry++) {
            Arrays.stream(cars).forEach(Car::move);
            resultView.printCarsLocation(cars);
        }
    }

    private void makeCars() {
        cars = new Car[numberOfCars];
        Arrays.setAll(cars, i -> new RacingCar());
    }

    private int getRetryCount() {
        return inputIntValue(ILLEGAL_RETRY_COUNT);
    }

    private int getNumberOfCars() {
        return inputIntValue(ILLEGAL_NUMBER_OF_CARS);
    }

    private int inputIntValue(String errorMessage) {
        int input = scanner.nextInt();

        if (isNotPositiveInt(input)) {
            throw new IllegalArgumentException(errorMessage);
        }

        return input;
    }

    private Boolean isNotPositiveInt(int input) {
        return 0 > input;
    }

}
