package step3.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    Car 한칸_움직인_차 = new Car();

    @BeforeEach
    void init() {
        한칸_움직인_차.move(4);
    }

    @Test
    @DisplayName("4이상의 값을 얻으면 차는 한칸씩 전진한다.")
    void 차는_한칸씩_전진한다() {
        Car car = new Car();
        car.move(5);
        assertThat(car.getMovingDistance()).isEqualTo("-");
    }

    @Test
    @DisplayName("4를 받아도 차는 한칸 이동한다. ")
    void 차는_4_를_얻어도_한칸_이동한다() {
        Car car = new Car();
        car.move(4);
        assertThat(car.getMovingDistance()).isEqualTo("-");
    }

    @Test
    @DisplayName("4미만을 받으면 찾는 움직이지 않는다.")
    void 차는_4미만의_값을_얻으면_이동하지_않는다() {
        Car car = new Car();
        car.move(3);
        assertThat(car.getMovingDistance()).isEqualTo("");
    }

    @Test
    @DisplayName("기존에 한칸 이동한 차량은 4이상의 값을 얻으면 한칸 더 이동한다. ")
    void 기존에_전진한_차량은_4이상의_값을_얻으면_한칸_더_이동한다() {
        한칸_움직인_차.move(4);
        assertThat(한칸_움직인_차.getMovingDistance()).isEqualTo("--");
    }

}