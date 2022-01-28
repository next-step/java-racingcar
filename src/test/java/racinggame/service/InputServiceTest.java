package racinggame.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputServiceTest {

    InputService inputService = new InputService();

    @Test
    void getTrial_입력() {
        // given
        String inputTrial = "10";

        // when
        int trial = inputService.parseTrial(inputTrial);

        // then
        assertThat(trial).isEqualTo(10);
    }

    @ValueSource(strings = {"1 0", " 10", " 1 0 ", "10 ", "1   0  "})
    @ParameterizedTest
    void getTrial_불필요한_공백이_들어왔을_때_제거(String inputTrial) {
        // when
        int trial = inputService.parseTrial(inputTrial);

        // then
        assertThat(trial).isEqualTo(10);
    }

    @Test
    void 시도횟수는_숫자인지_검증하는_로직_실패() {
        String trial = "a";

        assertThrows(IllegalArgumentException.class, () -> inputService.parseTrial(trial));
    }

    @Test
    void 시도횟수는_숫자인지_검증하는_로직_성공() {
        String trial = "5";

        assertDoesNotThrow(() -> inputService.parseTrial(trial));
    }

    @Test
    void getCarNames_입력() {
        String inputCarNames = "car1, car2, car3";

        String[] carNames = inputService.parseCarNames(inputCarNames);

        assertThat(carNames[0]).isEqualTo("car1");
        assertThat(carNames[1]).isEqualTo("car2");
        assertThat(carNames[2]).isEqualTo("car3");
    }

    @Test
    void getCarNames_입력값에_불필요한_공백이_들어왔을_때_제거() {
        String inputCarNames = " car1, c  a r2, c ar3";

        String[] carNames = inputService.parseCarNames(inputCarNames);

        assertThat(carNames[0]).isEqualTo("car1");
        assertThat(carNames[1]).isEqualTo("car2");
        assertThat(carNames[2]).isEqualTo("car3");
    }

    @ValueSource(strings = {"", " ", "car1, ,car2"})
    @ParameterizedTest
    void 자동차이름_공백(String carNames) {
        assertThrows(IllegalArgumentException.class, () -> inputService.parseCarNames(carNames));
    }
}
