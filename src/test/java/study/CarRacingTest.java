package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import study.carRacing.CarRacing;
import study.carRacing.ReceiveInputValue;

import static org.assertj.core.api.Assertions.assertThat;

public class CarRacingTest {
    @Test
    @DisplayName("receive a value for the number of car.")
    void receiveInputValueForCar() {
        int numberOfCar = new ReceiveInputValue().receiveInputValueForCar();
        assertThat(numberOfCar).isEqualTo(3);
    }
}
