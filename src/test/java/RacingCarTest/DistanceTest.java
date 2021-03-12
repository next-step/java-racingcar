package RacingCarTest;

import org.junit.jupiter.api.Test;
import racingcar.domain.Distance;

import static org.assertj.core.api.Assertions.*;

public class DistanceTest {
    @Test
    void When_New_Then_InstanceCreated() {
        //when
        Distance distance = new Distance();

        //then
        //no compile error
    }

    @Test
    void Given_InitialDistance_WhenNew_Then_Created() {
        //given
        int initialDistance = 4;

        //when
        Distance distance = new Distance(initialDistance);

        //then
        assertThat(distance).isEqualTo(new Distance(4));
    }

    @Test
    void Given_InvalidDistance_WhenNew_Then_IllegalException() {
        //given
        int invalidDistance = -1;

        //then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new Distance(invalidDistance);
                });
    }

    @Test
    void When_Forward_Then_Moved() {
        //given
        Distance distance = new Distance(3);

        //when
        distance = distance.increase();

        //then
        assertThat(distance).isEqualTo(new Distance(4));
    }
}
