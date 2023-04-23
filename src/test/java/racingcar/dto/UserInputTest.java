package racingcar.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.InvalidGameRoundNumberException;

@DisplayName("자동차 객체 테스트")
public class UserInputTest {

    @DisplayName("자동차 경주 시도 횟수는 양수만 입력 할 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {0, -9})
    void validateCarRepetitionCount(int round) {
        String carName = "korea11, japan, china";
        Assertions.assertThatThrownBy(() -> new UserInput(round, carName))
                .isInstanceOf(InvalidGameRoundNumberException.class)
                .hasMessageContaining("자동차 시도 횟수는 양수만 입력 가능합니다");
    }
}
