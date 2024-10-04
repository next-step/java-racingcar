package stydy.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import study.racing.RacingCar;
import study.racing.ResultView;
import study.utils.NumberUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @DisplayName("랜덤값 < 10")
    @RepeatedTest(10)
    public void repeatedTest() {
        int randomNumber = NumberUtils.randomNumberUnder10();
        assertThat(randomNumber).isBetween(0, 9);
    }

    @Test
    @DisplayName("전진 멈춤 테스트 : 전진 -> 1 , 멈춤 -> 0")
    public void goAndStop() {
        int forwardNumber = RacingCar.goAndStop();
        assertThat(forwardNumber).isBetween(0,1);
    }

   @Test
   @DisplayName("자동차 경주가 잘 출력되는지 확인")
   public void racing() {
       ResultView.resultView();
   }
}
