package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    RacingCar racingCar;
    InputView inputView;

    @BeforeEach
    void setup(){
        racingCar = new RacingCar();
        inputView = new InputView();
    }
}
