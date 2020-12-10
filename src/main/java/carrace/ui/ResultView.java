package carrace.ui;

import carrace.domain.Car;
import carrace.domain.RaceTrack;

import java.util.List;
import java.util.StringJoiner;

public class ResultView {
    public static void printResultTitle() {
        System.out.println("실행 결과");
    }

    public static void printResult(RaceTrack raceTrack) {
        List<Car> carList = raceTrack.getCarList();
        printCarListPosition(carList);
        System.out.println();
    }

    private static void printCarListPosition(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getRacingResult());
        }
    }

    public static void printWinner(RaceTrack raceTrack) {
        List<Car> winners = raceTrack.getWinner();

        StringBuilder result = new StringBuilder();
        StringJoiner carNameJoiner = new StringJoiner(", ");
        for (Car winner : winners) {
            String name = winner.getName();
            carNameJoiner.add(name);
        }
        result.append(carNameJoiner);
        result.append("가 최종 우승했습니다.");

        System.out.println(result);
    }

}
