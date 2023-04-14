package CarRacing.view;

import CarRacing.Car;

import java.util.ArrayList;
import java.util.List;

public class ResultView {

    public static void printCurrentDistance(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.currentPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<String> winners){
        System.out.println(String.join(", ", winners) + "가 최종 우승했습니다.");
    }


}
