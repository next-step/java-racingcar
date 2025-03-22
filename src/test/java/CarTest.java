import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {
    @Test
    @DisplayName("기준값 보다 크면 1칸 이동한다")
    void moveBy_go() {
        final Car car = new Car();
        car.moveBy(5);
        assertThat(car.isPosition(1)).isTrue();
    }

    @Test
    @DisplayName("기준값 보다 작으면 이동하지 않는다")
    void moveBy_wait() {
        final Car car = new Car();
        car.moveBy(4);
        assertThat(car.isPosition(0)).isTrue();
    }
}
