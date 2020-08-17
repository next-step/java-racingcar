package carracing;

import carracing.domain.Car;
import carracing.domain.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    private Game game;

    @Test
    @DisplayName("Car 객체 생성 후 position 설정")
    void Car_객체생성() {
        Car car = new Car(1);
        car.setPosition();
        assertThat(car.getPosition());

    }
}
