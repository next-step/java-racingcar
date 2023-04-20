package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class CalculagtorTest {

    @Test
    void 쉼표구분자테스트() {
        String sample = "1,2,3";
        int result = StringNumberCalculator.splitAndSum(sample);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 쉼표구분자테스트에빈문자열을넣으면결과0() {
        String sample = "";
        int result = StringNumberCalculator.splitAndSum(sample);
        assertThat(result).isEqualTo(0);
    }

    @Test
    void 구분자콜론테스트() {
        String sample = "1:2:3:4:5";
        int result = StringNumberCalculator.splitAndSum(sample);
        assertThat(result).isEqualTo(15);
    }

    @Test
    void 혼합테스트() {
        String sample = "1,2:3";
        int result = StringNumberCalculator.splitAndSum(sample);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 커스텀구분자() {
        String sample = "//b\n1b2b3";
        int result = StringNumberCalculator.splitAndSum(sample);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void 음수일경우예외처리() {
        String sample = "-1:2:3";

        assertThatThrownBy(() -> {
            StringNumberCalculator.splitAndSum(sample);
        }).isInstanceOf(RuntimeException.class);
    }
}
