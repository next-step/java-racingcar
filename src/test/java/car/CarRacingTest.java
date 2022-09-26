package car;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarRacingTest {
    List<Car> resultCar;

    @Test
    @DisplayName("자동차 수가 0일 경우")
    void input_zero_test() {
        CarRacing carRacing = init(0, 2);
        carRacing.start();
        assertThat(resultCar.size()).isZero();
    }

    private CarRacing init(int carNum, int tryNum) {
        InputView inputView = new InputView() {
            CarFactory carFactory = new RacingCarFactory();
            @Override
            public List<Car> enterCar() {
                return carFactory.generateCar(carNum);
            }

            @Override
            public int enterTryCount() {
                return tryNum;
            }
        };

        ResultView resultView = new ResultView<Car>() {
            @Override
            public void print(List<Car> cars, int tryNum) {
                resultCar = cars;
            }
        };

        return new CarRacing(inputView, resultView);
    }
}