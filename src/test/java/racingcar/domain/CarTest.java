package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private static final String POBI = "pobi";
    private static final String CRONG = "crong";
    private static final int SMALL_POSITION = 1;
    private static final int BIG_POSITION = 100;

    @Test
    void move_IncreasesPosition_IfConditionIsTrue() {
        // given
        int startPosition = 5;
        int moveCount = 3;
        Car car = new Car(POBI, startPosition);

        // when
        for (int i = 0; i < moveCount; i++) {
            car.move(() -> true);
        }

        // then
        assertThat(car).isEqualTo(new Car(POBI, startPosition + moveCount));
    }

    @Test
    void move_DoesNotIncreasePosition_IfConditionIsFalse() {
        // given
        int startPosition = 5;
        int moveCount = 3;
        Car car = new Car(POBI, startPosition);

        // when
        for (int i = 0; i < moveCount; i++) {
            car.move(() -> false);
        }

        // then
        assertThat(car).isEqualTo(new Car(POBI, startPosition));
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForEquals")
    void equals(Car car, Car anotherCar, boolean expected) {
        assertThat(car.equals(anotherCar)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArgumentsForEquals() {
        return Stream.of(
                Arguments.of(new Car(POBI), new Car(POBI), true),
                Arguments.of(new Car(POBI, BIG_POSITION), new Car(POBI, BIG_POSITION), true),
                Arguments.of(new Car(POBI, BIG_POSITION), new Car(POBI, SMALL_POSITION), false),
                Arguments.of(new Car(POBI, SMALL_POSITION), new Car(CRONG, SMALL_POSITION), false)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArgumentsForCompareTo")
    void compareTo(Car car, Car anotherCar, int expected) {
        assertThat(car.compareTo(anotherCar)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArgumentsForCompareTo() {
        final int SAME = 0;
        final int GREATER = 1;
        final int SMALLER = -1;

        return Stream.of(
                Arguments.of(new Car(POBI), new Car(POBI), SAME),
                Arguments.of(new Car(POBI, BIG_POSITION), new Car(POBI, BIG_POSITION), SAME),
                Arguments.of(new Car(POBI, BIG_POSITION), new Car(POBI, SMALL_POSITION), GREATER),
                Arguments.of(new Car(POBI, SMALL_POSITION), new Car(POBI, BIG_POSITION), SMALLER)
        );
    }
}
