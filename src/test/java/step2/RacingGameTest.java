package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import step2.domain.Cars;
import step2.domain.RacingGame;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {
    private String nameOfCars = "pobi,crong,honux";
    private String[] carNames = {"pobi", "crong", "honux"};

    private RacingGame racingGame = new RacingGame(nameOfCars);

    @DisplayName("차 이름 ,로 분리")
    @Test
    void splitCarNameInputTest() {
        assertThat(racingGame.splitCarNameInput(this.nameOfCars)).containsExactly("pobi", "crong", "honux");
    }

    @DisplayName("입력한 차량에서 차량 수 추출")
    @Test
    void extractNumberOfCarsTest() {
        Cars cars = new Cars();
        cars.createCars(carNames);

        assertThat(cars.extractNumberOfCars()).isEqualTo(3);
    }

    @DisplayName("랜덤 값이 0에서 9사이인지 확인")
    @Test
    void generateRandomTest() {
        assertThat(racingGame.generateRandom()).isBetween(0, 9);
    }

    @DisplayName("차량 전진 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1:1:1", "4:4:5"}, delimiter = ':')
    void moveForwardTest(int random, int before, int after) {
        assertThat(racingGame.moveForward(random, before)).isEqualTo(after);
    }

    @DisplayName("iterationCarMove 차량 이동 테스트")
    @Test
    void iterateCarMoveTest() {
        assertThat(racingGame.iterateCarMove(3)).isBetween(3, 4);
    }

    @DisplayName("move 테스트")
    @Test
    void moveTest() {
        assertThat(racingGame.move().getCars()).hasSize(3);
        assertThat(racingGame.move().getCars().get(0).getPosition()).isLessThanOrEqualTo(racingGame.move().getCars().get(0).getPosition());
        assertThat(racingGame.move()).isInstanceOf(Cars.class);
    }
}
