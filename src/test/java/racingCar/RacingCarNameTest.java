package racingCar;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingCar.domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarNameTest {

    @ParameterizedTest(name = "{displayName} [{index}] {argumentsWithNames}")
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde", "1", "세글자"})
    void 자동차_이름_5글자까지_허용(String name) {
        assertThat(new RacingCar(name, 1)).isInstanceOf(RacingCar.class);
    }

    @ParameterizedTest(name = "{displayName} [{index}] {argumentsWithNames}")
    @ValueSource(strings = {"abcdef", "abcdeg", "123456", "다섯글자초과"})
    void 자동차_이름_5글자_초과시_에러(String name) {
        assertThatThrownBy(() -> new RacingCar(name, 1));
    }
}
