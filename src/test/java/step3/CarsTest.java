package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Cars;
import step3.exception.CarRaceCheckInputException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarsTest {

    @ParameterizedTest
    @DisplayName("자동차 n 대 생성")
    @ValueSource(ints = { 1, 5, 500})
    public void createCarTest(int data){
        Cars cars = new Cars();
        cars.createCarList(data);

        assertThat(cars.getCarList().size()).isEqualTo(data);
    }

    @ParameterizedTest
    @DisplayName("자동차 갯수 0 이하일때 자동차 생성")
    @ValueSource(ints = { 0, -1, -23})
    public void inputCarCountTest(int data){
        assertThatExceptionOfType(CarRaceCheckInputException.class)
                .isThrownBy(()->{new Cars().createCarList(data);});
    }
}
