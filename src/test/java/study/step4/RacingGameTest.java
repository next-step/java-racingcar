package study.step4;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingGameTest {

    @ParameterizedTest
    @DisplayName("RacingGame 메소드에 참여할 차들 이름 안 적을시 예외 발생 체크 메소드")
    @NullAndEmptySource
    void racingGameCarNamesValidateTest(String carNames){
        assertThatThrownBy(() ->{
            new RacingGame(carNames, 10);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("RacingGame 메소드에 참여횟수 1보다 작을시 예외 발생 체크 메소드")
    @ValueSource(ints = {-1, -2, 0})
    void racingGameTryNumberValidateTest(int tryTimes){
        assertThatThrownBy(() ->{
            new RacingGame("차1,차2,차3", tryTimes);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
