package step1;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.Assertions.*;


public class CalculatorTest {

    ValidationCheck vCheck = new ValidationCheck();

    @BeforeEach
    void setUp(){
        System.out.println("!! SetUp !! ");
    }

    @DisplayName("입력값이 NULL")
    @Test
    void inputNullTest(){
        assertThatIllegalArgumentException().isThrownBy(() ->  vCheck.nullCheck(null));
    }

    @DisplayName("입력값이 공백")
    @Test
    void inputEmptyTest(){
        assertThatIllegalArgumentException().isThrownBy(() ->  vCheck.nullCheck(""));
    }

    @DisplayName("정수가 입력되었는지 검사")
    @ParameterizedTest
    @ValueSource(strings = {
            "일",
            "two",
            "0.5"
    })
    void inputNumTest(String inputNum){
        assertThatIllegalArgumentException().isThrownBy(() -> vCheck.numberCheck(inputNum));
    }

    @DisplayName("정의하지 않은 연산자")
    @ParameterizedTest
    @ValueSource(strings = {
            "!",
            "%",
            "^"
    })
    void calTest(String inputCal){
        assertThatIllegalArgumentException().isThrownBy(() -> vCheck.operatorCheck(inputCal));
    }

    @AfterEach
    void tearDown() {
        System.out.println("tearDown");
    }

}
