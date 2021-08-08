package racingCar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCarTest {

    @DisplayName("차량 전진 테스트")
    @Test
    void 차량_전진_테스트() {
        RacingCar racingCar = new RacingCar("tesla");
        racingCar.goForward(4);
        assertThat(racingCar.getDrivenDistance()).isEqualTo(1);
    }

    @DisplayName("차량 정지 테스트")
    @Test
    void 차량_정지_테스트() {
        RacingCar racingCar = new RacingCar("tesla");
        racingCar.goForward(3);
        assertThat(racingCar.getDrivenDistance()).isEqualTo(0);
    }

    @DisplayName("차량 부분 전진 테스트")
    @Test
    void 차량_부분_전진_테스트() {
        RacingCar racingCar = new RacingCar("tesla");
        int[] numbers = new int[]{3, 3, 3, 4, 4};
        for (int i = 0; i < numbers.length; i++) {
            racingCar.goForward(numbers[i]);
        }
        assertThat(racingCar.getDrivenDistance()).isEqualTo(2);
    }

    @DisplayName("차량 생성시 상태 테스트")
    @Test
    void 차량_상태_출력() {
        RacingCar racingCar = new RacingCar("tesla",5);
        assertThat(racingCar.getDrivenDistance()).isEqualTo(5);
    }

    @DisplayName("차량 이름 설정 테스트")
    @Test
    void car_name_test() {
        RacingCar racingCar = new RacingCar("Tesla");
        assertThat(racingCar.getCarName()).isEqualTo("Tesla");
    }
}
