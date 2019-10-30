package study.firstweek.secondstep;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    private final Validator validator = new Validator();

    @DisplayName("차가 한대 미만 일 때 ")
    @Test
    void carTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validateNumberOfCars(0));
    }

    @DisplayName("trial 한번 미만 일 때 ")
    @Test
    void trialTest() {
        assertThatIllegalArgumentException().isThrownBy(() -> validator.validateNumberOfTrials(0));
    }
}