import racingcar.RacingCar;
import racingcar.model.ResultView;

import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        System.out.println("자동차 대수는 몇 대 인가요?");
        Scanner scanner = new Scanner(System.in);
        int carCount = Integer.parseInt(scanner.nextLine());
        System.out.println("시도할 횟수는 몇 회 인가요?");
        int tryCount = Integer.parseInt(scanner.nextLine());

        List<RacingCar> racingCars = IntStream.range(0, carCount)
                .map(integer -> 0)
                .mapToObj(RacingCar::positionOf)
                .collect(toList());

        System.out.println("실행 결과");
        for (int i = 0; i < tryCount; i++) {
            racingCars = racingCars.stream()
                    .map(racingCar -> {
                        int randomNumber = ThreadLocalRandom.current().nextInt(0, 10);
                        return RacingCar.positionOf(racingCar.nextPosition(randomNumber));
                    }).collect(toList());

            ResultView.print(racingCars);
        }
    }
}
