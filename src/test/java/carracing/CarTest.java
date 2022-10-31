package carracing;

import carracing.domain.Car;
import carracing.domain.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    void 최댓값_구하기() {
        Car car = new Car("pobi",new Position(3));
        assertThat(car.getBiggerPosition(4)).isEqualTo(4);
    }

    @Test
    void 최댓값_일치() {
        Car car = new Car("pobi", new Position(3));
        assertThat(car.checkHasPosition(3)).isTrue();
        assertThat(car.checkHasPosition(2)).isFalse();
    }

    @Test
    void 자동차_처음위치는_0() {
        Car car = new Car("A");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차는_임계점미만이면_이동하지_않는다() {
        Car car = new Car("A");
        car.move(() -> false);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차는_임계점이상이면_이동한다() {
        Car car = new Car("A");
        car.move(() -> true);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    void 자동차는_이름을_선언할_수_있다() {
        Car car = new Car("A");
        assertThat(car.getName()).isEqualTo("A");
    }
}