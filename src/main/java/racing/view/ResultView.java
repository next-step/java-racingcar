package racing.view;

import racing.Car;
import java.util.List;

public class ResultView {
    public static void resultMessage() {
        System.out.println("실행 결과");
    }

    public static void printPosition(int carPosition) {
        for (int i = 0; i < carPosition; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void resultGame(List<Car> carPositions) {
        for (int i = 0; i < carPositions.size(); i++) {
            printPosition(carPositions.get(i).getPosition());
        }
        System.out.println();
    }
}
