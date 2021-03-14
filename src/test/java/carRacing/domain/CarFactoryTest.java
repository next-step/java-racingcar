package carRacing.domain;

import carRacing.dto.UserInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarFactoryTest {

    private CarFactory carFactory;

    @BeforeEach
    void setUp() {
        this.carFactory = new CarFactory();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "pobi,crong,honux:2:3",
            "pobi,crong:2:2",
            "pobi,crong,honux,petty:3:4"}, delimiter = ':')
    @DisplayName("자동차를 원하는 숫자만큼 초기화해서 생성할 수 있다")
    void prepareCarsReturn(String unparsedNames, int numberOfRace, int expectedCarNumber) {
        UserInput userInput = new UserInput(unparsedNames, numberOfRace);
        List<Car> cars = carFactory.initCars(userInput);
        assertThat(cars.size()).isEqualTo(expectedCarNumber);
    }

}