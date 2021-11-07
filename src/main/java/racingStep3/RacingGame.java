package racingStep3;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {

    private static List<RacingCar> cars;

    public static void execute() {
        int carCount = InputView.inputData("자동차 대수는 몇 대 인가요?");
        int tryCount = InputView.inputData("시도할 회수는 몇 회 인가요?");

        RacingGame(carCount);
        for(int i = 0; i < tryCount; i++) {
            playTheGame(cars);
            ResultView.print(cars);

            System.out.println();
        }
    }

    public static void RacingGame(int count) {
        validCarsCount(count);

        cars = Stream.generate(RacingCar::create)
                .limit(count).collect(Collectors.toList());
    }

    private static void validCarsCount(int count) {
        if(count < 1) {
            throw new IllegalArgumentException("적어도 1대 이상의 자동차가 필요합니다!!!!");
        }
    }

    public static void playTheGame(List<RacingCar> cars) {
        for(RacingCar car : cars) {
            car.moveOrNot();;
        }
    }
}
