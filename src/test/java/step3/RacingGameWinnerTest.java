package step3;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingGameWinnerTest {

    ValidationCheck validationCheck = new ValidationCheck();

    @BeforeEach
    void setUp() {
        System.out.println("!! SetUp !! ");
    }


    @DisplayName("입력하는 차량이름 Split 검증테스트")
    @Test
    void inputPlayerName() {
        assertThatIllegalArgumentException().isThrownBy(() -> validationCheck.checkInputPlayerName(""));
    }

    @DisplayName("입력하는 차량이름 Split 검증테스트")
    @Test
    void inputSplitName() {
        String[] inputName = null;
        assertThatIllegalArgumentException().isThrownBy(() -> validationCheck.checkInputSplitName(inputName));
    }

    @DisplayName("입력하는 게임시도 횟수 검증테스트")
    @Test
    void inputTryCountTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> validationCheck.checkInputTryCount(0));
    }

    @DisplayName("랜덤 값 범위 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 10, 4, 0, 99})
    void randomValueTest(int inputNum) {
        assertThatIllegalArgumentException().isThrownBy(() -> validationCheck.checkRandomValue(inputNum));
    }

    @DisplayName("전진 할 수 있는 값인지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 0, 4})
    void goTest(int inputNum) {
        assertThatIllegalArgumentException().isThrownBy(() -> validationCheck.checkGo(inputNum));
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }
}


