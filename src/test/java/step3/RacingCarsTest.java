package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarsTest {
    @ParameterizedTest
    @CsvSource(value = {"pobi,crong,honux : pobi,crong,choco"}, delimiter = ':')
    @DisplayName("자동차 게임에 참여하는 이름을 가진 자동차들이 비정상적으로 객체 생성 되었는지 확인합니다")
    void notReady(String initialCarNames, String compareCarCarNames) {
        assertThat(new RacingCars(initialCarNames.split(",")).equals(new RacingCars(compareCarCarNames.split(",")))).isFalse();
    }
}
