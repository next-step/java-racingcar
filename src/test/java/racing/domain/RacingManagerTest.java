package racing.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.generator.NumberGenerator;
import racing.generator.SpecificNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingManagerTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 10})
    void isMovableReturnFalseTest(int number) {
        //given
        RacingManager racingManager = new RacingManager();

        //when, then
        assertThat(racingManager.isMovable(number)).isEqualTo(false);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void isMovableReturnTrueTest(int number) {
        //true
        RacingManager racingManager = new RacingManager();

        //when, then
        assertThat(racingManager.isMovable(number)).isEqualTo(true);
    }

    @Test
    void nextStepTest() {
        //given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("test1"));
        cars.add(new Car("test2"));
        NumberGenerator numberGenerator = new SpecificNumberGenerator(9);
        RacingManager manager = new RacingManager(cars, numberGenerator);

        //when
        manager.nextStep();

        //then
        assertThat(manager.getCars().get(0).getPosition()).isEqualTo(2);
        assertThat(manager.getCars().get(1).getPosition()).isEqualTo(2);

    }

    @Test
    void nextStepGenerateZeroTest() {
        //given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("test1"));
        cars.add(new Car("test2"));
        NumberGenerator numberGenerator = new SpecificNumberGenerator(0);
        RacingManager manager = new RacingManager(cars, numberGenerator);

        //when
        manager.nextStep();

        //then
        assertThat(manager.getCars().get(0).getPosition()).isEqualTo(1);
        assertThat(manager.getCars().get(1).getPosition()).isEqualTo(1);

    }

    @Test
    void getWinnersTest() {
        //given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("test1"));
        cars.add(new Car("test2"));
        cars.add(new Car("test3"));
        cars.get(1).goForward(true);
        cars.get(2).goForward(true);
        NumberGenerator numberGenerator = new SpecificNumberGenerator(0);
        RacingManager manager = new RacingManager(cars, numberGenerator);

        //when
        List<String> result = manager.getWinners();

        //then
        assertThat(result.get(0)).isEqualTo("test2");
        assertThat(result.get(1)).isEqualTo("test3");
    }
}
