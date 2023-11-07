package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private Car mySummerCar;

    @BeforeEach
    public void beforeEach() {
        mySummerCar = new Car(3);
    }

    @Test
    @DisplayName("자동차 전진 테스트")
    public void forwardCar() {
        mySummerCar.move(4);
        assertThat(mySummerCar.getPosition())
                .isEqualTo(7);
    }

    @Test
    @DisplayName("자동차 후진 테스트")
    public void backwardCar() {
        mySummerCar.move(-2);
        assertThat(mySummerCar.getPosition())
                .isEqualTo(1);
    }

    @Test
    @DisplayName("자동차 정차 테스트")
    public void stopCar() {
        mySummerCar.move(0);
        assertThat(mySummerCar.getPosition())
                .isEqualTo(3);
    }

    @Test
    @DisplayName("불가능한 위치 이동 테스트")
    public void unrealisticMove() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            mySummerCar.move(-5);
        });
    }
}
