package step3.view;

import step3.domain.Car;

import java.util.List;

public class ResultView {


    public static void printResultView(List<Car> cars) {

        for (Car car : cars) {
            printName(car.getName());
            printBar(car.getPosition());
        }
        System.out.println();
    }

    private static void printName(String name) {
        System.out.print(name + " : ");
    }

    private static void printBar(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("- ");
        }
        System.out.println();
    }

    public static void printWinner(List<String> winners) {
        System.out.println(winners + "가 최종 우승했습니다.");
    }
}
