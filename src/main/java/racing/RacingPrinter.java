package racing;

import java.util.List;
import java.util.stream.Collectors;

import racing.domain.Car;
import racing.domain.RoundResult;

public class RacingPrinter {

    public static final String POSITION_SYMBOL = "-";
    public static final int DEFAULT_POSITION = 1;
    public static final String SEPARATOR = ", ";
    public static final String DELIMITER = " : ";



    public static void drawEachRoundResult(List<RoundResult> roundResults) {
        for (RoundResult roundResult : roundResults) {
            drawRound(roundResult.getRoundResult());
            System.out.println();
        }
    }

    private static void drawRound(List<Car> roundResult) {
        for (Car car : roundResult) {
            drawPosition(car);
        }
    }

    private static void drawPosition(Car car) {
        String symbol = POSITION_SYMBOL.repeat(car.getPosition() + DEFAULT_POSITION);
        System.out.println(car.getName() + DELIMITER + symbol);
    }

    public static void announceWinner(List<Car> winners) {
        List<String> winnerNames = winners.stream().map(Car::getName).collect(Collectors.toList());
        System.out.println(winnerNames.toString() + "가 최종 우승했습니다.");
    }

    public static void drawInitRound(List<String> carNames) {
        drawRound(carNames
                .stream()
                .map(Car::new)
                .collect(Collectors.toList())
        );
        System.out.println();
    }
}
