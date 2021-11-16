package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import racingcar.exception.WinnersException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinnersTest {

    @ParameterizedTest
    @DisplayName("Winners 생성 테스트")
    @MethodSource
    void createTest(List<Car> cars) {
        Winners winners = Winners.from(cars);

        assertThat(winners).isInstanceOf(Winners.class);
    }

    static Stream<Arguments> createTest() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList(Car.from(Name.from("AA")), Car.from(Name.from("BB")), Car.from(Name.from("CC")))
                )
        );
    }

    @ParameterizedTest
    @DisplayName("Winners 생성 예외 테스트")
    @NullAndEmptySource
    void winnersExceptionTest(List<Car> cars) {

        assertThatThrownBy(() -> Winners.from(cars)).isInstanceOf(WinnersException.class);
    }

}