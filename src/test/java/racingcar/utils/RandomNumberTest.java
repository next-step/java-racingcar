package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberTest {

    @Test
    @DisplayName("랜덤 숫자[0~9] 생성")
    void generateNumberBetween_zero_nine(){
        int result = RandomNumber.generate();
        assertThat(result).isBetween(0,9);
    }
}
