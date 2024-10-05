package race;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import race.domain.InputValidator;
import race.domain.InvalidInputException;

import java.util.ArrayList;
import java.util.List;

public class InputValidatorTest {
    @Test
    void 자동차_대수_검증() {
        // given
        List<String> carNames = new ArrayList<>();
        carNames.add("car1");

        // when, then
        Assertions.assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> InputValidator.validateCarNames(carNames))
                .withMessageMatching("자동차는 \\d+대 이상이어야 합니다");
    }

    @Test
    void 자동차_이름_길이_검증() {
        // given
        List<String> carNames = new ArrayList<>();
        carNames.add("car201");
        carNames.add("car202");

        // when, then
        Assertions.assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> InputValidator.validateCarNames(carNames))
                .withMessageMatching("자동차 이름은 \\d+글자 이내로 입력 가능합니다");
    }

    @Test
    void 게임_회수_검증() {
        // given
        int gameCount = 0;

        // when, then
        Assertions.assertThatExceptionOfType(InvalidInputException.class)
                .isThrownBy(() -> InputValidator.validateGameCount(gameCount))
                .withMessageMatching("회수는 \\d+회 이상이어야 합니다");
    }
}
