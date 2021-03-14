package carRacing.domain;

import carRacing.dto.UserInput;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}