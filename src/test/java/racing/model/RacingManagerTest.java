package racing.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import racing.generator.NumberGenerator;
import racing.generator.SpecificNumberGenerator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingManagerTest {

    @ParameterizedTest
    @CsvSource({"0,1", "3,1", "4,2", "9,2"})
    void nextStepTest(int generatedNumber, int expected) {
        //given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("test1"));
        cars.add(new Car("test2"));
        NumberGenerator numberGenerator = new SpecificNumberGenerator(generatedNumber);
        RacingManager manager = new RacingManager(cars, numberGenerator, 1);

        //when
        manager.nextStep();

        //then
        assertThat(manager.getCars().get(0).getPosition()).isEqualTo(expected);
        assertThat(manager.getCars().get(1).getPosition()).isEqualTo(expected);

    }

    @Test
    void nextStepGenerateZeroTest() {
        //given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("test1"));
        cars.add(new Car("test2"));
        NumberGenerator numberGenerator = new SpecificNumberGenerator(0);
        RacingManager manager = new RacingManager(cars, numberGenerator, 1);

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
        cars.get(1).goForward();
        cars.get(2).goForward();
        NumberGenerator numberGenerator = new SpecificNumberGenerator(0);
        RacingManager manager = new RacingManager(cars, numberGenerator, 1);

        //when
        List<Car> result = manager.getWinners();

        //then
        assertThat(result.get(0).getName()).isEqualTo("test2");
        assertThat(result.get(1).getName()).isEqualTo("test3");
    }

    @Test
    void simulateTest() {
        //given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("test1"));
        cars.add(new Car("test2"));
        NumberGenerator numberGenerator = new SpecificNumberGenerator(9);
        RacingManager manager = new RacingManager(cars, numberGenerator, 1);

        //when
        SimulationResult result = manager.simulate();

        //then
        assertThat(result).isEqualTo(new SimulationResult(
                Arrays.asList(
                        Arrays.asList(new CarVO("test1", 1), new CarVO("test2", 1)),
                        Arrays.asList(new CarVO("test1", 2), new CarVO("test2", 2))
                ),
                Arrays.asList("test1", "test2")));
    }
}
