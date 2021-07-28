package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    @DisplayName("차량 전진 테스트")
    @Test
    void 차량_전진_테스트() {
        RacingCar racingCar = new RacingCar();
        assertThat(racingCar.showDrivenDistance()).isEqualTo(0);
        racingCar.goForward();
        assertThat(racingCar.showDrivenDistance()).isEqualTo(1);
    }

    @DisplayName("랜덤으로 생성된 수가 0, 9 사이에 있는지 테스트")
    @Test
    void 랜덤_값_생성() {
        for (int i = 0; i < 20; i++) {
            assertThat(RandomNumberGenerator.getRandomNumber()).isBetween(0,9);
        }
    }

    @DisplayName("전진 가능한 숫자인지 판단하는 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:false", "4:true", "9:true"}, delimiter = ':')
    void 전진_여부_판단(int number, boolean expect) {
        assertThat(RacingManager.isMovableNumber(number)).isEqualTo(expect);
    }

   @Test
    void 차량_상태_출력() {

    }

}
