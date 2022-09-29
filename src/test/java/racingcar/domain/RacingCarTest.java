package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.BDDAssertions.then;

class RacingCarTest {

    private final RacingCar racingCar = new RacingCar("test");

    @Test
    void getName() {
        then(racingCar.getName()).isEqualTo("test");
    }

    @Test
    @DisplayName("MoveCondition 리스트 상태에 맞게 이동하는지 Position 값으로 검증")
    void move() {
        then(racingCar.isEqualsPosition(0)).isTrue();

        racingCar.move(() -> true);
        then(racingCar.isEqualsPosition(1)).isTrue();

        racingCar.move(() -> false);
        then(racingCar.isEqualsPosition(1)).isTrue();

        racingCar.move(() -> true);
        then(racingCar.isEqualsPosition(2)).isTrue();

        racingCar.move(() -> false);
        then(racingCar.isEqualsPosition(2)).isTrue();
    }
}