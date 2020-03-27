package ui;

import domain.Car;

import java.util.List;

public class ResultView {

    private static final String START_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printCurrentLocation(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.toString());
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String winner : winners) {
            stringBuilder.append(winner);
            stringBuilder.append(", ");
        }
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(" "));
        stringBuilder.deleteCharAt(stringBuilder.lastIndexOf(","));
        stringBuilder.append(WINNER_MESSAGE);
        System.out.println(stringBuilder.toString());
    }
}
