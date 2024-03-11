package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.domain.RandomValueGenerator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RandomValueGeneratorTest {

    @Test
    @DisplayName("[성공] 0~9 사이의 랜덤한 값을 생성한다.")
    void 랜덤값_생성() {
        assertThat(RandomValueGenerator.generate()).isBetween(0, 9);
    }

    @Nested
    @DisplayName("[학습 테스트]")
    class LearningTest {

        @Test
        @DisplayName("[학습 테스트] AssertJ.isBetween() 경계값")
        void isBetween_메서드_경계값() {
            assertThat(0).isBetween(0, 9);
            assertThat(9).isBetween(0, 9);

            assertThatThrownBy(() -> {
                assertThat(-1).isBetween(0, 9);
            }).isInstanceOf(AssertionError.class);
            assertThatThrownBy(() -> {
                assertThat(10).isBetween(0, 9);
            }).isInstanceOf(AssertionError.class);
        }

    }
}
