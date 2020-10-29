package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("입력된 문자열을 토큰으로 분리 클래스 테스트")
public class ExpressionTokenizerTest {
    private ExpressionTokenizer tokenizer = new ExpressionTokenizer();

    @Test
    @DisplayName("스페이스 기준으로 분리되는지 확인")
    public void seperateWithSpace() {
        String[] tokens = tokenizer.getTokens("1 2 3 4");

        assertThat(tokens).containsExactly("1", "2", "3", "4");
    }
}