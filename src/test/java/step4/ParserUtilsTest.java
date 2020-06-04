package step4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

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