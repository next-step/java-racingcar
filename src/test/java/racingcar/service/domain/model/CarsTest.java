package racingcar.service.domain.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.service.domain.Car;
import racingcar.service.model.Cars;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static racingcar.service.domain.TestCarMaker.secondPlace;
import static racingcar.service.domain.TestCarMaker.victory;

class CarsTest {

    @ParameterizedTest
    @MethodSource(value = "getFinalWinnerName")
    @DisplayName("각 경기별로 우승자 검증")
    void getFinalWinnerName(List<Car> carList, String winner) {
        // given
        Cars cars = Cars.from(carList);

        // when
        String result = cars.getFinalWinnerName();

        // then
        assertThat(result).isEqualTo(winner);
    }

    @Test
    @DisplayName("Cars의 필수값이 null인 경우 예외 발생 검증")
    void createException() {
        // when & then
        assertThatNullPointerException().isThrownBy(() -> Cars.from(null));
    }

    private static Stream<Arguments> getFinalWinnerName() {
        // given
        return Stream.of(
                Arguments.of(Arrays.asList(victory("pobi"), secondPlace("crong"), secondPlace("honux")),
                             "pobi"
                ),
                Arguments.of(Arrays.asList(secondPlace("pobi"), victory("crong"), secondPlace("honux")),
                             "crong"
                ),
                Arguments.of(Arrays.asList(secondPlace("pobi"), secondPlace("crong"), victory("honux")),
                             "honux"
                ),
                Arguments.of(Arrays.asList(victory("pobi"), victory("crong"), secondPlace("honux")),
                             "pobi, crong"
                ),
                Arguments.of(Arrays.asList(victory("pobi"), victory("crong"), victory("honux")),
                             "pobi, crong, honux"
                )
        );
    }
}
