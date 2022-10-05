package racingcar.view;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DistanceSymbolTest {
    @DisplayName("인자값이 없다면 기본 거리심볼을 리턴하고 아니라면 인자값으로 받은 거리심볼을 생성한다.")
    @ParameterizedTest
    @MethodSource("ofSet")
    void of(String[] arguments, String expected) {
        assertThat(DistanceSymbol.of(arguments).value()).isEqualTo(expected);
    }
    
    private static Stream<Arguments> ofSet() {
        return Stream.of(
            Arguments.arguments(new String[]{""}, "-"),
            Arguments.arguments(null, "-"),
            Arguments.arguments(new String[]{"/", "-"}, "/")
        );
    }
}
