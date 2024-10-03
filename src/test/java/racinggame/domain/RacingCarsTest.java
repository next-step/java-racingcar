package racinggame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.random.RacingGameRandomNumberGenerator;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RacingCarsTest {
    @Test
    @DisplayName("2미만의 리스트를 전달받으면 예외가 발생한다.")
    void testMinimumList() {
        assertThatThrownBy(() -> RacingCars.create(
            List.of(new RacingCar(new RacingGameRandomNumberGenerator(), "1번자동차"))
        )).isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("2이상의 리스트를 전달받으면 객체가 생성된다.")
    void testCreate() {
        final RacingGameRandomNumberGenerator generator = new RacingGameRandomNumberGenerator();
        final RacingCars racingCars = RacingCars.create(
            List.of(
                new RacingCar(generator, "1번자동차"),
                new RacingCar(generator, "2번자동차")
            )
        );

        assertThat(racingCars.size()).isEqualTo(2);
    }
}