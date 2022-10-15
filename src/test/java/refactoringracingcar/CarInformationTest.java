package refactoringracingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import refactoringracingcar.domain.CarInformation;
import refactoringracingcar.racingexception.InputValueException;
import refactoringracingcar.view.InputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarInformationTest {

    private CarInformation carInformation;
    private InputView inputView;

    @BeforeEach
    void setup() {
        carInformation = new CarInformation();
        inputView = new InputView();
    }

    @DisplayName("자동차 이름 분리 테스트")
    @Test
    void splitCarNames() {
        assertThat(carInformation.splitCarNames("scoop,shin,spam,crong")).containsExactly("scoop", "shin", "spam", "crong");
    }

    @DisplayName("자동차 이름 빈값 테스트_1")
    @Test
    void validateNullExceptionTest_1() {
        assertThatExceptionOfType(InputValueException.class).isThrownBy(() -> carInformation.splitCarNames(""));
    }

    @DisplayName("자동차 이름 빈값 테스트_2")
    @Test
    void validateNullExceptionTest_2() {
        assertThatExceptionOfType(InputValueException.class).isThrownBy(() -> carInformation.splitCarNames("scoop,,shin"));
    }

    @DisplayName("자동차 이름 빈값 테스트_3")
    @Test
    void validateNullExceptionTest_3() {
        assertThatExceptionOfType(InputValueException.class).isThrownBy(() -> carInformation.splitCarNames(",shin"));
    }

    @DisplayName("자동차 이름 5글자 이상 테스트")
    @Test
    void validateNameDistanceExceptionTest() {
        assertThatExceptionOfType(InputValueException.class).isThrownBy(() -> carInformation.splitCarNames("scoopsoup,shin"));
    }
}
