package homework.week1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarGameEngineTest {
        private RacingCarGameEngine carGameEngine;
        private RacingCarGameFront carGameFront;

    @BeforeEach
    void setUp() {
        carGameEngine = new RacingCarGameEngine();
        carGameFront = new RacingCarGameFront();
    }

    @Test
    void emptyInputTest() {
        String emptyStr = "";
        assertThatIllegalArgumentException().isThrownBy(() -> {
            carGameEngine.checkEmptyString(emptyStr);
        });
    }

    @Test
    void splitInputTest() {
        String[] carNames = carGameEngine.splitInput("qwe,asd,zxc");
        assertThat(carNames).containsExactly("qwe", "asd", "zxc");
    }

    @Test
    void emptyStrArrValueTest() {
        String[] emptyCarNames = carGameEngine.splitInput(",,");
        assertThatIllegalArgumentException().isThrownBy(() -> {
            carGameEngine.checkEmptyCarNames(emptyCarNames);
        });
    }

    @Test
    void positiveNumberTest() {
        int negativeNum = -1;
        int zeroNum = 0;
        assertThatIllegalArgumentException().isThrownBy(() -> {
            carGameEngine.checkInputPositiveNum(negativeNum);
            carGameEngine.checkInputPositiveNum(zeroNum);
        });
    }

    @Test
    void racingGameEngineInitTest() {
        String[] carNames = {"qwe", "asd", "zxc"};
        carGameEngine.initialize(carNames, 5);
        assertThat(carGameEngine.getCars().get(0).getName()).isEqualTo("qwe");
        assertThat(carGameEngine.getCarsRunCount().size()).isEqualTo(3);
        assertThat(carGameEngine.getNumberOfRacing()).isEqualTo(5);
    }

    @Test
    void checkRunCondition() {
        assertThat(carGameEngine.checkRunCondition(3)).isFalse();
        assertThat(carGameEngine.checkRunCondition(4)).isTrue();

    }

    @Test
    void getRunCount() {
        assertThat(carGameEngine.getRunCount(true, 0)).isEqualTo(1);
        assertThat(carGameEngine.getRunCount(false, 0)).isEqualTo(0);
    }

    @Test
    void printRacingCars() {
        List<Integer> printTestArr = new ArrayList<>();
        printTestArr.add(1);
        printTestArr.add(2);
        printTestArr.add(3);
        carGameFront.printRacingCars(printTestArr);
        carGameFront.printRacingCars(printTestArr);
    }

    @Test
    void goRacingGame() {
        carGameFront.goRacingGame(carGameEngine);
    }

}
