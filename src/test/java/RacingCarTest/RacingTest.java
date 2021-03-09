package RacingCarTest;

import RacingCar.MovementCondition;
import RacingCar.Racing;
import RacingCar.RacingResult;
import RacingCar.Observer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;


public class RacingTest {
    @ParameterizedTest
    @MethodSource("provideRacingTestSources")
    public void When_Racing_Than_DistanceChanged(MovementCondition movementCondition, int numberOfCars, int numberOfRacing, int[] expected) {
        //given
        Racing racing = new Racing(movementCondition, numberOfCars, numberOfRacing);

        //when
        RacingResult result = racing.racing();

        //then
        for (int i = 0; i < numberOfCars; i++) {
            assertThat(result.getDistance(i)).isEqualTo(expected[i]);
        }
    }

    @Test
    public void Given_SetListener_When_Racing_Then_ListenerCalled() {
        Observer endOfSingleRacing = new Observer<RacingResult>() {
            @Override
            public void observe(RacingResult event) {
                endOfSingleRacingCalled = true;
            }
        };

        //given
        Racing racing = new Racing(new AlwaysMoveCondition(), 1, 1);


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
                Arguments.of(alwaysMoveCondition, 1, 1, new int[]{1}),
                Arguments.of(noMoveCondition, 1, 1, new int[]{0}),
                Arguments.of(alwaysMoveCondition, 1, 2, new int[]{2}),
                Arguments.of(noMoveCondition, 1, 2, new int[]{0}),
                Arguments.of(alwaysMoveCondition, 2, 1, new int[]{1, 1}),
                Arguments.of(alwaysMoveCondition, 2, 2, new int[]{2, 2}),
                Arguments.of(alwaysMoveCondition, 5, 4, new int[]{4, 4, 4, 4, 4}),
                Arguments.of(alwaysMoveCondition, 0, 1, new int[]{0}),
                Arguments.of(alwaysMoveCondition, 0, 0, new int[]{0}),
                Arguments.of(alwaysMoveCondition, 1, 0, new int[]{0})
        );
    }

}