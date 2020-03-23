package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class OutputTest {
    private Output output;

    @BeforeEach
    void setUp() {
        output = new Output(new StringBuilder());
    }

    @DisplayName("자동차 이동거리에 대해서 bar가 성공적으로 매핑이 된다.")
    @ParameterizedTest
    @MethodSource("provideBars")
    void view(int distance, String expect) {
        // when
        output.mappingToBar(distance);
        String bars = output.getBar();

        // then
        assertThat(bars).isEqualTo(expect);
    }

    private static Stream<Arguments> provideBars() {
        return Stream.of(
                Arguments.of(0, "")
                ,Arguments.of(1, "-")
                ,Arguments.of(2, "--")
                ,Arguments.of(3, "---")
                ,Arguments.of(4, "----")
                ,Arguments.of(5, "-----")
        );
    }
}