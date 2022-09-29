package racingcar.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class RacingCarTest {

    private final RacingCar racingCar = new RacingCar("test");

    @Test
    void getPosition() {
        then(racingCar.getPosition()).isEqualTo(0);
    }

    @Test
    void getName() {
        then(racingCar.getName()).isEqualTo("test");
    }

    @Test
    void isEqualsPosition() {
        then(racingCar.isEqualsPosition(0)).isTrue();
    }

    @Test
    void move() {
        then(racingCar.getPosition()).isEqualTo(0);

        racingCar.move(() -> true);
        then(racingCar.getPosition()).isEqualTo(1);

        racingCar.move(() -> false);
        then(racingCar.getPosition()).isEqualTo(1);

        racingCar.move(() -> true);
        then(racingCar.getPosition()).isEqualTo(2);

        racingCar.move(() -> false);
        then(racingCar.getPosition()).isEqualTo(2);
    }
}