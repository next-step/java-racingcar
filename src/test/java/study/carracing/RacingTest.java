package study.carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import study.carracing.domain.Racing;
import study.carracing.domain.RacingCars;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("입력한 자동차 대수만큼 자동차 객체가 생성된다.")
    void createCar(int expected) {
        Racing racing = new Racing(expected);

        RacingCars racingCars = racing.getRacingCars();
        int actual = racingCars.getCars().size();

        assertThat(actual).isEqualTo(expected);
    }
}
