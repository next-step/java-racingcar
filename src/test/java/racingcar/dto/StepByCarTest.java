package racingcar.dto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Motor;
import racingcar.model.TesterMotor;

import static org.assertj.core.api.Assertions.assertThat;

public class StepByCarTest {

    @DisplayName("StepByCar() 테스트 생성자 테스트")
    @Test
    void StepByCar() {
        String name = "belle";
        Motor motor = new TesterMotor();

        StepByCar stepByCar = StepByCar.of(new Car(name, motor));

        assertThat(stepByCar)
                .isEqualToComparingFieldByField(StepByCar.of(new Car(name, motor)));
    }
}
