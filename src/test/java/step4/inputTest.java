package step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.domain.Data;
import step4.util.InputValidator;

public class inputTest {

    @ParameterizedTest
    @DisplayName("이름 입력 테스트")
    @ValueSource(strings = {"bob,test", "weifjwief", "a"})
    public void inputCarCountTest(String names) {
        InputValidator.validate(new Data(names));
    }

}
