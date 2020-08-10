package carracing;

import carracing.domain.Car;
import carracing.domain.Game;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;

public class CarRacingTest {
    private Game game;

    @Test
    @DisplayName("입력값 inputValid() Exception")
    void Game_inputValid_테스트() {
        assertThatThrownBy(() -> new Game(0, 5))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Game(3, 0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("4 이상인경우 true 반환")
    void Car_isMove_테스트() {
        Car car = new Car(1);

        car.setPosition(1);
        assertThat(car.isMove()).isFalse();

        car.setPosition(4);
        assertThat(car.isMove()).isTrue();
    }
}
