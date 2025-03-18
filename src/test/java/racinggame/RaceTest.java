package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class RaceTest {

    private static final int INITIAL_CAR_POSITION = new Car().position();
    private static final int MIN_CARS = 1;
    private static final int MAX_CARS = 10;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        int randomNumberOfCars = new Random().nextInt(MAX_CARS) + MIN_CARS;
        cars = IntStream.range(0, randomNumberOfCars)
            .mapToObj(i -> new Car())
            .collect(Collectors.toList());
    }

    @Nested
    @DisplayName("주어진 횟수만큼 자동차의 위치를 전진시키거나 멈춘다.")
    class Racing {

        @DisplayName("전진 조건을 만족하지 않으면 자동차는 움직이지 않는다.")
        @Test
        void notMove() {
            Race race = new Race(cars, new FakeMoveStrategy(false));
            race.run(3);
            for (Car car : race.cars()) {
                assertThat(car.position()).isEqualTo(INITIAL_CAR_POSITION);
            }
        }

        @DisplayName("전진 조건을 만족하면 자동차는 경주 횟수만큼 움직인다.")
        @Test
        void move() {
            int rounds = 3;
            Race race = new Race(cars, new FakeMoveStrategy(true));
            race.run(rounds);
            for (Car car : race.cars()) {
                assertThat(car.position()).isEqualTo(INITIAL_CAR_POSITION + rounds);
            }
        }
    }
}
