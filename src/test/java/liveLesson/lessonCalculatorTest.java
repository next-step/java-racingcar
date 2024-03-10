package liveLesson;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static liveLesson.lessonCalculator.calculate;
import static org.assertj.core.api.Assertions.assertThat;

public class lessonCalculatorTest {

    @Test
    @DisplayName("null값")
    void null_값_빈문자() {
        assertThat(calculate(null)).isEqualTo(0);
        assertThat(calculate("")).isEqualTo(0);
    }

    @Test
    void 문자하나() {
        assertThat(calculate("1")).isEqualTo(1);
    }

    @Test
    void 컴마_구분자() {
        assertThat(calculate("1,2")).isEqualTo(3);
    }

    @Test
    void 콜론_구분자() {
        assertThat(calculate("1:2")).isEqualTo(3);
    }
}
