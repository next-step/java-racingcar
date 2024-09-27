package com.warmup.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

    @DisplayName("문자열 배열이 ','를 기준으로 잘 쪼개어 지는지 여부")
    @Test
    public void isContain_ShouldContainsExpectedSplitStringArray() {
        String[] expectedValue = {"1", "2"};

        assertThat(StringHelper.splitter("1,2")).containsExactly(expectedValue);
    }

    @DisplayName("괄호를 가지고 있는 문자열 배열이 ','를 기준으로 잘 쪼개어 지는지 여부")
    @Test
    public void isContain_ShouldContainsExpectedSplitHasParenthesesStringArray() {
        String[] expectedValue = {"1", "2"};

        assertThat(StringHelper.splitter("(1,2)")).containsExactly(expectedValue);
    }

    @DisplayName("String 문자열의 길이에 맞지 않은 인덱스 접근을 하는지 여부")
    @Test
    public void isEquals_ShouldEqualExpectedValue() {
        char expectedValue = 'a';

        assertThat(StringHelper.getCharByIndex("abc", 0)).isEqualTo(expectedValue);

        assertThatThrownBy(() -> {
            assertThat(StringHelper.getCharByIndex("abc", 4)).isEqualTo(expectedValue);
        }).isInstanceOf(Exception.class)
                .hasMessageContaining("4");
    }
}
