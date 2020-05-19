package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("입력받는 게임스캐너 클래스 테스트")
class GameScannerTest {

    @ParameterizedTest
    @CsvSource(value = {" :false", "a:false", "e:false", "3:true"}, delimiter = ':')
    @DisplayName("입력 값이 숫자인지 체크가 올바른지 하는 테스트")
    void isIntegerMethodTest(String input, boolean expected) {
        assertThat(GameScanner.isInteger(input)).isEqualTo(expected);
    }

}