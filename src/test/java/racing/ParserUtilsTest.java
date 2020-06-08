package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class ParserUtilsTest {

    @DisplayName("자동차 이름이 모두 정상적으로 입력됬을때")
    @Test
    void checkBlank() {
        String[] nameList = {"HO", "SOO", "RAM"};
        ParserUtils.checkEmptyOrBlank(nameList);
    }

    @DisplayName("마지막 자동차 이름이 공백일때")
    @Test
    void checkWhiteSpaceError() {
        String[] nameList = {"HO", "SOO", " "};
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ParserUtils.checkEmptyOrBlank(nameList));
    }

    @DisplayName("마지막 자동차 이름을 입력하지 않았을때")
    @Test
    void checkEmptyError() {
        String[] nameList = {"HO", "SOO", ""};
        assertThatIllegalArgumentException()
                .isThrownBy(() -> ParserUtils.checkEmptyOrBlank(nameList));
    }
}