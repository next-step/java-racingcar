package racingcar.step4;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class CarTest {

    @Test
    @DisplayName("자동차 객체 생성 테스트")
    void 자동차객체생성(){
        String []cars = {"pobi","cony","hee"};
        List<Car> carList = Car.createCars(cars);
        assertThat(cars.length).isEqualTo(carList.size());
    }

    @ParameterizedTest
    @DisplayName("자동차 전진 테스트")
    @CsvSource(value = {"1:0","2:0","3:0","4:1","5:1","6:1","7:1","8:1","9:1"},delimiter = ':')
    void 자동차전진(int number , int distance){
        Car car = new Car("pobi",0);
        car.move(number);
        assertThat(car.getDistance()).isEqualTo(distance);
    }
}
