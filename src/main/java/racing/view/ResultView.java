package racing.view;

import racing.Car;
import racing.GameResult;

public class ResultView {

    public static void showResult(GameResult gameResult) {
        for (Car car : gameResult.getCars()) {
            int record = car.getPosition();
            showEachRecord(car.getName(), record);
        }
        System.out.println();
    }

    private static void showEachRecord(String carName, int record) {
        System.out.print(carName + " : ");
        for (int j = 0; j < record; j++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void showWinner(GameResult gameResult) {
        System.out.println(gameResult.getWinner());
    }
}
