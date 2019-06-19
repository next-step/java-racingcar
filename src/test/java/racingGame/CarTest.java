package racingGame;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingGame.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("jojo");
    }

    @Test
    void setCar() {
        int position = car.getPosition();
        assertThat(position).isEqualTo(0);
    }

    @Test
    void moveWithTrue() {
        car.move(true);
        assertThat(car.getPosition()).isEqualTo(1);
        car.move(true);
        assertThat(car.getPosition()).isEqualTo(2);
        car.move(true);
        assertThat(car.getPosition()).isEqualTo(3);
    }

    @Test
    void moveWithFalse() {
        car.move(false);
        assertThat(car.getPosition()).isEqualTo(0);
        car.move(false);
        assertThat(car.getPosition()).isEqualTo(0);
        car.move(false);
        assertThat(car.getPosition()).isEqualTo(0);
    }


    @Test
    void getRandomNumber() {
        int randomNumber = car.getRandomNumber();
        assertThat(randomNumber).isBetween(0, 9);
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

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void nextRaceNotMove(int randomNumber) {
        boolean isMoveCar = car.isMoveCar(randomNumber);
        car.move(isMoveCar);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {5, 6, 7, 8, 9})
    void nextRaceMove(int randomNumber) {
        boolean isMoveCar = car.isMoveCar(randomNumber);
        car.move(isMoveCar);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void setCarName() {
        assertThat(car.getName()).isEqualTo("jojo");
    }

    @Test
    void isWinner() {
        car.move(true);
        car.move(true);
        boolean isWin = car.isWinner(2);
        assertThat(isWin).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void getPosition(int time) {
        car.nextRace();
        car.nextRace();
        car.nextRace();
        car.nextRace();
        car.nextRace();
        int carPosition = car.getPosition(time - 1);
        assertThat(carPosition).isBetween(0, time);
    }
}