package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;

class CarNameTest {

    @ParameterizedTest
    @DisplayName("CarName 생성 테스트")
    @MethodSource
    void createTest(String name, CarName expected) {
        CarName carName = CarName.from(name);

        assertThat(carName).isEqualTo(expected);
    }

    static Stream<Arguments> createTest() {
        return Stream.of(
                Arguments.of(
                        "AA", CarName.from("AA")
                ),
                Arguments.of(
                        "BB", CarName.from("BB")
                ),
                Arguments.of(
                        "CC", CarName.from("CC")
                )
        );
    }

}