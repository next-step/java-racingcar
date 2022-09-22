package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @DisplayName("문자열 입력이 주어졌을 때, 덧셈 결과를 반환해야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {
        "1,2:3",
        "//;\n1;2;3"
    })
    void splitAndSum(String input) {
        PositiveInteger actual = StringAddCalculator.splitAndSum(input);
        assertThat(actual).isEqualTo(new PositiveInteger(6));
    }

    @DisplayName("정수 리스트가 주어졌을 때, 리스트의 모든 요소의 합을 반환해야 한다.")
    @Test
    void splitAndSum_givenIntegerList() {
        PositiveInteger actual = StringAddCalculator.sum(
                List.of(new PositiveInteger(1), new PositiveInteger(2), new PositiveInteger(3))
        );
        assertThat(actual).isEqualTo(new PositiveInteger(6));
    }

    // 제공되는 테스트 코드 소스
    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(String input) {
        PositiveInteger result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(new PositiveInteger(0));
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        PositiveInteger result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(new PositiveInteger(1));
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        PositiveInteger result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(new PositiveInteger(3));
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        PositiveInteger result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(new PositiveInteger(6));
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        PositiveInteger result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(new PositiveInteger(6));
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수를 전달할 수 없습니다.");
    }

}
