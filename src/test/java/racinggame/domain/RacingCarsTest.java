package racinggame.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.exception.InputBlankException;

class RacingCarsTest {

    @DisplayName("RacingCars 생성자 테스트")
    @Test
    void RacingCars() {
        // given
        final String inputCarNames = "car1,car2";
        final List<RacingCar> expected = Arrays.stream(inputCarNames.split(","))
                .map(RacingCar::new)
                .collect(Collectors.toList());

        // when
        final List<RacingCar> racingCars = new RacingCars(inputCarNames).get();

        // then
        assertThat(racingCars).isEqualTo(expected);
    }

    @Test
    void getCarNames_입력값에_불필요한_공백이_들어왔을_때_제거() {
        final String inputCarNames = " car1, c  a r2, c ar3";

        final RacingCars racingCars = new RacingCars(inputCarNames);
        final List<RacingCar> cars = racingCars.get();

        assertThat(cars.get(0).getName()).isEqualTo("car1");
        assertThat(cars.get(1).getName()).isEqualTo("car2");
        assertThat(cars.get(2).getName()).isEqualTo("car3");
    }

    @ValueSource(strings = {"", " ", "car1, ,car2"})
    @ParameterizedTest
    void 자동차이름_공백(final String carNames) {
        assertThrows(InputBlankException.class, () -> new RacingCars(carNames));
    }
}