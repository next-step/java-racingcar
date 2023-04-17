package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;


class SimpleRacingCarTest {

    @Test
    @DisplayName("사용자 입력값이 1이하인 경우 예외 발생")
    void numberInputCheck() {
        assertThatThrownBy(() -> InputView.inputCheck(-1))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    @DisplayName("입력한 자동차 대수와 생성된 자동차 대수 일치")
    void numberOfCarsCheck() {
        int inputCarCnt = 3;
        List<Car> createCarList = SimpleRacingCar.createCar(inputCarCnt,3);
        assertThat(createCarList.size()).isEqualTo(inputCarCnt);
    }

    @Test
    @DisplayName("생성된 자동차의 랜덤값 발생개수와 반복회수 일치")
    void generateRandomNumCheck() {
        int inputRepeatCnt = 3;
        List<Car> createCarList = SimpleRacingCar.createCar(1,inputRepeatCnt);
        assertThat(createCarList.get(0).carSpeed.length).isEqualTo(inputRepeatCnt);
    }
}