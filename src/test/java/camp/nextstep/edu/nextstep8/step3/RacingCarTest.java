package camp.nextstep.edu.nextstep8.step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {
    @DisplayName("컨디션이 일정조건 (4) 이상일 경우 자동차가 전진하는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"5:true", "2:false", "4:true", "1:false"}, delimiter = ':')
    public void goWhenGreaterThan4Test(int testValue, boolean expected) {
        // given
        RacingCar racingCar = new RacingCar(1);

        // when
        racingCar.goOrStop(testValue);

        // then
        boolean result = racingCar.getPosition().size() > 0;
        assertThat(result).isEqualTo(expected);
    }
}