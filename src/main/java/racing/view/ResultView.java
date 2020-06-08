package racing.view;

import racing.domain.car.Car;
import racing.domain.game.RacingGame;
import racing.domain.game.RacingGameResult;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ResultView {
    private static final String DELIMITER = " : ";
    private static final String COMMA = ", ";

    public static void resultMessage() {
        System.out.println("실행 결과");
    }

    public static void printCarName(String carName) {
        System.out.print(carName + DELIMITER);
    }

    public static void printPosition(int carPosition) {
        for (int i = 0; i < carPosition; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void printResult(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            printCarName(cars.get(i).getCarName());
            printPosition(cars.get(i).getPosition());
        }
        System.out.println();
    }

    public static void printWinner(RacingGame racingGame) {
        List<String> winners = new ArrayList<>();
        RacingGameResult racingGameResult = new RacingGameResult(racingGame.getRacingCars(), winners);
        winners = racingGameResult.getWinnerList();

        String winnerNames = winners.stream()
                .collect(Collectors.joining(COMMA));

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
