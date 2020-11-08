package step4;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RacingCarGame {
    private static final Random random = new Random();
    private static final int BOUND = 9;

    public static void getRacers(int move, String[] racers) {
        List<Car> cars = Arrays.stream(racers)
                .map(Car::new)
                .collect(Collectors.toList());
        carMove(move, cars);
    }

    public static void carMove(int move, List<Car> cars) {
        IntStream.range(0, move)
                .mapToObj(i -> cars)
                .forEach(RacingCarGame::carMove);
    }

    public static void carMove(List<Car> cars) {
        for (Car car : cars) {
            car.move(getRandom());
        }
        RacingCarUi.resultPrint(cars);
    }

    public static int getRandom() {
        return random.nextInt(BOUND);
    }

    public static void validate(String racer) {
        if (racer == null) {
            throw new IllegalArgumentException("입력값을 넣어주세요.");
        }
    }
}
