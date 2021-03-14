package carRacing.service;

import carRacing.domain.Car;
import carRacing.domain.CarFactory;
import carRacing.dto.UserInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingServiceTest {

    private CarRacingService carRacingService;

    @BeforeEach
    void setUp() {
        this.carRacingService = new CarRacingService();
    }

    @ParameterizedTest
    @CsvSource(value = {
            "pobi,crong,honux:3:3"}, delimiter = ':')
    @DisplayName("입력된 횟수 만큼 레이스를 진행할 수 있다")
    void canRunValidNumberOfRace(String unparsedNames, int numberOfRace, int expectedNumberOfRace) {
        UserInput userInput = new UserInput(unparsedNames, numberOfRace);
        CarFactory carFactory = new CarFactory();
        List<Car> cars = carFactory.initCars(userInput);
        assertThat(carRacingService.runRace(userInput, cars)).isEqualTo(expectedNumberOfRace);
    }

}