package game;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    @Test
    @DisplayName("자동차의 현재 위치를 나타내는 문자열 생성")
    public void currentPosition() {
        Car mySummerCar = new Car(5);

        assertThat(mySummerCar.getMoveTrajectory())
                .isEqualTo("-----");
    }
}
