package edu.nextstep.racingcar.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("String 클래스에 대한 학습 테스트")
class StringUtilsTest {

    @DisplayName("요구사항 1-1")
    @Test
    void split_req_01() {
        StringUtils stringUtils = new StringUtils("1,2");

        assertThat(stringUtils.splitByComma()).contains("1", "2");
        assertThat(stringUtils.splitByComma()).containsExactly("1", "2");
    }

    @DisplayName("요구사항 1-1")
    @Test
    void split_req_02() {
        StringUtils stringUtils = new StringUtils("1");

        assertThat(stringUtils.splitByComma()).contains("1");
        assertThat(stringUtils.splitByComma()).containsExactly("1");
    }

    @DisplayName("요구사항 2")
    @Test
    void remove_req_01() {
        StringUtils stringUtils = new StringUtils("(1,2)");

        assertThat(stringUtils.removeBracket()).isEqualTo("1,2");
    }

    @DisplayName("요구사항 3")
    @Test
    void get_character_req_01() {
        StringUtils stringUtils = new StringUtils("abc");

        assertThat(stringUtils.getCharacter(0)).isEqualTo('a');
        assertThat(stringUtils.getCharacter(1)).isEqualTo('b');
        assertThat(stringUtils.getCharacter(2)).isEqualTo('c');

        assertThatThrownBy(() -> stringUtils.getCharacter(3))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageMatching("String index out of range: \\d+");
    }
}