package camp.nextstep.racingcar.view;

import static java.lang.System.out;

import camp.nextstep.racingcar.domain.Car;
import camp.nextstep.racingcar.domain.Position;
import java.util.ArrayList;
import java.util.List;

public class ResultView {

    public static final String DISTANCE_MARK = "-";
    public static final String WINNER_DELIMITER = ", ";

    public static void print(List<Car> cars) {
        for (Car car : cars) {
            printCar(car);
        }
        out.println();
    }

    public static void printWinner(List<Car> cars) {
        out.println("최종 우승자: " + String.join(WINNER_DELIMITER, toWinnerNames(cars)));
    }

    private static void printCar(Car car) {
        out.println(car.getName() + " : " + toGraphicDistance(car.getPosition()));
    }

    private static String toGraphicDistance(Position position) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < position.getPosition(); i++) {
            sb.append(DISTANCE_MARK);
        }
        return sb.toString();
    }

    private static List<String> toWinnerNames(List<Car> cars) {
        List<String> winnerNames = new ArrayList<>(cars.size());
        for (Car car : cars) {
            winnerNames.add(car.getName());
        }
        return winnerNames;
    }
}
