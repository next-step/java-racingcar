package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.security.InvalidParameterException;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class RandomNoTest {

    @DisplayName("제한숫자 초과시 에러발생 체크")
    @Test
    void 최대값체크() {
        assertThatThrownBy(()->new RandomNo(11)).isInstanceOf(InvalidParameterException.class);
    }

    @DisplayName("제한숫자보다 부족할시 에러발생 체크")
    @Test
    void 최저값체크() {
        assertThatThrownBy(()->new RandomNo(-1)).isInstanceOf(InvalidParameterException.class);
    }


    @DisplayName("숫자 비교로직 체크")
    @Test
    void 숫자비교() {
        RandomNo randomNo = new RandomNo(5);
        assertThat(randomNo.isEqualOrOver(5)).isTrue();
        assertThat(randomNo.isEqualOrOver(6)).isFalse();
    }


}