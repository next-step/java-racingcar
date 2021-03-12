package racingcar.domain.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.car.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarsTest {

    @DisplayName("RacingCar 가 인자값으로 들어온 수 만큼의 요소를 갖는 리스트를 만드는지에 대한 테스트")
    @ParameterizedTest(name = "현재 반복 : {index} / 들어가는 값 : {arguments}")
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10})
    void moveTest(int expected) {
        // given
        RacingCars racingCars = RacingCars.from(expected);
        List<Car> cars = racingCars.move();

        // when
        int actual = cars.size();

        // then
        assertThat(actual).isEqualTo(expected);
    }}