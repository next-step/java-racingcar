package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.racingcar.domain.CarName;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarNameTest {

    @DisplayName("자동차 이름이 5글자 초과 시 에러 테스트")
    @Test
    public void makeCarNameTest() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> new CarName("Animal"));
    }

}
