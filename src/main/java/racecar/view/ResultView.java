package racecar.view;

import racecar.domain.Car;

import java.util.List;

public class ResultView {

    private ResultView() {
        System.out.println("\n실행 결과");
    }

    public static void printStatus(List<Car> carList) {
        for (Car car : carList)
            System.out.println(car.printStatus());
        System.out.println("");
    }

    public static void printWinner(List<String> winners) {
        System.out.println(String.join(", ", winners) + "가 최종 우승 했습니다.");
    }
}
