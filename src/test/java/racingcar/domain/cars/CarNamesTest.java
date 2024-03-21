package racingcar.domain.cars;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static racingcar.config.RacingCarException.CAR_NAME_DUPLICATED;

import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import racingcar.domain.cars.CarNames;

class CarNamesTest {

    @ParameterizedTest
    @MethodSource("duplicatedNames")
    @DisplayName("자동차 이름 목록에 중복이 존재한 상태로 생성하는 경우 예외를 던진다.")
    void from_DuplicatedCarNames_Exception(final String[] duplicatedNames) {
        assertThatThrownBy(() -> CarNames.from(duplicatedNames))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(CAR_NAME_DUPLICATED.message(duplicatedNames));
    }

    static Stream<Arguments> duplicatedNames() {
        return Stream.of(
                Arguments.of((Object)new String[] {"kyle", "kyle", "alex"}),
                Arguments.of((Object)new String[] {"kyle", " kyle", "alex"}),
                Arguments.of((Object)new String[] {"kyle", "kyle ", "alex"}),
                Arguments.of((Object)new String[] {"kyle", " kyle ", "alex"})
        );
    }
}
