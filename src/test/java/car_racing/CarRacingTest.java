package car_racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class CarRacingTest {

    private CarRacingViewController viewController;
    private CarRacingContract.View resultView;
    private CarRacingManager manager;
    private Random random;

    @BeforeEach
    void setup() {
        random = mock(Random.class);
        resultView = mock(CarRacingContract.View.class);
        manager = new CarRacingManager(random);
        viewController = new CarRacingViewController(resultView, manager);
    }

    @DisplayName("자동차들이 잘 초기화 되었는지 확인")
    @Test
    void verifySetupCars() {
        int numOfCar = 3;
        manager.setupCars(numOfCar);
        assertThat(manager.cars.size()).isEqualTo(3);
    }

    @DisplayName("자동차들이 임계값에 따라 잘 전진했는지 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "5 : '- ' ",
            "3 : ''",
            "9 : '- ' ",
            "0 : ''"
    }, delimiter = ':')
    void verifyFowardEachCar(String randomValue, String forward) {
        int numOfCar = 3;
        when(random.nextInt(10)).thenReturn(Integer.valueOf(randomValue));

        manager.setupCars(numOfCar);
        manager.forwardEachCar();

        manager.cars.forEach(car ->
                assertThat(car.forwardStrBuilder.toString()).isEqualTo(forward));
    }

    @DisplayName("input이 제대로 들어갔는지 확인")
    @Test
    void verifyInput() {
        int numOfCar = 3;
        int tryCount = 7;
        manager.setupCars(numOfCar);
        List<Car> cars = manager.forwardEachCar();

        viewController.input(numOfCar, tryCount);

        verify(resultView).resultTitle();
        verify(resultView, times(tryCount)).forward(cars);
        verify(resultView, times(tryCount)).newLine();
    }
}
