package game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class CarTest {
    @Test
    @DisplayName("자동차의 현재 위치를 나타내는 문자열 생성")
    public void currentPosition() {
        Car mySummerCar = new Car(5);

        assertThat(mySummerCar.getMoveTrajectory())
                .isEqualTo("-----");
    }

    @Test
    @DisplayName("자동차 움직이기 테스트")
    public void moveCar() {
        Car mySummerCar = new Car(1);

        mySummerCar.move(4);
        assertThat(mySummerCar.getPosition())
                .isEqualTo(5);

        mySummerCar.move(0);
        assertThat(mySummerCar.getPosition())
                .isEqualTo(5);

        mySummerCar.move(-2);
        assertThat(mySummerCar.getPosition())
                .isEqualTo(3);

        assertThatIllegalArgumentException().isThrownBy(() -> {
            mySummerCar.move(-5);
        });
    }
}
