package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.study.InputView;
import step3.study.RacingUtil;
import step3.study.Validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarRacingTest {
    @ParameterizedTest
    @ValueSource(strings = {"a", "A", "#", "ㅁ"})
    @DisplayName("숫자형식이 아닌 입력 테스트")
    void wrongNumberCheckTest(String str) {
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> {
            Validator.numberCheck(str);
        }).withMessage("숫자형식이 아닙니다.");
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3,4})
    @DisplayName("자동차 대수 생성 테스트")
    void createCarsTest(int carCount){
        assertThat(RacingUtil.createCars(carCount).size()).isEqualTo(carCount);
    }
}
