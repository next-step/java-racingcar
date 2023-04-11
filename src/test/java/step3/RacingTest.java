package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


class RacingTest {


    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
    }

    @DisplayName("입력받은 개수에 따라 car 객체를 생성한다.")
    @Test
    void test4() throws Exception {
        int count = 3;
        RacingCar racingCar = new RacingCar(count);

        assertThat(racingCar.getList()).hasSize(count);
    }

    @DisplayName("입력받은 횟수에 만큼 시도한다.")
    @Test
    void test7() throws Exception {
        int trial = 4;
        Race race = new Race(1, trial);

        assertThat(race.getTrial()).isEqualTo(trial);
    }

    @ParameterizedTest(name = "4 이상이 나올 경우 car가 움직인다.")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void test1(int input) throws Exception {
        car.move(input);

        assertThat(car.getDistance()).hasSize(1);
    }

    @ParameterizedTest(name = "3 이하가 나올 경우 car는 움직이지 않는다.")
    @ValueSource(ints = {0, 1, 2, 3})
    void test2(int input) throws Exception {
        car.move(input);

        assertThat(car.getDistance()).isEmpty();
    }

    @DisplayName("5번 시도 중 3번 이상 4이상이 나오면 car가 움직인 거리는 3이다.")
    @Test
    void test10() throws Exception {
        int[] ints = {0, 3, 4, 5, 9};
        testCarMoving(ints);

        assertThat(car.getDistance()).hasSize(3);
    }

    @DisplayName("자동차 개수가 0 이하로 입력되면 예외가 발생한다.")
    @Test
    void test5() throws Exception {
        assertThatThrownBy(() ->
            new Race(0, 1)
        )
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("1 이상을 입력해 주세요");
    }

    @DisplayName("시도 횟수가 0 이하로 입력되면 예외가 발생한다.")
    @Test
    void test6() throws Exception {
        assertThatThrownBy(() ->
            new Race(1, 0)
        )
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("1 이상을 입력해 주세요");
    }

    @DisplayName("시도 횟수와 자동차 개수가 1이상이면 예외가 발생하지 않는다.")
    @Test
    void test8() throws Exception {
        assertThatCode(() -> new Race(1, 1)).doesNotThrowAnyException();
    }

    private void testCarMoving(int[] ints) {
        for (int anInt : ints) {
            car.move(anInt);
        }
    }
}
