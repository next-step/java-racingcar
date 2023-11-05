package racingcargame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcargame.RacingCarGame.isPossibleToMove;
import static racingcargame.RacingCarGame.moveForward;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class RacingCarGameTest {

    @DisplayName("isPossibleToMove 수행 시 4 이상일 경우 true, 그렇지 않을 경우 false 를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"4, true", "5, true", "1, false"})
    void isPossibleToMove_ShouldReturnTrueOrFalse(int input, boolean expected) {
        assertThat(isPossibleToMove(input)).isEqualTo(expected);
    }

    @Test
    void moveForward_처음_이동_시() {
        assertThat(moveForward(null)).isEqualTo("-");
    }

    @DisplayName("moveForward 수행 시 하이픈이 하나 더 추가된 결과가 나온다.")
    @ParameterizedTest
    @CsvSource(value = {"-, '--'", "'--', '---'"})
    void moveForward_ShouldReturnRacingResult(String input, String expected) {
        assertThat(moveForward(input)).isEqualTo(expected);
    }
}