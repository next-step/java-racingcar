package racingcar.view;

import java.util.ArrayList;
import racingcar.model.Car;
import racingcar.util.Message;

public class OutputView {

    public static void printResult(Car car) {
        System.out.print(car.getCarName() + ": ");
        printPosition(car.getPosition());
        System.out.println();
    }

    private static void printPosition(int position) {
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printWinner(ArrayList<String> winnerList) {
        System.out.print(Message.WINNER_MESSAGE);
        System.out.print(String.join(",", winnerList));
    }
}
