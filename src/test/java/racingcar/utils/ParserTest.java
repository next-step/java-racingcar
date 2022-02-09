package racingcar.utils;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class ParserTest {
    static Stream<String> validCarNames() {
        return Stream.of("A,B,C,D", "holee", "Jason, holee");
    }

    @DisplayName("자동차의 이름이 한 글자 이상 일때, 유효하다.")
    @ParameterizedTest
    @MethodSource("validCarNames")
    void testCarNamesValid(String carNames) {
        List<String> names = Parser.parseCarNames(carNames); // Given & When
        assertTrue(names.size() >= 1); // Then
    }

    @DisplayName("'Jason, holee'가 주어질 때, Parser는 trim을 수행 할 수 있다.")
    @Test
    void testCarNamesTrimAfterSplitValid() {
        List<String> names = Parser.parseCarNames("Jason, holee"); // Given & When
        assertThat(names)
            .isEqualTo(Arrays.asList("Jason", "holee"));
    }

    @DisplayName("이름 splitter가 적절하게 입력되었을 때는 플레이어를 정상적으로 인식")
    @Test
    void testNameSplitterValid() {
        assertThat(Parser.parseCarNames("A,B,C")) // Given & When
            .isEqualTo(Arrays.asList("A", "B", "C")); // Then
    }
}
