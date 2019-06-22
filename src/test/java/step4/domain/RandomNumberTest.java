package step4.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class RandomNumberTest {

    @Test
    void 랜덤으로_0과_9사이의_숫자가_생성된다() {
        int generatedNumber = RandomNumber.generate().getRandomNumber();
        assertThat(generatedNumber).isBetween(RandomNumber.ZERO, RandomNumber.LIMIT);
    }

    @Test
    void 랜덤숫자가_0보다작고_9보다크면_예외가_발생한다() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    new RandomNumber(-1);
                }).withMessageContaining("랜덤 숫자가 잘못 생성되었습니다.");
    }
}
