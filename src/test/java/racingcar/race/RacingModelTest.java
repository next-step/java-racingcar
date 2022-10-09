package racingcar.race;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class RacingModelTest {

    @ParameterizedTest
    @DisplayName("4이상 숫자는 자동차는 움직일 있다.")
    @CsvSource(value = {"4:true", "9:true"}, delimiter = ':')
    void move_5_upper(int move, boolean isMovePossible) {
        Assertions.assertThat(RacingModel.isMovePossible(move)).isEqualTo(isMovePossible);
    }

    @ParameterizedTest
    @DisplayName("4미만 숫자는 자동차는 움직일 없다.")
    @CsvSource(value = {"1:false", "3:false"}, delimiter = ':')
    void move_4_lower(int move, boolean isMovePossible) {
        Assertions.assertThat(RacingModel.isMovePossible(move)).isEqualTo(isMovePossible);
    }
}