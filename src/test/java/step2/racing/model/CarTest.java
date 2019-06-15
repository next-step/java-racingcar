package step2.racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.racing.random.RandomGenerator;
import step2.racing.random.StubRandomGenerator;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @Test
    @DisplayName("랜덤숫자가 4 이상 9 이하라면 이동한다.")
    void race_should_move() {

        IntStream.rangeClosed(4, 9)
                .forEach(number -> {

                    car = Car.of(0);
                    car.race(number);
                    assertThat(car.getPosition()).isGreaterThan(Car.DEFAULT_POSITION);

                });
    }

    @Test
    @DisplayName("랜덤숫자가 0 이상 3 이하라면 이동하지 않는다.")
    void race_should_not_move() {

        IntStream.rangeClosed(0, 3)
                .forEach(number -> {

                    car = Car.of(0);
                    car.race(number);
                    assertThat(car.getPosition()).isEqualTo(Car.DEFAULT_POSITION);

                });
    }
}