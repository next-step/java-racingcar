package study.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MoveCheckerTest {


    @ParameterizedTest
    @CsvSource(value = {"1:false", "4:true"}, delimiter = ':')
    @DisplayName("이동불가능 값(1) , 이동 가능값(4) 에대한 테스트 ")
    void canMoveForwardTest(int input, boolean excepted) {
        assertThat(MoveChecker.canMoveForward(input)).isEqualTo(excepted);
    }
}