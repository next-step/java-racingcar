package step3.view;

import step3.domain.Car;
import step3.domain.RaceHistory;

import java.util.List;
import java.util.stream.Collectors;

public class RaceResultView {

    public static void display(RaceHistory history){
        printRaceHistory(history);
        printWinners(history.getWinner());
    }

    private static void printRaceHistory(RaceHistory history){
        System.out.println("실행 결과");
        history.getRaceHistory()
                .forEach(cars-> displayRaceSituation(cars.getAll()));
    }

    private static void printWinners(List<Car> winners) {
        System.out.println(joinCarNames(winners) + "가 최종 우승했습니다.");
    }

    private static void displayRaceSituation(List<Car> cars) {
        for (Car car : cars) {
            printCarPosition(car);
        }
        System.out.println("");
    }

    private static void printCarPosition(Car car) {
        System.out.println(car.getNameValue() + " : " + "-".repeat(car.getPositionValue()));
    }

    private static String joinCarNames(List<Car> cars) {
        return cars.stream()
                .map(Car::getNameValue)
                .collect(Collectors.joining(", "));
    }
}
