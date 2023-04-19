package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차 객체 테스트")
public class PositiveNumberTest {

    @DisplayName("자동차 대수는 양수만 입력가능하다")
    @ParameterizedTest
    @ValueSource(ints = {0, -4})
    void validateCarParticipationNumber(Integer number) {
        Assertions.assertThatThrownBy(() -> new PositiveNumber(number, 3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 대수는 양수만 입력가능합니다");
    }

    @DisplayName("자동차 경주 시도 횟수는 양수만 입력 할 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {0, -9})
    void validateCarRepetitionCount(int count) {
        Assertions.assertThatThrownBy(() -> new PositiveNumber(4, count))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 시도 횟수는 양수만 입력 가능합니다");
    }

}
