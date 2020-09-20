package racing.view;

import racing.domain.Car;
import racing.message.ViewMessage;

import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    public static void resultViewMessage() {
        System.out.println(ViewMessage.START_RESULT_VIEW.getMessage());
    }

    private static String printMovedLine(int location) {
        String result = "";
        for(int i = 0; i < location; i++) {
            result += "-";
        }
        return result;
    }

    public static void printCars(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + printMovedLine(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinner(List<Car> winner) {
        String winnerNames = winner.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(winnerNames + ViewMessage.WINNER_NOTICE.getMessage());
    }
}
