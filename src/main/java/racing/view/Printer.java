package racing.view;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.List;

public class Printer {
    static public final String DEL_WINNER_CARS = ", ";

    static public void printStartRacing() {
        print("\n실행 결과");
    }

    static public void printResult(Cars cars) {
        for (Car car : cars.toList()) {
            print(car.getName() + " : " + car.getMovesRoad());
        }

        print("");
    }

    static public void printEndGame(List<Car> winners) {
        String winner = getWinnersString(winners);

        print(winner + "가 최종 우승했습니다.");
    }

    private static void print(String message) {
        System.out.println(message);
    }

    private static String getWinnersString(List<Car> winners) {
        StringBuilder builder = new StringBuilder();

        for (Car car : winners) {
            builder.append(car.getName()).append(DEL_WINNER_CARS);
        }

        int length = builder.length() - DEL_WINNER_CARS.length();
        return builder.substring(0, length).toString();
    }
}
