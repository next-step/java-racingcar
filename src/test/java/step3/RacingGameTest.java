package step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

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

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 6})
    @DisplayName("입력받은 횟수만큼 랜덤수가 생성되는지 테스트")
    public void initRandomTest(int numberOfTry) {
        List<Integer> randoms = new ArrayList<>();
        for (int i = 0; i < numberOfTry; i++) {
            randoms.add(racingGame.getRandomValue());
        }
        assertThat(randoms.size()).isEqualTo(numberOfTry);
    }

}
