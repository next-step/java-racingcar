package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    private RacingCar racingCar;
    private CarName name;

    @BeforeEach
    void init() {
        name = new CarName("ruby");
    }

    @ParameterizedTest
    @CsvSource(value = {"1:0", "3:0", "4:1", "9:1"}, delimiter = ':')
    @DisplayName("전진하는 조건(random 값이 4이상)에서 전진하고 이동 횟수가 소진되면 멈추는 경주용 자동차 생성")
    void checkAdvancedCondition(int randomNumber, int expected) {
        racingCar = new RacingCar(1, name);
        racingCar.checkAdvancedCondition(randomNumber);
        assertThat(racingCar.getAdvancedCount()).isEqualTo(expected);
    }

    @Test
    @DisplayName("전진하는 조건이 없을 경우 테스트")
    void raceNotAdvanced() {
        racingCar = new RacingCar(3, name);
        Arrays.asList(1, 2, 3).forEach(racingCar::checkAdvancedCondition);
        assertThat(racingCar.getAdvancedCount()).isEqualTo(0);
    }

    @Test
    @DisplayName("전진하는 조건이 있을 경우 테스트")
    void raceAdvanced() {
        racingCar = new RacingCar(3, name);
        Arrays.asList(1, 4, 9).forEach(racingCar::checkAdvancedCondition);
        assertThat(racingCar.getAdvancedCount()).isEqualTo(2);
    }

}
