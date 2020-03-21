package RacingCarGameTests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

@DisplayName("레이싱 카 객체 테스트")
public class RacingCarTests {

    @DisplayName("차 생성 테스트")
    @Test
    public void generateCarTest() {
        assertThatCode(() -> RacingCar.newInstance()).doesNotThrowAnyException();
    }

    @DisplayName("차 이동 테스트")
    @ParameterizedTest(name = "랜덤 값 : {0} -> 결과 : {1}")
    @CsvSource({"0,0", "1,0", "2,0", "3,0", "4,1", "5,1", "6,1", "7,1", "8,1", "9,1"})
    public void moveCarTest(int randomValue, int expectedPosition) {
        RacingCar racingCar = RacingCar.newInstane();
        racingCar.moveWithRandomValue(randomValue);
        assertThat(racingCar.getPosition()).isEqualTo(expectedPosition);
    }

}
