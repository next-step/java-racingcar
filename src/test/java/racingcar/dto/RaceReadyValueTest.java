package racingcar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RaceReadyValueTest {

    private static final String INPUT_CAR_NAMES = "jin,hyun,hwi,woong";
    private static final int TRY_COUNT = 5;

    @DisplayName("RaceReadyValue() 테스트 : carCount, tryCount 생성자 테스트")
    @Test
    void raceReadyValue1() {
        RaceReadyValue raceReadyValue = RaceReadyValue.of(INPUT_CAR_NAMES, TRY_COUNT);

        assertThat(raceReadyValue)
                .isEqualToComparingFieldByField(RaceReadyValue.of(INPUT_CAR_NAMES, TRY_COUNT));
    }

    @DisplayName("RaceReadyValue() 테스트 : 실패케이스 -> 자동차이름 5글자 초과한다면 에러 발생")
    @Test
    void raceReadyValue2() {
        String carName = "woojin,woong,hwi";

        assertThatIllegalArgumentException().isThrownBy(() -> {
            RaceReadyValue.of(carName, TRY_COUNT);
        });
    }

    @DisplayName("parseCarName() 테스트 : carNames 파싱 테스트")
    @Test
    void parseCarName() {
        RaceReadyValue raceReadyValue = RaceReadyValue.of(INPUT_CAR_NAMES, TRY_COUNT);

        assertThat(raceReadyValue.getCarNames()).contains("jin", "hyun", "hwi", "woong");
    }
}
