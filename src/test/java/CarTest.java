import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("자동차 객체 생성 테스트")
    void carConstructor() {
        final Car car = new Car("pobi");
        final int position = car.getPosition();
        final String name = car.getName();
        assertThat(car.getPosition()).isEqualTo(position);
        assertThat(car.getName()).isEqualTo(name);
    }
}
