package racing;

import org.junit.jupiter.api.Test;
import racing.generator.NumberGenerator;
import racing.generator.SpecificNumberGenerator;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingManagerTest {
    @Test
    void isMovableTest() {
        //given
        RacingManager racingManager = new RacingManager();

        //when

        //then
        assertThat(racingManager.isMovable(0)).isEqualTo(false);
        assertThat(racingManager.isMovable(1)).isEqualTo(false);
        assertThat(racingManager.isMovable(2)).isEqualTo(false);
        assertThat(racingManager.isMovable(3)).isEqualTo(false);
        assertThat(racingManager.isMovable(4)).isEqualTo(true);
        assertThat(racingManager.isMovable(5)).isEqualTo(true);
        assertThat(racingManager.isMovable(6)).isEqualTo(true);
        assertThat(racingManager.isMovable(7)).isEqualTo(true);
        assertThat(racingManager.isMovable(8)).isEqualTo(true);
        assertThat(racingManager.isMovable(9)).isEqualTo(true);
    }

    @Test
    void nextStepTest() {
        //given
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("test1"));
        cars.add(new Car("test2"));
        NumberGenerator numberGenerator = new SpecificNumberGenerator(9);
        RacingManager manager = new RacingManager(cars, numberGenerator, 1);

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
        RacingManager manager = new RacingManager(cars, numberGenerator, 1);

        //when
        manager.nextStep();

        //then
        assertThat(manager.getCars().get(0).getPosition()).isEqualTo(1);
        assertThat(manager.getCars().get(1).getPosition()).isEqualTo(1);

    }
}
