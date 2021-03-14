package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import step3.exception.CarRaceCheckInputException;
import step3.object.Car;
import step3.view.InputView;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class CarRacingTest {

    @ParameterizedTest
    @DisplayName("입력 값 0 이하 입력")
    @CsvSource(value = {"0,1", "0,5", "0,2", "1,0", "4,0"})
    public void createCarTest(int carCount, int racingCount){
        assertThatExceptionOfType(CarRaceCheckInputException.class)
                .isThrownBy(()->{new InputView().saveInputData(carCount, racingCount);});
    }

    @ParameterizedTest
    @DisplayName("자동차 n 대 생성")
    @ValueSource(ints = { 1, 5, 500})
    public void createCarTest(int data){
        CarRaceController carRaceController = new CarRaceController();
        carRaceController.createCarList(data);

        assertThat(carRaceController.getCarList().size()).isEqualTo(data);
    }

    @ParameterizedTest
    @DisplayName("자동차 랜덤값 4 이상 입력시 이동")
    @ValueSource(ints = { 5, 10, 500})
    public void moveCarTest(int data){
        Car car = new Car();
        car.go(data);

        assertThat(car.getGoCount()).isEqualTo(1);
    }

    @ParameterizedTest
    @DisplayName("자동차 랜덤값 3 이하 입력시 이동 안함")
    @ValueSource(ints = { 3, -1, 0, 2})
    public void notMoveCarTest(int data){
        Car car = new Car();
        car.go(data);

        assertThat(car.getGoCount()).isEqualTo(0);
    }
}
