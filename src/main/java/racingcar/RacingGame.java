package racingcar;

import java.util.Arrays;
import java.util.stream.Collectors;

public class RacingGame {
    public final Cars cars;
    public int count;

    public RacingGame(Cars cars, String count) {
        validateCount(count);
        this.cars = cars;
        this.count = Integer.parseInt(count.trim());
    }

    public void run() {
        while (count-- > 0) {
            cars.move();
            printResult();
        }

        printResult();
        printWinner();
    }

    public void printResult() {
        String result = Arrays.stream(cars.getResult())
                .collect(Collectors.joining("\n"));
        System.out.println(result + "\n");
    }

    public void printWinner() {
        String result = Arrays.stream(cars.getWinners())
                .collect(Collectors.joining(", "));

        System.out.println(result + "가 최종 우승했습니다.");
    }



    private void validateCount(String count) {
        if (!count.trim().matches("^[0-9]+$")) {
            throw new RuntimeException("실행 횟수는 양수만 가능합니다");
        }
    }
}
