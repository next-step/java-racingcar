package racing.domain;

import org.junit.jupiter.api.Test;
import racing.generator.NumberGenerator;
import racing.generator.SpecificNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingManagerTest {
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
        assertThat(manager.getCars().get(0).getPosition().getPosition()).isEqualTo(2);
        assertThat(manager.getCars().get(1).getPosition().getPosition()).isEqualTo(2);

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
        assertThat(manager.getCars().get(0).getPosition().getPosition()).isEqualTo(1);
        assertThat(manager.getCars().get(1).getPosition().getPosition()).isEqualTo(1);

    }

    @Test
    void getWinnersTest() {
        //given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("test1"));
        cars.add(new Car(new Name("test2"), new Position(2)));
        cars.add(new Car(new Name("test3"), new Position(2)));
        NumberGenerator numberGenerator = new SpecificNumberGenerator(0);
        RacingManager manager = new RacingManager(cars, numberGenerator);

        //when
        List<String> result = manager.getWinners();

        //then
        assertThat(result.get(0)).isEqualTo("test2");
        assertThat(result.get(1)).isEqualTo("test3");
    }
}
