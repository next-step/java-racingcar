package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

@DisplayName("랜덤 숫자 생성기 테스트")
public class NumberGeneratorTest {

    @DisplayName("랜덤 숫자를 생성하지 않은 상태에서 조회하면, IllegalStateException이 발생한다.")
    @Test
    public void getNotGeneratedNumberExceptionTest() {
        // given
        NumberGenerator numberGenerator = new NumberGenerator();

        // when, then
        assertThatIllegalStateException()
                .isThrownBy(() -> numberGenerator.getNumber())
                .withMessage("Number가 생성되지 않았습니다.");
    }
}
