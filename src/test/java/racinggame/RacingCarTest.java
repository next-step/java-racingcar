package racinggame;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    void racing() {
        // given
        RacingCar racingCar = RacingCar.of(List.of("a", "b", "c"));
        List<Car> cars = racingCar.getCars();

        // when
        racingCar.racing();

        // then
        for (Car car : cars) {
            assertThat(car.getStatus()).isLessThanOrEqualTo(1);
        }
    }

    @Test
    void 우승자_목록을_반환한다() {
        // given
        Car gumsu = new Car("gumsu", 5);
        Car pobi = new Car("pobi", 3);
        Car crong = new Car("crong", 2);
        Car conan = new Car("conan", 5);
        RacingCar racingCar = new RacingCar(List.of(gumsu, pobi, crong, conan));
        List<Car> expected = List.of(gumsu, conan);

        // when
        List<Car> winners = racingCar.getWinners();

        // then
        assertThat(winners).isEqualTo(expected);
        assertThat(winners.size()).isEqualTo(expected.size());
    }
}