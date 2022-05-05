package racing.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    void 자동차_이동_숫자_4_미만() {
        Car car = new Car("car1");
        Position prevDistance = car.getPosition();
        int value = 3;

        car.move(value);

        assertThat(prevDistance).isEqualTo(car.getPosition());
    }

    @Test
    void 자동차_이동_숫자_4_이상() {
        Car car = new Car("car1");
        Position prevDistance = car.getPosition();
        int value = 4;

        car.move(value);

        assertThat(new Position(prevDistance.getValue()+1)).isEqualTo(car.getPosition());
    }


    @Test
    void 자동차_우승자_일때() {
        Position maxPosition = new Position(5);
        Car car = new Car("winner", new Position(5));

        assertThat(car.isWinner(maxPosition)).isTrue();
    }

    @Test
    void 자동차_우승자_아닐때() {
        Position maxPosition = new Position(5);
        Car car = new Car("winner", new Position(4));

        assertThat(car.isWinner(maxPosition)).isFalse();
    }
}