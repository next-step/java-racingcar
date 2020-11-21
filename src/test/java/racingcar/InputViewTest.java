package racingcar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class InputViewTest {

    String[] carNames = {"john", "tom", "myung"};
    Car car = new Car();

    @BeforeAll
    static void beforeAll() {
        Car car = new Car();
    }

    @DisplayName("입력split테스트")
    @Test
    void inputCarNamesTest() {
        String[] inputNames = InputView.splitCarNames("john,tom,myung");
        assertThat(inputNames).isEqualTo(carNames);
    }

    @DisplayName("입력정상")
    @Test
    void carNamesValidationTest_SUCCESS() {
        boolean result = CarRace.carNamesValidation("john,tom,myung");
        assertTrue(result);
    }

    @DisplayName("5자이상입력")
    @Test
    void carNamesValidationTest_FAIL() {
        boolean result = CarRace.carNamesValidation("john,tom,petrucci");
        assertFalse(result);
    }

}
