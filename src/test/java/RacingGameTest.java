import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.in;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingGameTest {

    private RacingGame racingGame;

    @BeforeEach
    void setUp() {
        racingGame = new RacingGame();
    }

    @ParameterizedTest
    @ValueSource(ints = {2, 5, 6})
    void advanceRound(int input) {
        try {
            Method method = racingGame.getClass().getDeclaredMethod("advanceRound", List.class);
            method.setAccessible(true);

            List<Car> cars = new CarFactory(input).generateCars();
            List<Integer> carRecords = (List<Integer>) method.invoke(racingGame, cars);

            carRecords.forEach(record ->
                    assertThat(record).isBetween(0, input)
            );
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @ParameterizedTest
    @CsvSource(value = {"2:3", "4:2"}, delimiter = ':')
    void race(int numberOfcars, int numberOfTimes){
        try {
            Method method = racingGame.getClass().getDeclaredMethod("race", List.class, int.class);
            method.setAccessible(true);

            List<Car> cars = new CarFactory(numberOfcars).generateCars();
            List<List<Integer>> carsRecords = (List<List<Integer>>) method.invoke(racingGame, cars, numberOfTimes);

            assertThat(carsRecords.size())
                    .isEqualTo(numberOfTimes);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}