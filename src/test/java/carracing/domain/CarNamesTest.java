package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

@DisplayName("자동차들의 이름을 위한 테스트")
class CarNamesTest {
    private static final String TEST_CAR_NAMES = "pobi,crong,honux";
    private static final String DELIMITER = ",";

    @DisplayName("유효한 자동차들의 이름이 생성되는지 확인")
    @ParameterizedTest
    @MethodSource("provideValidCarNames")
    void createValidPositionTest(List<CarName> validCarNames) {
        // When
        CarNames actual = new CarNames(validCarNames);

        // Then
        assertThat(actual).isNotNull();
    }

    @DisplayName("유효하지 않은 자동차들의 이름이 예외를 발생하는지 확인")
    @ParameterizedTest
    @MethodSource("provideInvalidCarNames")
    void checkExceptionWithInvalidCarNamesTest(List<CarName> invalidCarNames) {
        // When & Then
        assertThatIllegalArgumentException().isThrownBy(
                () -> new CarNames(invalidCarNames)
        );
    }

    private static Stream<Arguments> provideValidCarNames() {
        List<Arguments> arguments = new ArrayList<>();
        arguments.add(Arguments.of(convertTestCarNames()));
        return arguments.stream();
    }

    private static Stream<Arguments> provideInvalidCarNames() {
        List<Arguments> arguments = new ArrayList<>();
        arguments.add(null);
        arguments.add(Arguments.of(Collections.emptyList()));
        return arguments.stream();
    }

    private static List<CarName> convertTestCarNames() {
        String[] testCarNames = TEST_CAR_NAMES.split(DELIMITER);
        return Arrays.stream(testCarNames)
                .map(CarName::new)
                .collect(Collectors.toList());
    }
}
