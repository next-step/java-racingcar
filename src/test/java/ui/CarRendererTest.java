package ui;

import game.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRendererTest {
    @Test
    @DisplayName("자동차의 현재 위치를 나타내는 문자열 생성")
    public void currentPosition() {
        Car mySummerCar = new Car(5);

        assertThat(CarRenderer.getMoveTrajectory(mySummerCar))
                .isEqualTo("-----");
    }
}
