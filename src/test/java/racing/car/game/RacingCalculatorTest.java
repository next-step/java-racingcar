package racing.car.game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingCalculatorTest {

    @ParameterizedTest
    @ValueSource(ints = 4)
    void 전진_일리턴(int number) {
        assertThat(RacingCalculator.goAndStop(number)).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = 3)
    void 멈추기_영리턴(int number) {
        assertThat(RacingCalculator.goAndStop(number)).isZero();
    }

    @Test
    void 자동차대수만큼_배열에_랜덤값_넣기() {
        //given
        int carCount = 3; //3대

        int[] carToArray = new int[carCount];
        RacingCalculator.carToArrayRandomValues(carToArray);

        assertThat(carToArray).hasSize(carCount);
        assertThat(carToArray).containsAnyOf(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
    }

    @ParameterizedTest
    @ValueSource(ints = {10, 11, 12})
    void 랜덤값이_0_9사이가_아닐경우(int number) {
        assertThatThrownBy(() -> RacingCalculator.goAndStop(number)).isInstanceOf(IllegalArgumentException.class);
    }

}
