package racingcargamefinal.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    private final Car car = new Car("pobi");

    @Test
    void move() {
        Car movedCar = this.car.move(new MoveValue(4));
        assertThat(movedCar.getPosition()).isEqualTo(new Position(1));
    }

    @Test
    void moveFail() {
        Car unmovedCar = this.car.move(new MoveValue(3));
        assertThat(unmovedCar.getPosition()).isEqualTo(new Position(0));
    }

    @Test
    void findMaxPosition() {
        assertThat(car.findMaxPosition(new Position(3))).isEqualTo(new Position(3));
    }

    @Test
    void isWinner() {
        assertThat(car.isWinner(new Position(0))).isTrue();
        assertThat(car.isWinner(new Position(1))).isFalse();
    }

}
