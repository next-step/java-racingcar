package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.Car;
import racing.domain.strategy.MoveStrategy;


import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    private final MoveStrategy alwaysTrueStrategy = () -> true;

    private final String testName = "test";

    @Test
    @DisplayName("getPosition() - Car의 위치를 int로 반환")
    void getPosition() {
        Car car = Car.from(testName);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("getName() - Car의 이름을 문자열로 반환")
    void getName() {
        Car car = Car.from(testName);
        assertThat(car.getName()).isEqualTo(testName);
    }

    @Test
    @DisplayName("maxPosition 호출 시 넘어오는 정수와 자동차의 Positon을 비교하여 높은 정수 반환")
    void maxPosition() {
        Car car = movedCar(2);

        assertThat(car.maxPosition(3)).isEqualTo(3);
        assertThat(car.maxPosition(2)).isEqualTo(2);
        assertThat(car.maxPosition(1)).isEqualTo(2);
    }

    @Test
    @DisplayName("play() - MoveStrategy의 movable()이 true이면 전진")
    void play() {
        Car car1 = Car.from(testName);
        car1.play(alwaysTrueStrategy);
        car1.play(alwaysTrueStrategy);

        Car car2 = Car.from("nimoh");
        car2.play(alwaysTrueStrategy);
        car2.play(alwaysTrueStrategy);

        Car car3 = Car.from("pobi");
        car3.play(alwaysTrueStrategy);

        assertThat(car1).isEqualTo(car2);
        assertThat(car1).isNotEqualTo(car3);

    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("samePosition() - Car의 위치가 동일한 경우 true 반환")
    void samePosition_same(int input) {
        Car car = movedCar(input);

        assertThat(car.samePosition(input)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("samePosition() - Car의 위치가 다른 경우 false 반환")
    void samePosition_diff(int input) {
        Car car = movedCar(input);

        assertThat(car.samePosition(input + 1)).isFalse();
    }

    private Car movedCar(int moveCount) {
        Car car = Car.from(testName);
        for (int i = 0; i < moveCount; i++) {
            car.play(alwaysTrueStrategy);
        }
        return car;
    }

}