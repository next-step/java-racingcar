package racingcar;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGameApplication {

    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int numberOfCars = scanner.nextInt();
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int tryCount = scanner.nextInt();

        RacingGame game = new RacingGame(new Random(), numberOfCars);

        System.out.println("실행 결과");

        while (tryCount != 0) {
            game.progress();
            tryCount -= 1;

            List<Car> cars = game.getCars();
            for (Car c : cars) {
                System.out.println(
                        Stream
                                .generate(() -> "-")
                                .limit(c.getPosition())
                                .collect(Collectors.joining())
                );
            }
            System.out.println("");
        }
    }
}
