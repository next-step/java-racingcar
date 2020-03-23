package racingcar;

import racingcar.car.Car;

import java.util.ArrayList;
import java.util.List;

public class ResultView {
    private static final String HYPHEN = "-";
    private static final String COMMA = ",";
    private static final String COLON = " : ";

    public void print(List<RacingScore> racingScores) {
        for (RacingScore racingScore : racingScores) {
            printScore(racingScore.getScore());
        }
    }

    private void printScore(List<Car> cars) {
        for (Car car : cars) {
            printPosition(car);
        }
        System.out.println();
    }

    private void printPosition(Car car) {
        StringBuilder stringBuilder = new StringBuilder(car.getName());
        stringBuilder.append(COLON);
        for (int i = 0; i < car.getPosition(); i++) {
            stringBuilder.append(HYPHEN);
        }
        System.out.println(stringBuilder.toString());
    }

    public void printWinner(List<Car> winner) {
        List<String> winnerNames = new ArrayList<>();
        for (Car car : winner) {
            winnerNames.add(car.getName());
        }
        System.out.println(String.join(COMMA, winnerNames) + "가 최종 우승했습니다.");
    }
}
