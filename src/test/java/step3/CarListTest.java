package step3;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarListTest {


    @DisplayName("자동차에게 랜덤숫자를 넣어 이동하라고 요청할 수 있다. ")
    @ParameterizedTest
    @CsvSource(value = {"1,0", "4,1","9,1"})
    void moveCars(int randomNumber, int result) {
        RandomNumberCreator randomNumberCreator = () -> randomNumber;

        List<Car> cars = List.of(new Car(), new Car(), new Car(), new Car());
        CarList carList = CarList.from(cars, randomNumberCreator);
        carList.moveWithRandomNumber();

        List<Car> listCars = carList.getCars();
        listCars.forEach(item -> Assertions.assertThat(item.getMoveNumber()).isEqualTo(result));
    }
}
