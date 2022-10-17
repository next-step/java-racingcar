package step4;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class CarTest {


    @Test
    void 차는_이름을_가질수있다() {
        String name = "이광규";
        Car car = new Car(name);
        assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    void 차는_1회_전진할수있다() {
        Car car = new Car("이광규");
        car.move();
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    void 게임을_1회_진행하면_거리는_1이하이다() {
        Car car = new Car("이광규");
        car.tryRound();
        assertThat(car.getDistance()).isLessThanOrEqualTo(1);
    }
}
