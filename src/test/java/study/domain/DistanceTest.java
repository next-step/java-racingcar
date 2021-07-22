package study.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import study.calculator.Common;

import static org.assertj.core.api.Assertions.assertThat;
import static study.calculator.Common.toInt;

class DistanceTest {

    @ParameterizedTest
    @CsvSource({"1,1","2,2","3,3","4,4","5,5"})
    void 거리입력(String input, String expected) {

        Distance distance = new Distance(toInt(input));
        assertThat(distance.getMove()).isEqualTo(toInt(expected));
    }

    @DisplayName("파라메터값이 4이상인지 체크 테스트")
    @ParameterizedTest
    @ValueSource(ints = {9,1,3,5,4})
    void 선택된랜덤값이4이상인지체크테스트(int value) {

        if(Common.checkMoveable(value)){
            assertThat(value).isGreaterThan(3);
            assertThat(Common.checkMoveable(value)).isTrue();
        }
    }

    @DisplayName("전진가능여부 판별값을 통해 거리1증가 테스트.")
    @Test
    void 거리1전진테스트() {
        Distance distance = new Distance();
        distance.move();
        assertThat(distance.getMove()).isEqualTo(1);
    }
}