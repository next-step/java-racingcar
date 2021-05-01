import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class CarRacingGameVOTest {

    @DisplayName("racingLeap 변수의 getter, setter 작동 확인")
    @Test
    void testRacingLeapGetterSetter() {
        CarRacingGameVO carRacingGameVO = new CarRacingGameVO();

        carRacingGameVO.setRacingLeap(5);
        assertThat(carRacingGameVO.getRacingLeap()).isNotNull().isNotZero().
                isPositive().isEqualTo(5);
    }

    @DisplayName("carNameLengthLimit 변수의 getter 작동 확인")
    @Test
    void getCarNameLengthLimitTest() {
        CarRacingGameVO carRacingGameVO = new CarRacingGameVO();

        assertThat(carRacingGameVO.getCarNameLengthLimit()).isNotNull().isNotZero().
                isPositive().isEqualTo(5);
    }

    @DisplayName("carForwardStopRandomBound 변수의 getter 작동 확인")
    @Test
    void getCarForwardStopRandomBoundTest() {
        CarRacingGameVO carRacingGameVO = new CarRacingGameVO();

        assertThat(carRacingGameVO.getCarForwardStopRandomBound()).isNotNull().isNotZero().
                isPositive().isEqualTo(10);
    }

    @DisplayName("carForwardLimit 변수의 getter 작동 확인")
    @Test
    void getCarForwardLimitTest() {
        CarRacingGameVO carRacingGameVO = new CarRacingGameVO();

        assertThat(carRacingGameVO.getCarForwardLimit()).isNotNull().isNotZero().
                isPositive().isEqualTo(4);
    }

    @DisplayName("carNameSplitDelimiter 변수의 getter 작동 확인")
    @Test
    void getCarNameSplitDelimiterTest() {
        CarRacingGameVO carRacingGameVO = new CarRacingGameVO();

        assertThat(carRacingGameVO.getCarNameSplitDelimiter()).isNotNull().isEqualTo(",");
    }
}