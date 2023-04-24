package race;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import race.domain.Car;
import race.util.Distance;

class RacingTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("name");
    }

    @ParameterizedTest(name = "4 이상이 나올 경우 car가 움직인다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void test1(int input) throws Exception {
        car.move(input);
        String result = Distance.get(car.getMovingDistance());

        assertThat(result).containsOnlyOnce("-");
    }

    @ParameterizedTest(name = "3 이하가 나올 경우 car는 움직이지 않는다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void test2(int input) throws Exception {
        car.move(input);
        String result = Distance.get(car.getMovingDistance());

        assertThat(result).doesNotContain("-");
    }

    @DisplayName("5번 시도 중 3번 이상 4이상이 나오면 car가 움직인 거리는 3이다.")
    @Test
    void test10() throws Exception {
        int[] ints = {0, 3, 4, 5, 9};
        Car movingCar = testCarMoving(ints);
        String result = Distance.get(movingCar.getMovingDistance());

        assertThat(result).containsOnlyOnce("---");
    }

    private Car testCarMoving(int[] ints) {
        Arrays.stream(ints).forEach(num -> car.move(num));
        return car;
    }
}
