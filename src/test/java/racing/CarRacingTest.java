package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingTest {

    private CarRacing cars;
    private Display display;
    private InputUtil inputUtil;
    @BeforeEach
    void setup(){
        display = new Display();
        inputUtil = new InputUtil();
        cars = new CarRacing(display, inputUtil);
    }

    @Test
    @DisplayName("경주에 참가하는 차의 수 확인")
    void createCar() {
        int numberOfRacingCar = 5;
        assertThat(cars.createCar(numberOfRacingCar)).isEqualTo(5);
    }



}