package step4;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.model.Cars;
import step4.model.TestMoveStrategy;
import step4.view.InputView;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CarsTest {
    @ParameterizedTest
    @ValueSource(strings = {"abc, pig, apple, green", "abc,pig,apple,green"})
    public void carsNamesTest(String input) {
        Cars cars = new Cars(InputView.splitInput(input));
        assertEquals("abc",cars.getCar(0).name());
        assertEquals("pig",cars.getCar(1).name());
        assertEquals("apple",cars.getCar(2).name());
        assertEquals("green",cars.getCar(3).name());
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc,pig,apple,green"})
    public void carsMoveTest(String input) {
        Cars cars = new Cars(InputView.splitInput(input));
        TestMoveStrategy testMoveStrategy = new TestMoveStrategy();
        for(int i = 0; i < 3; i++){
            cars.move(testMoveStrategy);
        }
        assertEquals(3,cars.getCar(0).distance());
        assertEquals(3,cars.getCar(1).distance());
        assertEquals(3,cars.getCar(2).distance());
        assertEquals(3,cars.getCar(3).distance());
    }
}
