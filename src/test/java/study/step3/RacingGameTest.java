package study.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import step3.domain.Car;
import step3.domain.RacingGame;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    private static final int TIME = 3;
    private static final String INPUT = "pobi,crong,honux";
    private static final String TEST_NAME = "car";
    private RacingGame racingGame;
    private Car car;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame(TIME, INPUT);
        car = new Car(TEST_NAME);
    }

    @Test
    void racingGameCreateCarObjectTest() {
        assertThat(racingGame.initiateCar(INPUT)).hasSize(3);
    }

    @Test
    void calculateWinnerPositionTest() {
        assertThat(racingGame.calculateWinnerPosition()).isGreaterThan(0);
    }

    @Test
    void domainCarNameTest() {
        assertThat(car.getName()).isEqualTo(TEST_NAME);
    }

}