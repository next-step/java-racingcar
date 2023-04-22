package race.step3.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import race.step3.Fixture;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    @BeforeEach
    void initCar() {
        Fixture.car = new Car();
    }

    @Test
    @DisplayName("random 값이 4미만일 경우 움직일 수 없다.")
    void canNotMove() {
        Fixture.car.tryMove(Fixture.fakeCanNotMoveStrategy);
        Assertions.assertThat(Fixture.car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.")
    void canMove() {
        Fixture.car.tryMove(Fixture.fakeCanMoveStrategy);
        Assertions.assertThat(Fixture.car.getDistance()).isEqualTo(1);
    }
}