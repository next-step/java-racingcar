package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.strategy.FalseMovableStrategy;
import racingcar.strategy.RandomMovableStrategy;
import racingcar.strategy.TrueMovableStrategy;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class CarRaceTest {

    @Test
    @DisplayName("car List size 확인")
    void init() {
        String[] names = {"a", "b", "c", "d", "e"};
        CarRace carRace = new CarRace(names, new RandomMovableStrategy());
        assertThat(carRace.getCars()).hasSize(5);
    }

    @Test
    @DisplayName("우승자 확인")
    void getWinner() {
        CarRace carRace = new CarRace(
                Arrays.asList(
                        new Car("a", new FalseMovableStrategy()),
                        new Car("b", new TrueMovableStrategy()),
                        new Car("c", new TrueMovableStrategy()),
                        new Car("d", new TrueMovableStrategy()),
                        new Car("e", new FalseMovableStrategy())
                )
        );
        carRace.race();
        assertThat(carRace.getWinners()).hasSize(3);
    }
}