package racing.view;

import racing.domain.Car;
import racing.domain.RacingGameResult;
import racing.domain.TrackResult;

import java.util.List;
import java.util.stream.IntStream;

public class Printer {
    static public final String DEL_WINNER_CARS = ", ";

    static public void printGameResult(RacingGameResult result) {
        printStartRacing();

        result.getTracks().stream()
                .forEach(track -> Printer.printResult(track));

        printEndGame(result.getWinners());
    }

    static private void printStartRacing() {
        print("\n실행 결과");
    }

    static private void printResult(TrackResult result) {
        result.getCars().stream()
                .forEach(car -> print(car.getName() + " : " + getRoad(car.getPosition())));

        print("");
    }

    static private String getRoad(int position) {
        StringBuilder builder = new StringBuilder();
        IntStream.range(0, position)
                .forEach(i -> builder.append("-"));

        return builder.toString();
    }

    static private void printEndGame(List<Car> winners) {
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
