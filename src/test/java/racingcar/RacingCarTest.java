package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingCarTest {

    @Test
    @DisplayName("자동차 경주 테스트")
    void startRace() {
        RacingCar.race(3, 5);
    }

    @Test
    @DisplayName("자동차 번호 전달 시 차가 앞으로 전진한다.")
    void run() {
        assertThat(RacingCar.run("--")).isNotEqualTo("--");
    }

    @Test
    @DisplayName("0 ~ 9 사이의 랜덤값을 생성한다.")
    void 랜덤값_생성() {
        assertThat(RacingCar.generateRandomNumber()).isBetween(0, 9);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:false", "3:false", "4:true", "9:true"}, delimiter = ':')
    @DisplayName("4 이상의 숫자일 때 true를 반환한다.")
    void 숫자_4이상_조건_확인(int number, boolean expected) {
        assertThat(RacingCar.checkGreaterThanOrEqualToFour(number)).isEqualTo(expected);
    }


}