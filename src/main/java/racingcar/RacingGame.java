package racingcar;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RacingGame {
    public final RacingCar[] cars;
    public final int count;

    public RacingGame(RacingCar[] cars, int count) {
        this.cars = cars;
        this.count = count;
    }

    public RacingCar[] selectWinners() {
        int winnerCount = Arrays.stream(cars)
                .mapToInt(car -> car.moveCount)
                .max()
                .orElse(0);

        return Arrays.stream(cars)
                .filter(car -> car.moveCount == winnerCount)
                .toArray(RacingCar[]::new);
    }

    public void printResult() {
        String result = Arrays.stream(cars)
                .map(RacingCar::statusToString)
                .collect(Collectors.joining("\n"));
        System.out.println(result + "\n");
    }

    public void printWinner() {
        String result = Arrays.stream(selectWinners())
                .map(car -> car.name)
                .collect(Collectors.joining(", "));

        System.out.println(result + "가 최종 우승했습니다.");
    }


}
