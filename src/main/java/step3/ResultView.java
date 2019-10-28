package step3;

import java.util.ArrayList;
import java.util.Arrays;
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

    public static void winner(List<Car> cars, int winnerPosition) {
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == winnerPosition) {
                winners.add(car.getName());
            }
        }

        System.out.println(winners);
    }

}
