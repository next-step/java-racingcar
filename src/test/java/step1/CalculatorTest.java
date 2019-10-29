/**
* Step1 계산기 테스트
* @author whlee0525
* @version 1.0.0
* @since 2019-10-29 오후 6:16
**/

package step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CalculatorTest {

    @DisplayName("데이터입력 - isNull, isBlank 테스트")
    @Test
    void calculateSentenceIsNullTest() {
        Calculator c = new Calculator();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            c.calculateSentence(null);
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            c.calculateSentence("");
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            c.calculateSentence(" ");
        });
    }

    @DisplayName("데이터입력 - isInvalid 테스트")
    @Test
    void calculateSentenceIsInvalidTest() {
        Calculator c = new Calculator();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            c.calculateSentence("3 & 8");
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            c.calculateSentence("3 8 7");
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            c.calculateSentence("3 *");
        });
    }

    @DisplayName("데이터 연산 - 단일연산")
    @Test
    void calculateSentenceSimpleCalTest() {
        Calculator c = new Calculator();
        assertThat(c.calculateSentence("2 + 2")).isEqualTo(4);
        assertThat(c.calculateSentence("2 - 3")).isEqualTo(-1);
        assertThat(c.calculateSentence("2 * 4")).isEqualTo(8);
        assertThat(c.calculateSentence("3 / 2")).isEqualTo(1);

    }

    @DisplayName("데이터연산 - 다수연산")
    @Test
    void calculateSentenceComplexCalTest() {
        Calculator c = new Calculator();
        assertThat(c.calculateSentence("2 + 3 - 1")).isEqualTo(4);
        assertThat(c.calculateSentence("2 + 3 * 4")).isEqualTo(20);
        assertThat(c.calculateSentence("2 / 3 + 4 / 2")).isEqualTo(2);
        assertThat(c.calculateSentence("2 + 3 * 4 / 2")).isEqualTo(10);
    }

    @DisplayName("데이터연산 - 0으로 나누기 연산")
    @Test
    void calculateSentenceDivideZeroTest() {
        Calculator c = new Calculator();
        assertThatIllegalArgumentException().isThrownBy(() -> {
            c.calculateSentence("3 / 0");
        });
        assertThatIllegalArgumentException().isThrownBy(() -> {
            c.calculateSentence("3 + 5 / 0");
        });
    }


}