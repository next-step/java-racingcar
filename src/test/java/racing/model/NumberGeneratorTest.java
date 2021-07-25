package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("랜덤 숫자 생성기 테스트")
public class NumberGeneratorTest {

    @DisplayName("0에서 9사이의 랜덤 자연수를 생성한다.")
    @Test
    public void generateRandomNumberTest() {
        // given
        NumberGenerator numberGenerator = new NumberGenerator();

        for (int i = 0; i < 10; i++) {
            // when
            numberGenerator.generateRandomNumber();

            // then
            assertThat(numberGenerator.getNumber())
                    .isGreaterThanOrEqualTo(0)
                    .isLessThanOrEqualTo(9);
        }
    }
}
