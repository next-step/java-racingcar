package study.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TokenTest {

    @DisplayName("입력 값이 null 또는 빈 문자열이면 예외가 발생한다")
    @ParameterizedTest
    @NullAndEmptySource
    void nullOrEmpty(String input) {
        assertThatThrownBy(() -> new Token(input)).isInstanceOf(RuntimeException.class);
    }

    @DisplayName("쉼표 구분자로 숫자를 분리하여 합을 계산한다")
    @Test
    void sumWithComma() {
        assertThat(new Token("1,2,3").sum()).isEqualTo(6);
    }

    @DisplayName("콜론 구분자로 숫자를 분리하여 합을 계산한다")
    @Test
    void sumWithColon() {
        assertThat(new Token("1:2:3").sum()).isEqualTo(6);
    }

    @DisplayName("쉼표와 콜론을 혼합하여 사용할 수 있다")
    @Test
    void sumWithMixedSeparator() {
        assertThat(new Token("1,2:3").sum()).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자를 사용할 수 있다")
    @Test
    void sumWithCustomSeparator() {
        assertThat(new Token("//;\n1;2;3").sum()).isEqualTo(6);
    }

    @DisplayName("음수가 포함되면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"1,-2,3", "-1", "1:-2"})
    void negativeNumber(String input) {
        assertThatThrownBy(() -> new Token(input).sum())
                .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("단일 숫자의 합을 계산한다")
    @Test
    void sumSingleNumber() {
        assertThat(new Token("5").sum()).isEqualTo(5);
    }

    @DisplayName("0을 포함한 계산이 가능하다")
    @Test
    void sumWithZero() {
        assertThat(new Token("0,1,2").sum()).isEqualTo(3);
    }

    @DisplayName("큰 숫자들의 합을 계산한다")
    @Test
    void sumLargeNumbers() {
        assertThat(new Token("100,200,300").sum()).isEqualTo(600);
    }

}