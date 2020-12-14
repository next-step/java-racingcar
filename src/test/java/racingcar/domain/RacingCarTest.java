package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    private RacingCar racingCar;

    @ParameterizedTest
    @CsvSource(value = {"1:0", "3:0", "4:1", "9:1"}, delimiter = ':')
    @DisplayName("전진하는 조건(random 값이 4이상)에서 전진하고 이동 횟수가 소진되면 멈추는 경주용 자동차 생성")
    void checkAdvancedCondition(int randomNumber, int expected) {
        racingCar = new RacingCar();
        racingCar.race(new RandomNumber(randomNumber));
        assertThat(racingCar.getAdvancedCount()).isEqualTo(expected);
    }

    @Test
    @DisplayName("전진하는 조건이 없을 경우(램덤숫자 1, 2, 3) 테스트")
    void raceNotAdvanced() {
        racingCar = new RacingCar();
        racingCar.race(new RandomNumber(1));
        racingCar.race(new RandomNumber(2));
        racingCar.race(new RandomNumber(3));
        assertThat(racingCar.getAdvancedCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("전진하는 조건이 있을 경우(랜덤숫자 1, 4, 9) 테스트")
    void raceAdvanced() {
        racingCar = new RacingCar();
        racingCar.race(new RandomNumber(1));
        racingCar.race(new RandomNumber(4));
        racingCar.race(new RandomNumber(9));
        assertThat(racingCar.getAdvancedCount()).isEqualTo(2);
    }

}
