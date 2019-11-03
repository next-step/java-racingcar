package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    private RacingGame racingGame;
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car();
        racingGame = new RacingGame(car);
    }

    @ParameterizedTest
    @CsvSource("4, 5, 9")
    @DisplayName("전진 조건 테스트")
    void moveConditionTest(int conditionValue) {
        assertThat(racingGame.start(conditionValue).position).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource("1, 2, 3")
    @DisplayName("멈춤 조건 테스트")
    void stopConditionTest2(int conditionValue) {
        assertThat(racingGame.start(conditionValue).position).isEqualTo(0);
    }
}
