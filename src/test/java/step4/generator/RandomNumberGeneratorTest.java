package step4.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RandomNumberGeneratorTest {

    @DisplayName("generateRandomNumber() 메서드가 일정 범위의 값을 반환하는지 테스트")
    @RepeatedTest(value = 10, name = "현재 Loop : {0}")
    void nextInt_RandomValue_True() {
        // given
        RandomNumberGenerator generator = RandomNumberGenerator.getInstance();

        // when
        int actual = generator.generateRandomNumber();

        // then
        assertAll(
                () -> assertThat(actual).isIn(0, 1, 2, 3, 4, 5, 6, 7, 8, 9),
                () -> assertThat(actual).isNotIn(-1, 10),
                () -> assertThat(actual).isBetween(0, 9)
        );
    }

}