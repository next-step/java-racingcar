package refactoringracingcar;

import org.junit.jupiter.api.BeforeEach;
import refactoringracingcar.domain.CarInformation;
import refactoringracingcar.view.InputView;

public class CarInformationTest {

    private CarInformation carInformation;
    private InputView inputView;

    @BeforeEach
    void setup() {
        carInformation = new CarInformation();
    }

}
