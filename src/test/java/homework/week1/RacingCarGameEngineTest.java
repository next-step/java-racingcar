package homework.week1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class RacingCarGameEngineTest {
        private RacingCarGameEngine carGameEngine;
        private RacingCarGameFront carGameFront;
    @BeforeEach
    void setUp() {
        System.out.println("setUp");
        carGameEngine = new RacingCarGameEngine(5, new int[3]);
        carGameFront = new RacingCarGameFront();
    }

    @Test
    void racingCarGameEngineConstructor() {
        System.out.println("racingCarGameEngineConstructor");
        assertThat(carGameEngine.getNumbersOfRacing()).isEqualTo(5);
        assertThat(carGameEngine.getCarPositions().length).isEqualTo(3);
        assertThat(carGameEngine.getCarPositions()).containsExactly(0,0,0);
    }

    @Test
    void checkRunCondition() {
        System.out.println("checkRunCondition");
        assertThat(carGameEngine.checkRunCondition(3)).isFalse();
        assertThat(carGameEngine.checkRunCondition(4)).isTrue();

    }

    @Test
    void getRunCount() {
        System.out.println("getRunCount");
        assertThat(carGameEngine.getRunCount(true, 0)).isEqualTo(1);
        assertThat(carGameEngine.getRunCount(false, 0)).isEqualTo(0);
    }

    @Test
    void moveNullPointerException() {
        System.out.println("moveNullPointerException");
        RacingCarGameEngine emptyCarGame = new RacingCarGameEngine(5, null);
        assertThatNullPointerException().isThrownBy(() -> {
            emptyCarGame.move();
        });
    }

    @Test
    void validateUserInputValue() {
        System.out.println("validateUserInputValue");
        assertThatIllegalArgumentException().isThrownBy(()->{
            carGameEngine.validateUserInputValue(0);
        });
    }

    @Test
    void printRacingCars() {
        System.out.println("printRacingCars");
        int[] printTestArr = {1,2,3};
        carGameFront.printRacingCars(printTestArr);
        carGameFront.printRacingCars(printTestArr);
    }
}
