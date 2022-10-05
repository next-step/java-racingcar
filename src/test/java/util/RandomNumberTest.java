package util;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RandomNumberTest {
    @RepeatedTest(10)
    @DisplayName("언제나 0~9 사이의 숫자가 생성되는지 확인")
    public void randomNumberTest() {
        assertThat(RandomNumber.generate()).isBetween(0, 9);
    }
}
