package view;

import domain.CarInfo;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    private final static String DELIMITER = ",";

    public static void printCars(List<CarInfo> car, int time) {
        for (int i = 0; i < time; ++i) {
            printEachGameResult(car, i);
            System.out.println("\n");
        }
    }

    private static void printEachGameResult(List<CarInfo> car, int index) {
        for (CarInfo element : car) {
            System.out.println(element.getCarName() + " : " + getRacingGameResult(element, index));
        }
    }

    public static void printWinners(List<CarInfo> winners) {
        ArrayList<String> winnerNames = new ArrayList<>();

        for (CarInfo element : winners) {
            winnerNames.add(element.getCarName());
        }
        System.out.println(String.join(DELIMITER, winnerNames) + "가 최종 우승했습니다.");
    }

    private static String getRacingGameResult(CarInfo car, int index) {
        StringBuilder status = new StringBuilder();
        for (int i = 0; i < car.getCarPosition(index); ++i) {
            status.append("-");
        }
        return status.toString();
    }
}