package RacingCarTest;

import racingcar.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;


public class RacingTest {

    @ParameterizedTest
    @MethodSource("provideRacingTestSources")
    public void When_Racing_Than_DistanceChanged(MovementCondition movementCondition, int numberOfCars, int numberOfRacing, int expected) {
        ArrayList<Car> cars = new ArrayList<Car>();
        for (int i = 0; i < numberOfCars; i++) {
            cars.add(new SimpleCar(""));
        }
        CarCollection carCollection = new CarCollection(cars);

        //given
        Racing racing = new Racing(movementCondition, carCollection, numberOfRacing);

        //when
        racing.racing();

        //then
        cars.forEach(car -> assertThat(car.getDistance())
                .isEqualTo(expected));
    }

    @Test
    public void Given_SetListener_When_Racing_Then_ListenerCalled() {
        //given
        Observer endOfSingleRacing = new Observer<Integer>() {
            @Override
            public void observe(Integer event) {
                endOfSingleRacingCalled = true;
            }
        };

        ArrayList<Car> cars = new ArrayList<Car>();
        cars.add(new SimpleCar(""));
        CarCollection carCollection = new CarCollection(cars);
        Racing racing = new Racing(new AlwaysMoveCondition(), carCollection, 5);

        //when
        racing.addEndOfSingleRacingListener(endOfSingleRacing);
        racing.racing();

        //then
        assertThat(endOfSingleRacingCalled).isEqualTo(true);
    }

    private boolean endOfSingleRacingCalled = false;

    private static Stream<Arguments> provideRacingTestSources() {
        MovementCondition alwaysMoveCondition = new AlwaysMoveCondition();
        MovementCondition noMoveCondition = new NoMoveCondition();
        return Stream.of(
                Arguments.of(alwaysMoveCondition, 1, 1, 1),
                Arguments.of(noMoveCondition, 1, 1, 0),
                Arguments.of(alwaysMoveCondition, 1, 2, 2),
                Arguments.of(noMoveCondition, 1, 2, 0),
                Arguments.of(alwaysMoveCondition, 2, 1, 1),
                Arguments.of(alwaysMoveCondition, 2, 2, 2),
                Arguments.of(alwaysMoveCondition, 5, 4, 4),
                Arguments.of(alwaysMoveCondition, 0, 1, 0),
                Arguments.of(alwaysMoveCondition, 0, 0, 0),
                Arguments.of(alwaysMoveCondition, 1, 0, 0)
        );
    }
}