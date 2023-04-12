package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    public void beforeEach() {
        racingGame = new RacingGame();
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 6})
    @DisplayName("입력받은 차 대수만큼 Car 객체가 생성되었는지 테스트")
    public void initCarsTest(int numberOfCar) {
        racingGame.initCars(numberOfCar);
        assertThat(racingGame.getCars().size()).isEqualTo(numberOfCar);
    }

    @Test
    @DisplayName("입력받은 횟수만큼 차가 움직이는지 테스트")
    public void carMoveTest() {
        int numberOfCars = 5;
        int numberOfTry = 3;
        racingGame.initCars(numberOfCars);
        racingGame.move(numberOfTry);
        Cars cars = racingGame.getCars();
        for (int i = 0; i < cars.size(); i++) {
            assertThat(cars.getCar(i).getPosition()).isBetween(0, 3);
        }
    }
}
