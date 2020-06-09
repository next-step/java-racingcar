package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class ValidTest {

    @DisplayName("자동차 이름이 모두 정상적으로 입력됬을때")
    @Test
    void checkBlank() {
        String[] nameList = {"HO", "SOO", "RAM"};
        Valid.checkEmptyOrBlank(nameList);
    }

    @DisplayName("자동차 이름중 공백이 있을때 에러 발생")
    @Test
    void checkWhiteSpaceError() {
        String[] nameList = {"HO", "SOO", " "};
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Valid.checkEmptyOrBlank(nameList));
    }

    @DisplayName("자동차 이름중 비어있는 값이 있을때 에러 발생")
    @Test
    void checkEmptyError() {
        String[] nameList = {"HO", "SOO", ""};
        assertThatIllegalArgumentException()
                .isThrownBy(() -> Valid.checkEmptyOrBlank(nameList));
    }
}