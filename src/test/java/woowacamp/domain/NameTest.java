package woowacamp.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import woowacamp.racingcar.domain.Name;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NameTest {
    @ValueSource(strings = {"규", "충규충규충"})
    @ParameterizedTest
    @DisplayName("자동차 이름이 한 글자에서 다섯 글자 사이이면 정상적으로 생성한다.")
    void test_01(String value) {
        /* given */
        Name name = new Name(value);

        /* when & then */
        assertThat(name.getValue()).isEqualTo(value);
    }


    @ValueSource(strings = {"일이삼사오육", "일이삼사오육칠팔구"})
    @ParameterizedTest
    @DisplayName("자동차 이름이 다섯 글자보다 길면 IllegalArgumentException을 던진다.")
    void test_02(String value) {
        /* given */

        /* when & then */
        assertThatThrownBy(() -> new Name(value))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @NullAndEmptySource
    @ParameterizedTest
    @DisplayName("자동차 이름이 공백이면 IllegalArgumentException을 던진다.")
    void test_03(String value) {
        /* given */

        /* when & then */
        assertThatThrownBy(() -> new Name(value))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
