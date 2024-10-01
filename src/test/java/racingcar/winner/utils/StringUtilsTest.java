package racingcar.winner.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringUtilsTest {

    @Test
    @DisplayName("자동차 이름을 쉼표로 분리하여 배열을 반환한다.")
    void split_쉼표() {
        String[] names = StringUtils.split("pobi,crong,honux");
        assertThat(names).containsExactly("pobi", "crong", "honux");
    }
}
