package racing.view;

import racing.domain.Car;
import racing.dto.GameResult;

import java.util.List;

public class ResultView {

    public static void printCarsLocations(List<GameResult> results) {
        for (int i = 0; i < results.size(); i++) { // 1회
            printLocation(results.get(i).getResult());
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    private static void printLocation(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            printOnceCar(list.get(i));
            System.out.print("\n");
        }
    }

    private static void printOnceCar(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("-");
        }
    }
}
