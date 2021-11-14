package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.exception.CarNameException;

import java.util.stream.Stream;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.assertj.core.api.Java6Assertions.assertThatThrownBy;

class NameTest {

    @ParameterizedTest
    @DisplayName("CarName 생성 테스트")
    @MethodSource
    void createTest(String name, Name expected) {
        Name carName = Name.from(name);

        assertThat(carName).isEqualTo(expected);
    }

    static Stream<Arguments> createTest() {
        return Stream.of(
                Arguments.of(
                        "A", Name.from("A")
                ),
                Arguments.of(
                        "BBBBB", Name.from("BBBBB")
                )
        );
    }

    @ParameterizedTest
    @DisplayName("CarName 인자가 null, empty일 때 생성 예외 테스트")
    @NullAndEmptySource
    void createExcetionTest(String name) {
        assertThatThrownBy(() -> Name.from(name)).isInstanceOf(CarNameException.class);
    }

    @ParameterizedTest
    @DisplayName("CarName 인자 길이가 5 이상 일 때 생성 예외 테스트")
    @ValueSource(strings = "aaaaaa")
    void createExcetionByLengthTest(String name) {
        assertThatThrownBy(() -> Name.from(name)).isInstanceOf(CarNameException.class);
    }


}