package racingcar.refactoring.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static racingcar.refactoring.utils.StringUtils.repeatCharacter;
import static racingcar.refactoring.utils.StringUtils.split;

class StringUtilsTest {

    @Test
    @DisplayName("자동차 이름을 쉼표로 분리하여 배열을 반환한다.")
    void split_쉼표() {
        String[] names = split("pobi,crong,honux");
        assertThat(names).containsExactly("pobi", "crong", "honux");
    }

    @Test
    void 문자_반복() {
        String result = repeatCharacter('-', 5);
        assertThat(result).isEqualTo("-----");
    }
}
