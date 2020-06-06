package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParserUtilsTest {

    @DisplayName("정상적인 데이터")
    @Test
    void checkBlank() {
        String[] nameList = {"HO", "SOO", "RAM"};
        ParserUtils.checkBlank(nameList);
    }

    @DisplayName("비정상적인 데이터")
    @Test
    void checkBlankError() {
        String[] nameList = {"HO", "SOO", ""};
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ParserUtils.checkBlank(nameList));
    }
}