package racinggame.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racinggame.domain.move.RandomMoveEx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @DisplayName("입력한 자동차 이름 수만큼 Car 객체가 생성되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"tom,dodo:2", "a,b,c:3"}, delimiter = ':')
    void checkSize(String carNames, int expected) {
        RacingCars racingCars = RacingCars.of(Arrays.asList(carNames.split(",")));
        assertThat(racingCars.getRacingCars().size()).isEqualTo(expected);
    }

    @DisplayName("모든 자동차 이동했을 경우 각 자동차의 위치가 증가했는지 확인.")
    @Test
    void move() {
        List<String> carNames = new ArrayList<>();
        carNames.add("mario");
        carNames.add("park");
        RacingCars racingCars = RacingCars.of(carNames);

        racingCars = racingCars.move(new RandomMoveEx());

        racingCars.getRacingCars().forEach(car -> assertThat(car.getPosition()).isEqualTo(1));
    }
}