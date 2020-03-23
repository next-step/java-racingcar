package ui;

import domain.Car;

import java.util.List;

public class ResultView {

    private static final String START_MESSAGE = "실행 결과";
    private static final String ATTEMPTS_SEPARATOR = "";

    public void printResult(List<Car> cars, int numberOfAttempts) {
        printStartMessage();
        for (int time = 0; time < numberOfAttempts; time++) {
            printTimeLocation(cars, time);
        }
    }

    private void printStartMessage() {
        printMessage(START_MESSAGE);
    }

    private void printTimeLocation(List<Car> cars, int time) {
        for (Car car : cars) {
            printMessage(makeLocationMessageForTime(car, time));
        }
        printMessage(ATTEMPTS_SEPARATOR);
    }

    private String makeLocationMessageForTime(Car car, int time) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(car.getName());
        stringBuilder.append(" : ");
        int location = car.getLocationRecord().get(time);
        for (int k = 0; k < location; k++) {
            stringBuilder.append("=");
        }

        return stringBuilder.toString();
    }

    private void printMessage(String message) {
        System.out.println(message);
    }
}
