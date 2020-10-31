package study.step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class StringCalculatorTest {

    private StringCalculator sc;

    @BeforeEach
    void setUp() {
        this.sc = new StringCalculator();
    }

    @Test
    @DisplayName(" 1 + 2 + 3 테스트 ")
    void 수식1_테스트() {
        assertThat(sc.calculateStringInput("1 + 2 + 3")).isEqualTo(6);
    }

    @Test
    @DisplayName(" 1 + 2 + 4 테스트 ")
    void 수식2_테스트() {
        assertThat(sc.calculateStringInput("1 + 2 + 4")).isEqualTo(7);
    }

    @Test
    @DisplayName(" 1 + 2 + 3 테스트 ")
    void 수식3_테스트3() {
        assertThat(sc.calculateStringInput("1 + 2 / 3")).isEqualTo(1);
    }

    @Test
    @DisplayName(" 1 + 2 + 3 테스트 ")
    void 수식4_테스트4() {
        assertThat(sc.calculateStringInput("1 + 2 * 3")).isEqualTo(9);
    }

    @Test
    @DisplayName(" 비어있는 입력 테스트")
    void 비어있는_입력_테스트() {

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    assertThat(sc.calculateStringInput("")).isEqualTo(9);
                }).withMessageContaining("입력값이 비어있습니다.");
    }


}