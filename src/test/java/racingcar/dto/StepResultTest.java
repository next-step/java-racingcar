package racingcar.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.Motor;
import racingcar.model.TesterMotor;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class StepResultTest {

    private Motor motor;
    private Cars cars;

    @BeforeEach
    void setup() {
        motor = new TesterMotor();

        Car car1 = new Car("belle", motor);
        Car car2 = new Car("jin", motor);

        car1.move();

        cars = new Cars(Arrays.asList(car1, car2));
    }

    @DisplayName("getMaxScore() 테스트 : 최고점 확인")
    @Test
    void getMaxScore() {
        StepResult stepResult = StepResult.of(cars);

        assertThat(stepResult.getMaxScore()).isEqualTo(1);
    }

    @DisplayName("getWinnerName() 테스트 : 우승자 확인")
    @Test
    void getWinnerName() {
        StepResult stepResult = StepResult.of(cars);

        assertThat(stepResult.getWinnerName().size()).isEqualTo(1);
        assertThat(stepResult.getWinnerName()).contains("belle");
    }

}
