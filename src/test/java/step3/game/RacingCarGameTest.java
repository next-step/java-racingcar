package step3.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.game.domain.car.CarName;
import step3.game.domain.PositiveNumber;
import step3.game.domain.RacingCarGame;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RacingCarGameTest {

    RacingCarGame racingCarGame;

    @BeforeEach
    void setUp() {
        Set<CarName> carNames = new HashSet<>();
        carNames.add(new CarName("name1"));
        carNames.add(new CarName("name2"));
        carNames.add(new CarName("name3"));

        racingCarGame = new RacingCarGame(carNames, new PositiveNumber("5"));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    @DisplayName("자동차 경주 게임은 선택된 값이 4이상일 경우 전진한다.")
    void isMove(int number) {
        boolean move = racingCarGame.isMove(number);
        assertThat(move).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    @DisplayName("자동차 경주 게임은 선택된 값이 4보다 작을 경우 전진하지 않는다.")
    void isNotMove(int number) {
        boolean move = racingCarGame.isMove(number);
        assertThat(move).isFalse();
    }
}
