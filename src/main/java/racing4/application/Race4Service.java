package racing4.application;

import racing4.domain.Race4Car;
import racing4.view.ResultView;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Race4Service {
    public static void playAndDisplay(List<Race4Car> race4Cars, int tryCount) {
        System.out.println();
        System.out.println("실행 결과");
        playGamesByRound(race4Cars, tryCount);
        ResultView.printWinner(getWinnerNames(race4Cars));
    }

    private static void playGamesByRound(List<Race4Car> race4Cars, int tryCount) {
        IntStream.range(0, tryCount)
                 .forEach(i -> playGame(race4Cars));
    }

    private static void playGame(List<Race4Car> race4Cars) {
        int randomNumber = new Random().nextInt(10);
        race4Cars.forEach(car -> car.moveForwardByCondition(randomNumber));
        ResultView.displayGameResult(race4Cars);
    }

    public static List<String> getWinnerNames(List<Race4Car> race4Cars) {
        return race4Cars.stream()
                        .filter(race4Car -> race4Car.isMaxPosition(getMaxPosition(race4Cars)))
                        .map(Race4Car::getName)
                        .collect(Collectors.toList());
    }

    private static int getMaxPosition(List<Race4Car> race4Cars) {
        return race4Cars.stream()
                        .mapToInt(Race4Car::getPosition)
                        .max()
                        .orElse(0);
    }
}
