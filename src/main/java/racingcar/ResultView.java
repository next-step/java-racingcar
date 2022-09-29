package racingcar;

import java.util.List;

public class ResultView {

    public static void printCarPosition(int position) {
        for (int i = 0; i < position; i++) {
            print("-");
        }
        println();
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car: cars) {
            car.print();
        }

        println();
    }

    public static void print(String target) {
        System.out.print(target);
    }

    public static void println() {
        System.out.println();
    }

    public static void println(String target) {
        System.out.println(target);
    }
}
