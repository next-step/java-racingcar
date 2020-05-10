package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;


public class RacingGameTest {

    private Car[] cars;
    private MovableStrategy movableStrategy = new RandomMovableStrategy();

    @BeforeEach
    void setUp(){
        cars = new Car[3];
        cars[0] = new Car(0, movableStrategy);
        cars[1] = new Car(0, movableStrategy);
        cars[2] = new Car(0, movableStrategy);
    }

    @ValueSource(ints = {3})
    @ParameterizedTest
    @DisplayName("RacingGame play 메소드의 결과 크기는 car의 크기와 같다.")
    public void playTest(int round) {
        int[] result = new RacingGame(round, cars).play();
        assertThat(result).hasSameSizeAs(cars);
    }
}
