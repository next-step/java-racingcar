package racinggame;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RaceTest {

    private List<Car> carList;

    @BeforeEach
    void setUp() {
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        carList = new ArrayList<>(List.of(car1, car2, car3, car4));
    }

    @Nested
    @DisplayName("주어진 횟수만큼 자동차의 위치를 전진시키거나 멈춘다.")
    class Racing {

        @DisplayName("랜덤 값이 4 미만일 때 자동차는 움직이지 않는다.")
        @ParameterizedTest
        @ValueSource(ints = {3})
        void notMove(int rounds) {
            Race race = new Race(carList, new FakeRandomGenerator(3));
            race.run(rounds);
            for (Car car : race.cars()) {
                assertThat(car.position()).isEqualTo(1);
            }
        }

        @DisplayName("랜덤 값이 4 이상일 때 자동차는 횟수만큼 움직인다.")
        @ParameterizedTest
        @ValueSource(ints = {3})
        void move(int rounds) {
            Race race = new Race(carList, new FakeRandomGenerator(4));
            race.run(rounds);
            for (Car car : race.cars()) {
                assertThat(car.position()).isEqualTo(4);
            }
        }
    }
}
