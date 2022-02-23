package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.util.Message;

public class OutputView {

    public static void printResult(List<Car> cars) {
        for (Car car:cars){
            System.out.print(car.getCarName() + ": ");
            printPosition(car.getPosition());
            System.out.println();
        }
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

    public static void printWinner(List<Car> winners) {
        System.out.print(Message.WINNER_MESSAGE);
        List<String> carNames = winners.stream()
            .map(Car::getCarName)
            .collect(Collectors.toList());
        System.out.print(String.join(",", carNames));
    }
}
