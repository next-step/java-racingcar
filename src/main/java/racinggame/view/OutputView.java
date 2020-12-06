package racinggame.view;

import racinggame.domain.GameResult;
import racinggame.domain.car.CarName;
import racinggame.domain.car.RacingCar;

import java.util.List;
import java.util.stream.IntStream;

public class OutputView {
    private static final String POSITION_TEXT = "-";
    private static final String COMMA_TEXT = ",";
    private static final String COLON_TEXT = " : ";

    public static void print(final List<GameResult> gameResults) {
        gameResults.forEach(gameResult -> {
            printCarsPosition(gameResult.getRacingCars());
            System.out.println();
        });
    }

    public static void printWinners(List<CarName> pickLastWinners) {
        StringBuilder sb = new StringBuilder();
        pickLastWinners.forEach(carName -> sb.append(carName.getName()).append(COMMA_TEXT));
        sb.deleteCharAt(sb.length() - 1);
        sb.append("가 최종 우승했습니다.");
        System.out.println(sb.toString());
    }

    private static void printCarsPosition(List<RacingCar> racingCars) {
        racingCars.forEach(OutputView::printCarPosition);
    }

    private static void printCarPosition(RacingCar racingCar) {
        StringBuilder sb = new StringBuilder();
        sb.append(racingCar.getName().getName()).append(COLON_TEXT);
        IntStream.range(0, racingCar.getPosition()).forEach(p -> sb.append(POSITION_TEXT));
        System.out.println(sb.toString());
    }
}
