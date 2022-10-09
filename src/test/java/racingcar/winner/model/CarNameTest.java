package racingcar.winner.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import racingcar.winner.exception.InvalidInputException;

public class CarNameTest {

    @DisplayName("입력받는 자동차의 이름은 주어진 길이를 초과할 수 없다")
    @ParameterizedTest
    @ValueSource(strings = {"long car name", "123456"})
    void 자동차이름은_길이를_제한한다(String input) {
        Assertions.assertThatThrownBy(() -> {
            CarName name = new CarName(input);
        }).isInstanceOf(InvalidInputException.class);
    }

    @DisplayName("입력받는 자동차의 이름은 공백을 가질 수 없다")
    @Test
    void 자동차이름은_공백이존재할수없다() {
        Assertions.assertThatThrownBy(() -> {
            CarName name = new CarName("");
        }).isInstanceOf(InvalidInputException.class);
    }
}
