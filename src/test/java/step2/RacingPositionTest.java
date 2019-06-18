package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingPositionTest {

    private Car car;
    private static final int INIT_RANDOMNUMBER = 1;

    @BeforeEach
    void init(){
        car = new Car();
        car.carPositionUpdate(INIT_RANDOMNUMBER);
    }

    @Test
    @DisplayName("0~10까지 랜덤 숫자 가져오기 테스트")
    void carPositionSatatusTest(){
        int randomNumber = Utils.createRandomNumber();
        assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    @DisplayName("입력 된 숫자에 따른 자동차 움직임 테스트 4보다 작을 경우 테스트")
    void carPositionUpdateValueDownTest() {
        int randomNumber = 3;
        car.carPositionUpdate(randomNumber);
        assertThat(car.lastCarPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("입력 된 숫자에 따른 자동차 움직임 테스트 4보다 크거나 같을 경우 테스트")
    void carPositionUpdateValueUpTest() {
        int randomNumber = 4;
        car.carPositionUpdate(randomNumber);
        assertThat(car.lastCarPosition()).isEqualTo(2);
    }

}
