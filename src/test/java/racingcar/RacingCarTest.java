package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @Test
    @DisplayName("0부터 9 사이의 random 값을 구할 수 있다.")
    public void randomBetween_0_And_9() {
        Random random = new Random();
        final int i = random.nextInt(10);

        assertThat(i).isBetween(0, 10);
    }

    @Test
    @DisplayName("특정 개수만큼 자동차를 생성할 수 있다.")
    public void createCarByNumber() {
        final int number = 3;
        final List<Car> cars = createCars(number);

        assertThat(number).isEqualTo(cars.size());
    }

    @Test
    @DisplayName("자동차의 moveCount 를 증가시킬 수 있다.")
    public void canMove() {
        final int number = 3;
        final List<Car> cars = createCars(number);

        for (final Car car : cars) {
            if (Racing.canMove()) {
                car.move();
            }
            System.out.println(car.getMoveCount());
        }

    }

    private List<Car> createCars(final int number) {
        List<Car> cars = new ArrayList<>();

        for (int i = 0; i < number; i++) {
            final Car car = Car.create();
            cars.add(car);
        }
        return cars;
    }
}
