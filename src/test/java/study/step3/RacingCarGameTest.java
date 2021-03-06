package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    private RacingCar racingCar;
    private RandomGenerator randomGenerator;

    @BeforeEach
    void setup(){
        racingCar = new RacingCar();
        randomGenerator = new RandomGenerator();
    }

    @Test
    @DisplayName("랜덤 값 생성 범위가 0 ~ 9 맞는지 확인")
    void getRandomNumber(){
        assertThat(randomGenerator.getRandomNumber()).isLessThan(10);
        assertThat(randomGenerator.getRandomNumber()).isLessThanOrEqualTo(9);
        assertThat(randomGenerator.getRandomNumber()).isGreaterThan(-1);
        assertThat(randomGenerator.getRandomNumber()).isGreaterThanOrEqualTo(0);
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
