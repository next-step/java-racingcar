package racing.model;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameReadyInfoTest {

    @ParameterizedTest
    @CsvSource({
            "'a', 1",
            "'a,b,c', 5"
    })
    @DisplayName("올바른 값이 입력된 경우")
    void correctInputTest(final String carNames, final int tryCount) {
        assertThatCode(() -> new GameReadyInfo(carNames, tryCount)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource({
            "'', 1",
            "'a,b,c', 0",
            "'a', -1"
    })
    @DisplayName("잘못된 값이 입력된 경우")
    void wrongInputTest(final String carNames, final int tryCount) {
        assertThatThrownBy(() -> new GameReadyInfo(carNames, tryCount)).isInstanceOf(IllegalArgumentException.class);
    }
}