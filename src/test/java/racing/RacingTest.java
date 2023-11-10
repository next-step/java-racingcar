package racing;

/*
* 기능 요구사항
주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
전진하는 조건은 0에서 9 사이에서 random 값을 구한 후 random 값이 4이상일 경우이다.
자동차의 상태를 화면에 출력한다. 어느 시점에 출력할 것인지에 대한 제약은 없다.
* */

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static racing.InputView.*;
import static racing.Racing.*;

public class RacingTest {
    @DisplayName("자동차 대수와 이동 횟수는 자연수이고 2대 이상이어야 함")
    @ParameterizedTest
    @ValueSource(ints = {2, 3, 4, 5})
    void 입력값_확인(int input){
        assertThat(isCorrectInput(input)).isEqualTo(true);
    }

    @DisplayName("랜덤한 값이 0 ~ 9 사이어야 함")
    @Test
    void 이동횟수(){
        assertThat(checkMove()).isEqualTo(true);
    }
}
