package racing.view;

import racing.domain.Car;
import racing.domain.Cars;

import java.util.List;
import java.util.stream.IntStream;

public class Printer {
    static public final String DEL_WINNER_CARS = ", ";

    static public void printStartRacing() {
        print("\n실행 결과");
    }

    static public void printResult(Cars cars) {
        for (Car car : cars.toList()) {
            print(car.getName() + " : " + getRoad(car.getPosition()));
        }

        print("");
    }

    static public String getRoad(int position) {
        StringBuilder builder = new StringBuilder();
        IntStream.range(0, position)
                .forEach(i -> builder.append("-"));

        return builder.toString();
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
        winners.stream()
                .forEach(car -> builder.append(car.getName()).append(DEL_WINNER_CARS));

        int length = builder.length() - DEL_WINNER_CARS.length();
        return builder.substring(0, length).toString();
    }
}
