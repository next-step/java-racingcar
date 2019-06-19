package step2;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

    ValidationCheck validationCheck = new ValidationCheck();

    @BeforeEach
    void setUp() {
        System.out.println("!! SetUp !! ");
    }

    @DisplayName("입력하는 차 수량 검증테스트")
    @Test
    void inputCarNumber() {
        assertThatIllegalArgumentException().isThrownBy(() -> validationCheck.checkInputCarNumber(0));
    }

    @DisplayName("입력하는 게임시도 횟수 검증테스트")
    @Test
    void inputTryCountTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> validationCheck.checkInputTryCount(0));
    }

    @DisplayName("생성된 자동차 수량이 입력 값과 일치하는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 3, 7})
    void carNumberTest(int[] inputNum) {
        assertThatIllegalArgumentException().isThrownBy(() -> validationCheck.checkCarNumber(3, inputNum));
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
