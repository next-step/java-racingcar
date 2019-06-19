package racing.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class EntireCarsTest {

    @ParameterizedTest(name = "EntireCars 생성 검증. carNames={0}, expectedCarSize={1}")
    @MethodSource
    void of(List<String> carNames, int expectedCarSize) {

        EntireCars entireCars = EntireCars.of(carNames);

        assertThat(entireCars.getCars()).hasSize(expectedCarSize);
    }

    @ParameterizedTest(name = "EntireCars 생성시 차량명이 null 이거나 사이즈가 0이라면 IllegalArgumentException 발생")
    @MethodSource
    void of_IllegalArgumentException(List<String> carNames) {

        assertThatIllegalArgumentException()
                .isThrownBy(() -> EntireCars.of(carNames))
                .withMessage("차의 개수는 1개 이상이어야 합니다.");
    }

    private static Stream<Arguments> of() {

        return Stream.of(
                Arguments.of(Arrays.asList("pobi", "crong", "honux"), 3),
                Arguments.of(Arrays.asList("pobi", "crong"), 2),
                Arguments.of(Arrays.asList("pobi"), 1)
        );
    }

    private static Stream<Arguments> of_IllegalArgumentException() {

        return Stream.of(
                Arguments.of(Collections.emptyList()),
                Arguments.of((Object) null)
        );
    }
}