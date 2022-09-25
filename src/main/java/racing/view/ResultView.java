package racing.view;

import racing.model.Car;

public class ResultView {
    public static void print(Car car) {
        System.out.println(car.printPosition());
    }

    public static void printResultTitle() {
        System.out.println("실행 결과");
    }

    public static void printStep() {
        System.out.println();
    }
}
