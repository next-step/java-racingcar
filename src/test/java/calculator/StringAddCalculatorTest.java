package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    void 빈_문자열_이거나_null_인경우_숫자합계_반환(String str) {
        int result = StringAddCalculator.splitAndSum(str);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 단일_숫자형_문자열_합계반환() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 쉼표를_기준으로_문자열_분리하여_합계_반환() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    void 콜론을_기준으로_문자열_분리하여_합계_반환() {
        int result = StringAddCalculator.splitAndSum("2:3");
        assertThat(result).isEqualTo(5);
    }

    @Test
    void 쉼표와_콜론_기준으로_문자열_분리하여_합계_반환() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 숫자_이외의_값_전달하는경우_예외반환() {
        assertThrows(RuntimeException.class, () ->
                StringAddCalculator.splitAndSum("HelloWorld,123")
        );
    }

    @Test
    void 음수_전달하는경우_예외반환() {
        assertThrows(RuntimeException.class, () ->
                StringAddCalculator.splitAndSum("1,-1")
        );
    }

    @Test
    void 커스텀_구분자_기준으로_합계_반환() {
        int result = StringAddCalculator.splitAndSum("//@\n1@5@6");
        assertThat(result).isEqualTo(12);
    }
}
