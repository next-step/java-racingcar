package step3;

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
}
