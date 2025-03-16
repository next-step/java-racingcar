package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class RacingCarTest {

    public static final int CAR = 5;

    @Test
    public void validateInput_0보다큰수만입력가능() {
        assertThatThrownBy(() -> RacingCar.validateInput(0,0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void getCars_car크기확인() {
        Car[] cars = RacingCar.getCars(CAR);
        assertThat(cars.length).isEqualTo(CAR);
    }

    @Test
    public void moveCar_초기화(){
        Car[] cars = RacingCar.getCars(CAR);
        RacingCar.moveCar(cars);

        for (Car car : cars) {
            assertThat(car.getMoveCount()).isEqualTo(1);
        }
    }


    @Test
    public void getRandom_0과9사이의숫자() {
        int result = RacingCar.getRandomNumber();
        assertTrue(result >= 0 && result <= 9, "값은 0과 9 사이여야 합니다.");
    }
}
