package racing;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private static Car car;

    @BeforeAll
    public static void setUp() {
        car = new Car();
    }

    @DisplayName("Move 테스트")
    @Test
    public void moveTest() {
        int beforeLocationValue = car.getLocation().getValue();
        for (int moveValue = 0; moveValue < 100; moveValue++) { // moveValue만큼 이동 시킨 후 실제로 Location의 값이 변경 되었는지 테스트
            car.move(moveValue);
            assertThat(car.getLocation().getValue() - beforeLocationValue)
                    .isEqualTo(moveValue);
            beforeLocationValue = car.getLocation().getValue();
        }
    }
}