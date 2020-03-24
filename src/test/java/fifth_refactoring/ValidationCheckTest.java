package fifth_refactoring;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidationCheckTest {

    private CheckValidation checkValidation = new CheckValidation();

    @ParameterizedTest
    @ValueSource( ints = {-1 , 0})
    @DisplayName("1이하 벨리데이션체크")
    void valdationTryNumberErrorTest(int testInput){
        assertThatThrownBy(()  -> {
            checkValidation.validateTryNumber(testInput);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("1 이상의 숫자를 입력하세요");
    }

    @ParameterizedTest
    @ValueSource( ints = {1, 3})
    @DisplayName("정상값 벨리데이션체크")
    void valdationTryNumberNormalTest(int testInput){
        assertThat(checkValidation.validateTryNumber(testInput)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(strings = {" "})
    @DisplayName("빈값테스트")
    void valdationCarNameTest(String input) {
        assertThatThrownBy(()  -> {
            checkValidation.validateCarName(input);
        }).isInstanceOf(IllegalArgumentException.class).hasMessageContaining("공백금지");
    }
}
