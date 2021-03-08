package RacingCarTest;

import RacingCar.Racing;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.*;

public class RacingTest {
    @Test
    void Given_AlwaysMoveCondition_When_Racing_Then_DistanceIncreased() {
        //given
        Racing racing = new Racing(new AlwaysMoveCondition());
        racing.setNumberOfRacing(1);

        //when
        int distance = racing.racing();

        //then
        assertThat(distance).isEqualTo(1);
    }

    @Test
    void Given_NoMoveCondition_When_Racing_Then_DistanceNotIncreased() {
        //given
        Racing racing = new Racing(new NoMoveCondition());
        racing.setNumberOfRacing(1);

        //when
        int distance = racing.racing();

        //then
        assertThat(distance).isEqualTo(0);
    }

    @Test
    void Given_TwoRacingNoMoveCondition_When_Racing_Then_DistanceNotIncreased() {
        //given
        Racing racing = new Racing(new NoMoveCondition());
        racing.setNumberOfRacing(2);

        //when
        int distance = racing.racing();

        //then
        assertThat(distance).isEqualTo(0);
    }

    @Test
    void Given_TwoRacingAndAlwaysMoveCondition_When_Racing_Then_DistanceIncreased() {
        //given
        Racing racing = new Racing(new AlwaysMoveCondition());
        racing.setNumberOfRacing(2);

        //when
        int distance = racing.racing();

        //then
        assertThat(distance).isEqualTo(2);
    }
}
