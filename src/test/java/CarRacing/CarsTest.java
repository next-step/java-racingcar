package CarRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.Car;
import racingcar.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private List<String> carName;

    @BeforeEach
    void init() {
        carName = new ArrayList<>();
    }

    @DisplayName("입력한 자동차 이름 숫자만큼 객체 생성")
    @Test
    void createCars() {
        //given
        carName.add("tony");
        carName.add("tom");
        carName.add("brown");
        //when
        Cars cars = new Cars(carName);
        //then
        assertThat(cars).isNotNull();
        assertThat(cars.carList().size()).isEqualTo(3);
    }
}
