package ui;

import domain.Car;
import domain.Cars;

import java.util.List;

public class ResultView {
    private static final String START_MESSAGE = "실행 결과";
    private static final String WINNER_MESSAGE = "가 최종 우승했습니다.";

    public static void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public static void printCurrentLocation(Cars cars) {
        for (Car car : cars.getCars()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(car.getName());
            stringBuilder.append(" : ");
            stringBuilder.append(locationToString(car.getLocation()));
            System.out.println(stringBuilder.toString());
        }
        System.out.println();
    }

    private static String locationToString(int location) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < location; i++) {
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

    public static void printWinners(List<String> winners) {
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
