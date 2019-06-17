package RacingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @Test
    void setCar() {
        int position = car.getPosition();
        assertThat(position).isEqualTo(0);
    }

    @Test
    void move() {
        car.move();
        assertThat(car.getPosition()).isEqualTo(1);
        car.move();
        assertThat(car.getPosition()).isEqualTo(2);
        car.move();
        assertThat(car.getPosition()).isEqualTo(3);
    }


    @Test
    void getRandomNumber() {
        int randomNumber = car.getRandomNumber();
        assertThat(randomNumber).isBetween(0, 9);
        System.out.println(randomNumber);
    }

    @Test
    void isMoveCar() {
        boolean isMoveCar = car.isMoveCar(1);
        assertThat(isMoveCar).isFalse();
        isMoveCar = car.isMoveCar(2);
        assertThat(isMoveCar).isFalse();
        isMoveCar = car.isMoveCar(3);
        assertThat(isMoveCar).isFalse();
        isMoveCar = car.isMoveCar(4);
        assertThat(isMoveCar).isFalse();
        isMoveCar = car.isMoveCar(5);
        assertThat(isMoveCar).isTrue();
        isMoveCar = car.isMoveCar(6);
        assertThat(isMoveCar).isTrue();
        isMoveCar = car.isMoveCar(7);
        assertThat(isMoveCar).isTrue();
        isMoveCar = car.isMoveCar(8);
        assertThat(isMoveCar).isTrue();
        isMoveCar = car.isMoveCar(9);
        assertThat(isMoveCar).isTrue();
    }
}