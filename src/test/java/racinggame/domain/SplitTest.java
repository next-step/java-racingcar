package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class SplitTest {

    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux:3", "po123ab;;bi,cr@$%^ong:2", ";;;@#!:1"}, delimiter = ':')
    @DisplayName("성공 - 싐표를 기준으로 자동차 대수를 구분한다.")
    void fail_input_mismatch_number_car_size(String carName, int carSize) {
        // given
        Split split = new Split();

        // when
        List<String> carNames = split.toCarNames(carName);

        // then
        assertThat(carNames).hasSize(carSize);
    }

}
