
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import step3.domain.Car;
import step3.service.CarPlay;
import step3.service.InputView;

class CarPlayTest {

    private CarPlay carPlay;
    private InputView inputView;
    private Car car;
    private int carNumber = 1;
    private int attempts = 1;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setTest() {
        car = new Car();
        inputView = new InputView(carNumber, attempts);
        carPlay = new CarPlay(inputView);
        System.setOut(new PrintStream(outContent));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7})
    @DisplayName("자동차의 현재 상태를 0또는 1만 반환하는 지 확인")
    void checkReturnBiggerThanFour(int input) {

        Car testCar = car.carAction();

        if (input < 2) {
            assertThat(testCar.getCurrentStatus()).isGreaterThanOrEqualTo(input);
        } else {
            assertThat(testCar.getCurrentStatus()).isLessThanOrEqualTo(input);
        }
    }

    @Test
    @DisplayName("자동차 상태값이 '-' 로 변환되어 출력 되는지 확인")
    void checkConvertStatusAndPrint() {

        carPlay.convertCarStatusToPrint(inputView);

        assertEquals("-\n", outContent.toString());
    }
}