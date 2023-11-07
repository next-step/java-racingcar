package step3.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    @DisplayName("자동차가 움직이면 -로 측정한다.")
    void 자동차가_전진하면_bar로_측정한다() {
        Car car = new Car();
//        Assertions.assertThat(car.moving(new Moving())).isEqualTo("-");
    }

    @Test
    @DisplayName("4이상의 값을 얻으면 차는 한칸씩 전진한다.")
    void 차는_한칸씩_전진한다() {
        Car car = new Car();
        car.move(5);
        Assertions.assertThat(car.getMovingDistance()).isEqualTo("-");
    }

    @Test
    @DisplayName("4를 받아도 차는 한칸 이동한다. ")
    void 차는_4_를_얻어도_한칸_이동한다() {
        Car car = new Car();
        car.move(4);
        Assertions.assertThat(car.getMovingDistance()).isEqualTo("-");
    }

}