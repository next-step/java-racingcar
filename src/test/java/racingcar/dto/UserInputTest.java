package racingcar.dto;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("자동차 객체 테스트")
public class UserInputTest {

    @DisplayName("자동차 경주 시도 횟수는 양수만 입력 할 수 있다")
    @ParameterizedTest
    @ValueSource(ints = {0, -9})
    void validateCarRepetitionCount(int round) {
        String carName = "korea11, japan, china";
        Assertions.assertThatThrownBy(() -> new UserInput(round, carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 시도 횟수는 양수만 입력 가능합니다");
    }

    @DisplayName("자동차 이름 5자리를 초과하면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"koreajapan", "chinabetnam"})
    void 자동차_이름_예외_테스트(String carName) {
        Assertions.assertThatThrownBy(() -> new UserInput(1, carName))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름은 5자를 초과 할 수 없습니다");
    }
}
