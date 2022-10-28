package refactoringracingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import refactoringracingcar.domain.CarName;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarNameTest {

    @DisplayName("자동차이름 예외처리_5자리 이상")
    @Test
    void carNameExceptionTest_01() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> new CarName("scoopsoup"));
    }

    @DisplayName("자동차이름 예외처리_Null값_01")
    @Test
    void carNameExceptionTest_02() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> new CarName(""));
    }

    @DisplayName("자동차이름 예외처리_Null값_02")
    @Test
    void carNameExceptionTest_03() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> new CarName(",scoop"));
    }

    @DisplayName("자동차이름 예외처리_Null값_03")
    @Test
    void carNameExceptionTest_04() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> new CarName("scoop,"));
    }

}
