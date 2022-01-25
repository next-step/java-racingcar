package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.utils.Parser;

public class ParserTest {

    static Stream<String> validCarNames() {
        return Stream.of("A,B,C,D", "Jason", "Jason,Tommy", "Jason, Tommy", "J-son,>G1<");
    }

    @DisplayName("자동차 플레이어명이 유효한지 검사 (5자 이내이며, 최소 1명 이상의 플레이어 존재)")
    @ParameterizedTest
    @MethodSource("validCarNames")
    void testCarNamesValid(String carNames) {
        List<String> names = Parser.parseCarNames(carNames); // Given & When
        assertTrue(names.size() >= 1); // Then
    }

    @DisplayName("플레이어 구분시 trim 동작 유효성 검사")
    @Test
    void testCarNamesTrimAfterSplitValid() {
        List<String> names = Parser.parseCarNames("Jason, Tommy"); // Given & When
        assertThat(names)
            .isEqualTo(Arrays.asList("Jason", "Tommy"));
    }
}
