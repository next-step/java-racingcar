package view;

import domain.Car;
import domain.Racing;
import domain.Winners;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printRaceRound(Racing racing) {
        for (Car car : racing.getCarList()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println("\n");
    }

    public static void printExecuteResult() {
        System.out.println("실행 결과");
    }

    public static void printWinner(Racing racing) {
        List<Car> winners = Winners.findWinners(racing.getCarList());

        String winnerNames = winners.stream()
            .map(Car::getName)
            .collect(Collectors.joining(", "));

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
