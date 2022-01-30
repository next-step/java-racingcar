package racinggame.view;

import java.util.List;
import racinggame.domain.Car;
import racinggame.domain.Winner;

public class ResultView {
    private static final String DELIMITER = ", ";
    private static final String FORWARD_SIGN = "-";


    public static void printRace(List<Car> cars) {
        for (Car car : cars) {
            printCar(car);
        }
        System.out.println();
    }

    public static void printCar(Car car) {
        StringBuilder result = new StringBuilder();
        result.append(car.getName()).append(" : ");
        int location = car.getLocation();
        while (location > 0) {
            result.append(FORWARD_SIGN);
            location--;
        }
        System.out.println(result);
    }

    public static void printWinners(List<Car> cars) {
        List<String> winnerUsers = Winner.findWinner(cars);
        String winners = String.join(DELIMITER, winnerUsers);
        System.out.println("최종 우승자: " + winners);
    }
}
