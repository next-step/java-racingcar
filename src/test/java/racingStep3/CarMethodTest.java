package racingStep3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingStep3.domain.RacingCar;
import racingStep3.service.util.Validation;

import static org.assertj.core.api.Assertions.*;

public class CarMethodTest {

    private RacingCar racingCar;

    @BeforeEach
    void setUp() {

        racingCar = RacingCar.create();
    }

    @Test
    @DisplayName("랜덤 값이 4이상 일경우 앞으로 한칸 이동!!!")
    public void forwardTest() {
        racingCar.decisionMove(true);

        assertThat(racingCar.getLocation()).isEqualTo(1);
    }

    @Test
    @DisplayName("랜덤 값이 4미만 일경우 자동차 이동 하지 않음!!")
    public void stopTest() {
        racingCar.decisionMove(false);

        assertThat(racingCar.getLocation()).isEqualTo(0);
    }

    @Test
    @DisplayName("값이 비정상적인 경우")
    void checkNotNull() {
        String request = "test data";

        assertThatIllegalArgumentException().isThrownBy(() ->
                Validation.numberCheck(request));
    }

    @Test
    @DisplayName("값이 null 인 경우 예외가 발생 검증")
    void checkNullPointerException() {
        String request = null;

        assertThatNullPointerException().isThrownBy(() ->
                Validation.validInputData(request));
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1"})
    @DisplayName("최소값이 값이 0보다 작은 경우")
    void checkMinimumSize(String request) {

        assertThatIllegalArgumentException().isThrownBy(() ->
                Validation.validInputData(request));
    }

}
