import static org.assertj.core.api.Assertions.*;

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
}
