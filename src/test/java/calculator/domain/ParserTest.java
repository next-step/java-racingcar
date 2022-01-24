package calculator.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParserTest {
    @DisplayName("문자열 추출 후 리스트 변환 확인")
    @Test
    void 문자열_리스트_변환() {
        List<String> result = Parser.parseInput("5 + 4 - 3 * 2 / 1");
        List<String> expect = Arrays.asList("5", "+", "4", "-", "3", "*", "2", "/", "1");
        assertThat(result).isEqualTo(expect);
    }
}