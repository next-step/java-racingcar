package racingcar.domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CarTest {

    @Test
    @DisplayName("랜덤값이 4이상이면 달리기")
    void race_when_random_value_greater_then_4() throws Exception {
        //given
        Car car = new Car(new RandomNumber(4, 9));
        //when
        car.run();
        //then
        assertThat(car.distance()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤값이 3이하면 달리지 않기")
    void do_not_race_when_random_value_less_than_3() throws Exception {
        //given
        Car car = new Car(new RandomNumber(0, 3));
        //when
        car.run();
        //then
        assertThat(car.distance()).isZero();
    }

    @Test
    @DisplayName("자동차 달리기 판단 랜덤값의 범위가 9보다 크게 입력되면 Exception")
    void random_max_is_not_greater_than_9() {
        assertThatThrownBy(() -> new Car(new RandomNumber(0, 10)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("범위");
    }

    @Test
    @DisplayName("자동차 달리기 판단 랜덤값의 범위가 0보다 작게 입력되면 Exception")
    void random_min_is_not_less_than_0() {
        assertThatThrownBy(() -> new Car(new RandomNumber(-1, 8)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("범위");
    }

    @Test
    @DisplayName("그래프 그리기")
    void draw_graph() {
        //given
        Car car = new Car(new RandomNumber(4,9));
        //when
        car.run();
        car.run();
        //then
        assertThat(car.showDistanceGraph()).isEqualTo("--");
    }
}