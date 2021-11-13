package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @DisplayName("Random 객체와 movement 초기값으로 Car 객체를 생성한다.")
    @Test
    public void create() {
        Random random = new Random();
        int movement = 0;
        Car car = new Car(random, movement);
        assertThat(car).isInstanceOf(Car.class);
        assertThat(car.getMovement()).isEqualTo(movement);
    }

    @DisplayName("Car의 increaseMovementRandomly 함수는 movement가 증가하지 않거나 range 중 랜덤으로 나온 숫자가 cutline보다 높으면 step만큼 증가한다.")
    @Test
    public void increaseMovementRandomly() {
        Random random = new Random();
        int movement = 0;
        int range = 10;
        int cutline = 4;
        int step = 3;
        Car car = new Car(random, movement);
        car.increaseMovementRandomly(range, cutline, step);
        assertThat(car.getMovement()).isIn(movement,step);
    }
}
