package racingcar.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputViewTest {
    @DisplayName("getNamesOfCars : UI에서 입력된 String을 각각의 Car name들로 분리된 String Array로 반환")
    @Test
    void getNamesOfCars() {
        assertThat(InputView.getNamesOfCars(" ABC, DEF ,GHIJ")).containsExactly("ABC", "DEF", "GHIJ");
        assertThat(InputView.getNamesOfCars(" ABC ,  D EF")).containsExactly("ABC", "D EF");
    }

    @DisplayName("isValidInputOfCars : Console에서 입력한 String이 유효한지 검사")
    @ParameterizedTest(name = "{index} {displayName} {arguments}")
    @MethodSource("provideArgumentsForisValidInputOfCars")
    void isValidInputOfCars(String name, boolean expected) {
        assertThat(InputView.isValidInputOfCars(name)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideArgumentsForisValidInputOfCars() {
        return Stream.of(
                Arguments.of("ABC, DEF, GHI, J", true),
                Arguments.of(" , ABC, DEF, GHI", false),
                Arguments.of("ABC, , DEF, GHI", false),
                Arguments.of(" ", false),
                Arguments.of("", false),
                Arguments.of(" ,", false)
        );
    }
}