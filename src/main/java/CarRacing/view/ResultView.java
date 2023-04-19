package CarRacing.view;

import CarRacing.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    public static void printCurrentDistance(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.name() + " : " + "-".repeat(car.currentPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> Cars){
        List<String> winners = new ArrayList<>();
        for (Car car : Cars) {
            winners.add(car.name());
        }
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }
}
