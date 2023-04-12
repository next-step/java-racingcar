package race;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import race.domain.Car;

@Disabled
class RacingTest {

    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @ParameterizedTest(name = "4 이상이 나올 경우 car가 움직인다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void test1(int input) throws Exception {
        car.move(input);

        assertThat(car.printDistance()).hasSize(1);
    }

    @ParameterizedTest(name = "3 이하가 나올 경우 car는 움직이지 않는다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void test2(int input) throws Exception {
        car.move(input);

        assertThat(car.printDistance()).isEmpty();
    }

    @DisplayName("5번 시도 중 3번 이상 4이상이 나오면 car가 움직인 거리는 3이다.")
    @Test
    void test10() throws Exception {
        int[] ints = {0, 3, 4, 5, 9};
        testCarMoving(ints);

        assertThat(car.printDistance()).hasSize(3);
    }

    private void testCarMoving(int[] ints) {
        for (int anInt : ints) {
            car.move(anInt);
        }
    }
}
