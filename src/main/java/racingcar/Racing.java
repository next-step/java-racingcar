package racingcar;

import static java.text.MessageFormat.format;
import static racingcar.RandomNumberGenerator.generateRandomNumberBetweenZeroAndNine;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public final class Racing {

    private static final String INVALID_CAR_COUNT_MESSAGE = "자동차의 대수는 자연수만 가능합니다. [carCount : {0}]";
    private static final String INVALID_PLAYING_COUNT_MESSAGE = "레이싱 시도 횟수는 자연수만 가능합니다. [playingCount : {0}]";
    private static final int ZERO = 0;

    private Racing() {
    }

    public static void race(final int carCount, final int playingCount) {
        if (carCount <= ZERO) {
            throw new IllegalArgumentException(format(INVALID_CAR_COUNT_MESSAGE, carCount));
        }

        if (playingCount <= ZERO) {
            throw new IllegalArgumentException(format(INVALID_PLAYING_COUNT_MESSAGE, playingCount));
        }

        final List<Car> cars = IntStream.range(1, carCount + 1)
                .mapToObj(Car::from)
                .collect(Collectors.toList());

        for (int i = 0; i < playingCount; i++) {
            System.out.println("[Round " + (i + 1) + "]");

            for (Car car : cars) {
                final int carMovingCondition = generateRandomNumberBetweenZeroAndNine();
                car.moveForwardOrStopByCondition(carMovingCondition);

                System.out.print("[" + car.number() + "] ");
                for (int j = 0; j < car.position(); j++) {
                    System.out.print("-");
                }
                System.out.println();
            }

            System.out.println();
        }
    }
}
