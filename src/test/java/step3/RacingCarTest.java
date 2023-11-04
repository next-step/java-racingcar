package step3;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @Test
    @DisplayName("사용자가 입력한 숫자만큼 자동차가 생성되야 한다.")
    void initCars_inputNumber() {
        RacingController racingController = new RacingController();
        assertThat(racingController.initCar(3)).hasSize(3);
    }

    @Test
    @DisplayName("생성된 자동차의 기본 포지션은 1 이어야 한다.")
    void initCar_position_is1() {
        Car car = new Car();
        assertThat(car.getPosition()).isEqualTo(1);
    }

}

/**
 * -[ ] 사용할 자동의 수를 입력 받는다.
 *   -[ ] 입력 받는 수는 정수만 가능하다.
 * -[ ] 몇번의 이동이 가능 할 것인지 입력 받는다.
 * -[ ] 자동차는 전진 또는 멈출 수 있다.
 *   -[ ] 자동차가 전진하려면 0~9 사이의 랜덤 값을 구한 후 4 이상인 경우다.
 *   -[ ] 랜덤값이 3이하인 경우는 자동차는 움직이지 않는다.
 * -[ ] 자동차의 상태를 화면에 출력한다.
 */
