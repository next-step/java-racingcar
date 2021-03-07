package step3;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.controller.CarController;
import step3.domain.RacingCarGame;
import step3.validation.InputValidation;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTests {

    private CarController carController;
    private InputValidation inputValidation;

    @BeforeEach
    public void setup() {
        inputValidation = new InputValidation();
        carController = new CarController(3,5);
    }


    @DisplayName("랜덥 값 4이상인지 체크")
    @Test
    public void check() {
        assertThat(inputValidation.isRandomValueMoreThenFour(3)).isEqualTo(false);
    }

    @DisplayName("랜덤 값이 같은지 비교")
    @Test
    public void sumString() {

    }

}
