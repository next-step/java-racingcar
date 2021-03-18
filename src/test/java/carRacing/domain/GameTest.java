package carRacing.domain;

import carRacing.dto.UserInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class GameTest {

    private Game game;

    @BeforeEach
    void setUp() {
        this.game = new Game();
    }

    @Test
    @DisplayName("경주를 진행하기 전과 후의 자동차 개수가 같다")
    void raceReturnsSameNumberOfCars() {
        for (int count = 0; count <= 100; count++) {
            UserInput userInput = new UserInput("test", count);
            List<Car> cars = new CarFactory().initCars(userInput);
            List<Car> updatedCars = game.race(cars);
            assertThat(cars.size()).isEqualTo(updatedCars.size());
        }
    }

    @ParameterizedTest
    @CsvSource(value = {
            "pobi,crong,honux:3:3"}, delimiter = ':')
    @DisplayName("입력된 횟수 만큼 레이스를 진행할 수 있다")
    void canRunValidNumberOfRace(String unparsedNames, int numberOfRace, int expectedNumberOfRace) {
        UserInput userInput = new UserInput(unparsedNames, numberOfRace);
        CarFactory carFactory = new CarFactory();
        List<Car> cars = carFactory.initCars(userInput);
        game.runRace(userInput, cars);
        assertThat(game.askCountToGameJudge(expectedNumberOfRace)).isTrue();
    }

}