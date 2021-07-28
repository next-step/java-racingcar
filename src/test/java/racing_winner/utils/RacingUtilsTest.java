package racing_winner.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingUtilsTest {

    @ParameterizedTest
    @DisplayName("경주 횟수 및 자동차 대 수 입력값의 예외 출력 확인")
    @CsvSource(value = {"0:'test'", "1:''","0:''"}, delimiter = ':')
    void checkInputValue(int round, String carNames) {
        assertThatThrownBy(
                () ->  RacingUtils.checkInputValue(round, carNames)
        ).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("입력한 자동차 이름이 5글자 초과일때 예외 테스트")
    void checkNameLength() {
        String name = "playertest";
        assertThatThrownBy(
                () ->  RacingUtils.checkNameLength(name)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력한 문자열을 자동차 이름대로 배열 저장 테스트")
    void splitCarArray() {
        String[] names =RacingUtils.splitCarArray("pobi,crong,honux");
        assertThat(names).contains("pobi","crong","honux");
    }

}