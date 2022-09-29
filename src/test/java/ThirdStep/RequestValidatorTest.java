package ThirdStep;

import ThirdStep.domain.model.request.CarRequest;
import ThirdStep.domain.validator.RequestValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RequestValidatorTest {

    final private static String WRONG_NAME = "helloWorld";
    private CarRequest carRequest;

    @BeforeEach
    void setCarRequest() {
        carRequest = new CarRequest(WRONG_NAME);
    }

    @Test
    @DisplayName("자동차 이름이 5글자가 넘는 요청이 들어오면 RunTimeException을 일으킨다.")
    void name_validation_test() {
        assertThatThrownBy(() -> RequestValidator.carValidation(carRequest))
                .isInstanceOf(RuntimeException.class);
    }
}
