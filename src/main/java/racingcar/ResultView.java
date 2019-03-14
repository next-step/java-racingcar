package racingcar;

import java.util.List;

public class ResultView {

    public static void viewCars(List<Car> carPositions) {
        for(int j = 0; j < carPositions.size(); j++) {
            System.out.print(carPositions.get(j).getName() + " : ");
            printPosition(carPositions.get(j).getPosition());
        }
        System.out.println();
    }

    private static void printPosition(int position) {
        for(int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
