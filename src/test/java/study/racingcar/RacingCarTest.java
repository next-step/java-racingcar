package study.racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import study.racingcar.entity.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    private RacingCar racingCar;

    @BeforeEach
    void setup(){
        racingCar = new RacingCar(0, "Test");
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:0", "2:0", "3:0" }, delimiter = ':')
    @DisplayName("값이 4 미만이면 정지 확인")
    void moveImPossible(Integer number, Integer expected){
        racingCar.oneStep(number);
        assertThat(racingCar.getPosition()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"4:1", "5:1", "6:1", "7:1", "8:1", "9:1" }, delimiter = ':')
    @DisplayName("값이 4 이상이면 1 전진 확인")
    void movePossible(Integer number, Integer expected){
        racingCar.oneStep(number);
        assertThat(racingCar.getPosition()).isEqualTo(expected);
    }
}
