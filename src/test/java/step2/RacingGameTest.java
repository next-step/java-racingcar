package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.Car;
import step2.domain.Cars;
import step2.domain.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private String nameOfCars = "pobi,crong,honux";

    private RacingGame racingGame = new RacingGame(nameOfCars);

    @DisplayName("차 이름 ,로 분리")
    @Test
    void splitCarNameInputTest() {
        assertThat(racingGame.splitCarNameInput(this.nameOfCars)).containsExactly("pobi", "crong", "honux");
    }

    @DisplayName("입력한 차량에서 차량 수 추출")
    @Test
    void extractNumberOfCarsTest() {
        Cars cars = racingGame.getCars();;
        assertThat(cars.extractNumberOfCars()).isEqualTo(3);
    }

    @DisplayName("랜덤 값이 0에서 9사이인지 확인")
    @Test
    void generateRandomTest() {
        assertThat(racingGame.generateRandom()).isBetween(0, 9);
    }

    @DisplayName("차량 이동 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:0", "4:1"}, delimiter = ':')
    void moveTest(int random, int after) {
        Car car = new Car(0, "pobi");

        assertThat(car.tryMove(random)).isEqualTo(after);
    }

    @DisplayName("race 테스트")
    @Test
    void raceTest() {
        assertThat(racingGame.race().getCars()).hasSize(3);
        assertThat(racingGame.race().getCars().get(0).getPosition()).isLessThanOrEqualTo(racingGame.race().getCars().get(0).getPosition());
        assertThat(racingGame.race()).isInstanceOf(Cars.class);
    }
}
