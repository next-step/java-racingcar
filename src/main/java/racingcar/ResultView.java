package racingcar;

import racingcar.car.Car;

import java.util.List;

public class ResultView {
    private static final String HYPHEN = "-";
    private static final String WHITE_SPACE = " ";
    private static final String COLON = " : ";
    private static final int ONE = 1;

    public void print(List<RacingScore> racingScores) {
        for (RacingScore racingScore : racingScores) {
            printScore(racingScore.getScore());
        }

        printWinner(racingScores.get(lastScore(racingScores)));
    }

    private int lastScore(List<RacingScore> racingScores) {
        return racingScores.size() - ONE;
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

    private void printWinner(RacingScore racingScore) {
        List<Car> winner = racingScore.getWinner();
        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : winner) {
            stringBuilder.append(car.getName());
            stringBuilder.append(WHITE_SPACE);
        }
        System.out.println(stringBuilder.toString() + "가 최종 우승했습니다.");
    }
}
