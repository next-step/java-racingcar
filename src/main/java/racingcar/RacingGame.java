package racingcar;

import java.util.Arrays;
import java.util.Random;
import racingcar.UI.ResultView;

public class RacingGame {
    private static final Random RANDOM = new Random();
    private static final int RANDOM_VALUE = 10;

    public static Car[] createCars(int num) {
        Car[] cars = new Car[num];
        for (int i = 0; i < num; i++) {
            cars[i] = new Car();
        }
        return cars;
    }

    private static int getRandomValue() {
        return RANDOM.nextInt(RANDOM_VALUE);
    }

    private static void playRound(Car[] cars) {
        Arrays.stream(cars).forEach(car -> {
            int randomValue = getRandomValue();
            car.stopOrMove(randomValue);
        });
    }

    public static void playGame(int numberOfCar, int tryCount) {
        Car[] cars = createCars(numberOfCar);

        for (int i = 0; i < tryCount; i++) {
            playRound(cars);
            // TODO : 테스트 코드를 작성하다보니 playGame 메소드 내부에서 UI 메소드를 호출하는게 메소드의 책임이 불분명해지는 것 같은데 어느시점에서 UI결과를 호출해야 할지 혼란스러워요
            ResultView.printRound(cars);
        }
    }
}
