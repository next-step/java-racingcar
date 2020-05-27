package racing.view;

import racing.Car;
import racing.RacingGame;

import java.util.List;

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

    public static void printResult(List<Car> carPositions) {
        for (int i = 0; i < carPositions.size(); i++) {
            printCarName(carPositions.get(i).getCarName());
            printPosition(carPositions.get(i).getPosition());
        }
        System.out.println();
    }

    public static void printWinner(RacingGame racingGame) {
        List<String> winners = racingGame.getWinnersCarName();

        StringBuilder stringBuilder = new StringBuilder();

        winners.stream().forEach(value -> stringBuilder.append(value).append(COMMA));

        stringBuilder.delete(stringBuilder.length() - 2, stringBuilder.length());
        stringBuilder.append("가 최종 우승했습니다.");

        System.out.println(stringBuilder);
    }
}
