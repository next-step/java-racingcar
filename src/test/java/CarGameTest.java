import game.CarGame;
import message.ExceptionMessage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarGameTest {

    private CarGame carGame;

    @BeforeEach
    void setCar() {
        carGame = new CarGame();
    }

    @DisplayName("입력받은 값만큼 자동차를 생성한다.")
    @Test
    void createCarTest() {
        carGame.createCar(3);
        assertThat(carGame.getCars()).hasSize(3);
    }

    @DisplayName("자동차를 생성할 시 1이하로 입력되면 예외를 발생시킨다.")
    @Test
    void carInputLessThanOneThrowException() {
        assertThatThrownBy(() -> carGame.createCar(1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.MINIMUN_CAR_EXCEPTION.message());
    }
}

