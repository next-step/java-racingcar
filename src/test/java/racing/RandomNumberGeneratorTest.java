package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import racing.domain.CarRandomNumberGenerator;
import racing.domain.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @RepeatedTest(10)
    @DisplayName("랜덤숫자 생성기로 0~9 사이의 랜덤 숫자 생성")
    void random_num() {
        RandomNumberGenerator randomNumberGenerator = new CarRandomNumberGenerator();
        int randomNum = randomNumberGenerator.getRandomNum();
        assertThat(randomNum).isBetween(0, 9);
    }

    @Test
    @DisplayName("테스트용 랜덤숫자 생성기로 정해진 숫자를 반환하기")
    void test_random_num() {
        RandomNumberGenerator randomNumberGenerator = new TestRandomNumberGenerator(5);
        int randomNum = randomNumberGenerator.getRandomNum();
        assertThat(randomNum).isEqualTo(5);
    }
}