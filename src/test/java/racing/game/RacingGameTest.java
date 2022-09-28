package racing.game;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.game.random.PositiveRandomNumber;
import racing.game.result.RoundResult;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameTest {

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3, 4, 5 })
    void 입력된_라운드_수만큼_레이스를_한다(int numberOfAttempts) {
        RacingGame sut = new RacingGame(new ArrayList<>(), numberOfAttempts);
        assertThat(sut.run().roundResults()).hasSize(numberOfAttempts);
    }

    @Test
    void 입력된_자동차_리스트에_담긴_자동차가_레이스에_참가한다() {
        List<Car> cars = Arrays.asList(new Car("one", new PositiveRandomNumber()), new Car("two", new PositiveRandomNumber()));
        RacingGame sut = new RacingGame(cars, 10);
        RoundResult result = sut.run().roundResults().get(0);

        assertThat(result.namesOfCar()).hasSize(2);
    }
}
