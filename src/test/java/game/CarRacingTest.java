package game;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class CarRacingTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 숫자를_입력_하지_않으면_오류를_발생_시키는_테스트(String input) {
        assertThatThrownBy(() -> CarRacing.checkInput(input)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CarRacing.checkInput("english")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> CarRacing.checkInput("korean")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자_0_을_입력하면_오류를_발생_시키는_테스트() {
        assertThatThrownBy(() -> CarRacing.checkInput("0")).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource({
            "1, -",
            "5, --",
            "3, -"
    })
    void 특정_숫자_보다_큰_경우_문자열을_추가하는_테스트(int input, String expected) {
        // given
        StringBuilder builder = new StringBuilder();
        builder.append("-");

        // when
        CarRacing.append(builder, input);

        // then
        assertThat(builder.toString()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 2, 2, 1",
            "1, 3, 3, 1",
            "5, 3, 15, 5"
    })
    void 자동차_수와_시도_횟수에_맞게_경주_결과_수를_반환_하는_테스트(int tryCnt, int cars, int race, int endMark) {
        assertThat(CarRacing.startRace(tryCnt, cars).size()).isEqualTo(race + endMark);
    }
}
