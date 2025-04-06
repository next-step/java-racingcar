import static org.assertj.core.api.Assertions.assertThat;

import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("기준값 보다 크면 1칸 이동한다")
    void moveBy_go() {
        final Car car = new Car("pobi");
        car.moveBy(5);
        assertThat(car.isPosition(1)).isTrue();
    }

    @Test
    @DisplayName("기준값 보다 작으면 이동하지 않는다")
    void moveBy_wait() {
        final Car car = new Car("pobi");
        car.moveBy(4);
        assertThat(car.isPosition(0)).isTrue();
    }

    @Test
    void nameOnlyConstructor() {
        assertThat(new Car("pobi")).isEqualTo(new Car("pobi", 0));
    }

    @Test
    void isPosition() {
        final Car car = new Car("pobi", 1);
        assertThat(car.isPosition(1)).isTrue();
        assertThat(car.isPosition(2)).isFalse();
    }
}
