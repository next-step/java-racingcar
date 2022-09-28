package racingcar.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RacingCarTest {

    private final RacingCar racingCar = new RacingCar("test");

    @Test
    void validateNameLongerThenFive() {
        assertThrows(RuntimeException.class, () -> new RacingCar("5글자넘어요"));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void validateNameIsEmpty(String name) {
        assertThrows(RuntimeException.class, () -> new RacingCar(name));
    }

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