package racingcar;

import static org.assertj.core.api.AssertionsForClassTypes.*;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class CarGameInfoTest {
    private static final Random random = new Random();

    @ParameterizedTest
    @MethodSource("getCarListParams")
    public void init(List<Car> carList) {
        CarGameInfo carGameInfo = new CarGameInfo(carList);
    }

    @Test
    public void getWinnerList() {
        List<Car> cars = List.of(new Car(random, "niro", 5), new Car(random, "tusan", 3),
                                 new Car(random, "porsche", 7));
        CarGameInfo carGameInfo = new CarGameInfo(cars);
        List<Car> winners = carGameInfo.getWinnerList();
        assertThat(winners).isNotNull();
        assertThat(winners.size()).isGreaterThan(0);
    }

    private static Stream<Arguments> getCarListParams() {
        return Stream.of(
                Arguments.of(List.of(new Car(random, "niro", 5))),
                Arguments.of(List.of(new Car(random, "niro", 5), new Car(random, "tusan", 3))),
                Arguments.of(List.of(new Car(random, "niro", 5), new Car(random, "tusan", 3),
                                     new Car(random, "porsche", 7))));
    }
}
