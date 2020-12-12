package carrace.view;

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
            System.out.println(getCarResult(car));
        }
    }

    private static String getCarResult(Car car) {
        int position = car.getPosition();
        String name = car.getName();

        StringBuilder result = new StringBuilder();
        result.append(name).append(" : ");
        for (int i = 0; i < position; i++) {
            result.append("-");
        }
        return result.toString();
    }

    public static void printWinner(RaceTrack raceTrack) {
        List<Car> winners = raceTrack.getWinner();

        StringBuilder winnerResult = new StringBuilder();
        StringJoiner carNameJoiner = new StringJoiner(", ");
        for (Car winner : winners) {
            String name = winner.getName();
            carNameJoiner.add(name);
        }
        winnerResult.append(carNameJoiner);
        winnerResult.append("가 최종 우승했습니다.");

        System.out.println(winnerResult);
    }

}