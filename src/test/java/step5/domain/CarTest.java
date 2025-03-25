package step5.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void 기본값은_위치_0() {
        Car car = new Car(new CarName("1"));
        assertThat(car).isEqualTo(new Car(new CarName("1"), new Position(0)));
    }

    @Test
    void 전진할_수_있다면_1칸_전진한다() {
        Car car = new Car(new CarName("1"), new Position(0));
        car.move(() -> true);
        assertThat(car).isEqualTo(new Car(new CarName("1"), new Position(1)));
    }

    @Test
    void 전진할_수_없다면_전진하지_않는다() {
        Car car = new Car(new CarName("1"), new Position(0));
        car.move(() -> false);
        assertThat(car).isEqualTo(new Car(new CarName("1"), new Position(0)));
    }

    @Test
    void Position이_더_크면_더_큰_Car() {
        Car car1 = new Car(new Position(1));
        Car car2 = new Car(new Position(0));
        assertThat(car1).isGreaterThan(car2);
    }
}
