package racingcar.winner.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringUtilsTest {

    @Test
    @DisplayName("자동차 이름을 쉼표로 분리하여 배열을 반환한다.")
    void split_쉼표() {
        String[] names = StringUtils.split("pobi,crong,honux");
        assertThat(names).containsExactly("pobi", "crong", "honux");
    }

    @Test
    @DisplayName("자동차 이름이 5글자 초과시 IllegalArgumentException를 반환한다.")
    void split_쉼표_5글자초과() {
        assertThatThrownBy(() -> StringUtils.split("Byeongjoon,pobi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }
}
