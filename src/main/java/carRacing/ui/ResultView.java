package carRacing.ui;

import carRacing.domain.Car;

import java.util.List;

public class ResultView {

    private ResultView() {
    }

    public static void printTitle() {
        System.out.println("실행 결과");
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPositionForPrint()));
        }
        System.out.println();
    }

    public static void printWinner(List<String> nameList) {
        System.out.println(String.join(",", nameList) + " 가 최종 우승했습니다.");
    }
}
