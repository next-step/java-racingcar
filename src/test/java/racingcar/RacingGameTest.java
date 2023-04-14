package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Cars;

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

    @ParameterizedTest
    @CsvSource(value = {"a,b,c|3", "a|1", "a,b,c,d,e,f|6"}, delimiter = '|')
    @DisplayName("자동차 이름 추가에 따른 자동차 생성 테스트")
    public void initCarsWithNameTest(String input, int result) {
        RacingGame racingGame = new RacingGame();
        racingGame.initCars(input);
        assertThat(racingGame.getCars().size()).isEqualTo(result);
    }

    @Test
    @DisplayName("자동차 이름 추가에 따른 자동차 생성 예외테스트")
    public void initCarsWithNameLengthExceptionTest() {
        RacingGame racingGame = new RacingGame();
        assertThatThrownBy(() -> racingGame.initCars("abcdef,ab"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자동차 이름은 5자를 초과할 수 없습니다.");
    }

    @Test
    @DisplayName("자동차 이름 추가에 따른 자동차 생성 예외테스트")
    public void initCarsWithNameDuplicateExceptionTest() {
        RacingGame racingGame = new RacingGame();
        assertThatThrownBy(() -> racingGame.initCars("a,a,b,c"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 이름을 가진 자동차가 있습니다.");
    }
}
