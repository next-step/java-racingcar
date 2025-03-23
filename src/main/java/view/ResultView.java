package view;

import domain.Car;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {

    public static void printRaceRound(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println("\n");
    }

    public static void printExecuteResult() {
        System.out.println("실행 결과");
    }

    public static void printWinner(List<Car> carList) {
        String result = carList.stream().map(Car::getName).collect(Collectors.joining(", "));

        System.out.println(result + "가 최종 우승했습니다.");
    }
}
