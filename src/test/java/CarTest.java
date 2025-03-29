import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    @DisplayName("Car 클래스 이름 테스트")
    public void testCarName() {
        assertThatThrownBy(
            () -> new Car("abcdef")
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("Car 클래스 순서 테스트")
    public void testCarPosition() {
        Car car1 = new Car("pobi", new Position(3));
        Car car2 = new Car("honux", new Position(2));
        Car car3 = new Car("brown", new Position(3));
        assertAll(
            () -> assertThat(car1.compareTo(car2)).isEqualTo(1),
            () -> assertThat(car1.compareTo(car3)).isEqualTo(0),
            () -> assertThat(car2.compareTo(car1)).isEqualTo(-1)
        );
    }

    @Test
    @DisplayName("자동차 이동 테스트")
    public void moveTest() {
        Car pobi = new Car("pobi", new Position(0));
        Car honux = new Car("honux", new Position(1));
        pobi.move(5);
        assertThat(pobi.compareTo(honux)).isEqualTo(0);
    }
}
