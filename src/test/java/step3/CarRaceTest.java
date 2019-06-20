package step3;

import org.junit.jupiter.api.Test;
import step3.domain.CarRace;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class CarRaceTest {

    @Test
    void 입력된_자동차이름이_유효하지않으면_예외가_발생한다() {
        String invalidCarName = "";
        int validNumberOfTrials = 3;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    CarRace.raceStart(invalidCarName, validNumberOfTrials);
                });
    }

    @Test
    void 입력된_시도횟수가_유효하지않으면_예외가_발생한다() {
        String validCarName = "testCar";
        int invalidNumberOfTrials = 0;

        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> {
                    CarRace.raceStart(validCarName, invalidNumberOfTrials);
                });
    }

    @Test
    void 입력된_자동차이름과_시도횟수가_유효하면_CarRace_객체가_생성된다() {
        String validCarName = "testCar";
        int validNumberOfTrials = 3;

        assertThat(CarRace.raceStart(validCarName, validNumberOfTrials)).isNotNull();
    }
}
