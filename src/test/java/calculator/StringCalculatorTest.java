package calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StringCalculatorTest {

    private StringCalculator cal;

    @BeforeAll
    public void setUp() {
        cal = new StringCalculator();
    }

    @Test
    public void null_또는_빈문자() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    cal.calculate("");
                }).withMessageMatching("입력에 0 또는 NULL 값을 넣을 수 없습니다.");


        assertThatIllegalArgumentException().isThrownBy(() -> {
            cal.calculate(null);
        });
    }

    @Test
    public void 숫자_하나() throws Exception {
        assertEquals(1, cal.calculate("1"));
    }

    @Test
    public void 샘플_데이터() throws Exception {
        assertAll(
                () -> assertEquals(10, cal.calculate("2 + 3 * 4 / 2")),
                () -> assertEquals(8, cal.calculate("1 + 4 * 8 / 5")),
                () -> assertEquals(18, cal.calculate("7 + 5 * 9 / 6")),
                () -> assertEquals(9, cal.calculate("9 + 6 * 3 / 5")),
                () -> assertEquals(7, cal.calculate("7 + 7 * 4 / 8"))
                );
    }

}