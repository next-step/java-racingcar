package com.ssabae.nextstep.racingcar.step01;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * @author : leesangbae
 * @project : java-racingcar
 * @since : 2020-11-30
 */
@DisplayName("String 클래스에 대한 학습 테스트")
public class StringClassTest {

    @Test
    @DisplayName("쉼표를 이용한 String Split Test")
    void splitTest() {
        // given
        String str = "1,2";

        // when
        String[] split = str.split(",");

        // then
        assertThat(split).contains("1");
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    @DisplayName("쉼표를 이용한 String Split Test (단일 항목)")
    void splitTestWithSingleItem() {
        // given
        String str = "1";

        // when
        String[] split = str.split(",");

        // then
        assertThat(split).contains("1");
    }

    @Test
    @DisplayName("쉼표를 이용한 String Split Test (괄호 있는 문자열)")
    void splitTestWithBracketString() {
        // given
        String str = "(1,2)";
        int startIndex = 0;
        int endIndex = str.length();

        // when
        if (str.startsWith("(")) {
            startIndex++;
        }
        if (str.endsWith(")")) {
            endIndex--;
        }
        str = str.substring(startIndex, endIndex);
        String[] split = str.split(",");

        // then
        assertThat(split).contains("1");
        assertThat(split).containsExactly("1", "2");
    }

    @Test
    @DisplayName("문자열의 특정 위치에 대한 문자 반환 Test")
    void stringCharAtTest() {
        // given
        String str = "abc";

        // when
        char c = str.charAt(1);

        // then
        assertThat(c).isEqualTo('b');
    }

    @Test
    @DisplayName("문자열의 특정 위치에 대한 문자 반환 예외 Test (IndexOutOfBoundsException)")
    void stringCharAtTestWithIndexOutOfBoundsException() {
        // given
        String str = "ab";

        // when, then
        assertThatThrownBy(() -> {
            char c = str.charAt(2);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 2");
    }

}
