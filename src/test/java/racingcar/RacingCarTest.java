package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("0부터 9 사이 숫자가 아니면 에러를 발생시킨다.")
    public void 랜덤값_에러() {
        assertThatThrownBy(() -> new MoveStrategy(10))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("4 미만은는 전진할 수 없다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void 멈춤(int numbers) {
        final Car car = Car.create();
        MoveStrategy random = new MoveStrategy(numbers);
        car.move(random);

        assertThat(car.position()).isEqualTo(0);
    }

    @DisplayName("4 이상은 전진할 수 있다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 전진(int numbers) {
        final Car car = Car.create();
        MoveStrategy random = new MoveStrategy(numbers);
        car.move(random);

        assertThat(car.position()).isEqualTo(1);
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
