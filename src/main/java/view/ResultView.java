package view;

import domain.CarInfo;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    public static void printCars(List<CarInfo> car) {
        for (CarInfo element : car) {
            System.out.println(element.getCarName() + " : " + element.getCarStatus());
        }
        System.out.println("\n");
    }

    public static void printWinners(List<CarInfo> winners) {
        ArrayList<String> winnerNames = new ArrayList<>();

        for (CarInfo element : winners) {
            winnerNames.add(element.getCarName());
        }

        System.out.println(String.join(",", winnerNames) + "가 최종 우승했습니다.");
    }
}
