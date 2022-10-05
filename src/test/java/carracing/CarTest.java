package carracing;

import carracing.domain.Car;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    @Test
    void 자동차_처음위치는_0() {
        Car car = new Car("A");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차는_임계점미만이면_이동하지_않는다() {
        Car car = new Car("A");
        car.move(4);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차는_임계점이상이면_이동한다() {
        Car car = new Car("A");
        car.move(5);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차는_이름을_선언할_수_있다() {
        Car car = new Car("A");
        assertThat(car.getParticipantName()).isEqualTo("A");
    }
}
