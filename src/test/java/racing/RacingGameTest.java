package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.Cars;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static racing.UserInputException.isValidForNumber;

class RacingGameTest {

    private Car car;

    @BeforeEach
    void setCar() {
        car = new Car();
    }


    @Test
    @DisplayName("입력된 차 대수 만큼 차 리스트 생성")
    void createCars() {
        assertThat(new Cars(2).getCars().size()).isEqualTo(2);
    }

    @Test
    @DisplayName("자동차는 여러번 이동할 수 있다")
    void moveForTryCount() {
        int tryCount = 2;
        for (int i = 0; i < tryCount; i++) {
            car.move(4);
        }

        assertThat(car.getDistance()).isEqualTo(2);
    }

    @Test
    @DisplayName ("랜덤값이 4이상인 경우 전진(1)")
    void move() {
        car.move(4);
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName ("랜덤값이 3이하인 경우 멈춤(0)")
    void stop() {
        car.move(3);
        assertThat(car.getDistance()).isEqualTo(0);
    }

    @Test
    @DisplayName("[예외] 숫자 이외의 값을 전달하는 경우")
    void isNumber() {
        assertThatThrownBy(() -> isValidForNumber("#"))
                .isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("[예외] 음수를 전달하는 경우")
    void negative() {
        assertThatThrownBy(() -> isValidForNumber("-1"))
                .isInstanceOf(RuntimeException.class);
    }
}