package racingcar.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


class CarTest {

    @Test
    void findMaxPositionTest() {
        Car car = new Car(new Participant("hong"), new Position(3));
        assertThat(car.maxPosition(new Position(2))).isEqualTo(new Position(3));
        assertThat(car.maxPosition(new Position(4))).isEqualTo(new Position(4));
    }

    @Test
    @DisplayName("최대이동거리 테스트")
    void maxPositionTest() {
        Position maxPosition = new Position(3);
        Car car = new Car(new Participant("hong"), new Position(3));
        boolean result = car.isMaxPosition(maxPosition);

        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("자동차 이동 테스트")
    void moveTest() {
        Car car = new Car(new Participant("hong"));
        car.move(true);
        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }

    @Test
    @DisplayName("자동차 정지 테스트")
    void stopTest() {
        Car car = new Car(new Participant("hong"));
        car.move(true);
        car.move(false);
        car.move(false);
        assertThat(car.getPosition()).isEqualTo(new Position(1));
    }
}