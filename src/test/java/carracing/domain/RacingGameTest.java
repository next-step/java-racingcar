package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingGameTest {

    @Test
    @DisplayName("Remain TryCount Test")
    public void remainTryCountTest() {
        List<Car> carList = Arrays.asList(new Name("name1"),new Name("name2")).stream()
                .map(Car::new)
                .collect(Collectors.toList());
        Cars cars = new Cars(carList);

        RacingGame racingGame = new RacingGame(cars, 2);
        assertThat(racingGame.remainTryCount()).isTrue();
        racingGame = new RacingGame(cars, 0);
        assertThat(racingGame.remainTryCount()).isFalse();
    }

    @Test
    @DisplayName("Reduce TryCount Test")
    public void reduceTryCountTest() {
        List<Car> carList = Arrays.asList(new Name("name1"),new Name("name2")).stream()
                .map(Car::new)
                .collect(Collectors.toList());
        Cars cars = new Cars(carList);

        RacingGame racingGame = new RacingGame(cars, 2);
        racingGame.reduceTryCount();
        assertThat(racingGame)
                .usingRecursiveComparison()
                .comparingOnlyFields("carList", "tryCount")
                .isEqualTo(new RacingGame(cars, 1));
    }
}