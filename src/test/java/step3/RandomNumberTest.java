package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberTest {

    @Test
    @DisplayName("10 미만 랜덤값 생성 테스트")
    @RepeatedTest(1000)
    void randomNumberTest() {
        RandomNumber randomNumber = new RandomNumber();
        assertThat(randomNumber.randomNumber() < 10).isTrue();
    }
}