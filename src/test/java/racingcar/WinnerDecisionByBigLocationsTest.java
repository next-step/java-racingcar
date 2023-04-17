package racingcar;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class WinnerDecisionByBigLocationsTest {

    private final WinnerDecisionStrategy winnerDecisionStrategy = new WinnerDecisionByBigLocations();

    @Test
    void 위치가_동일한_차들이_주어지는경우_주어진_차들을_모두_우승자로_리턴한다() {
        List<Car> cars = makeCarsWithSameLocation(List.of("def", "aaa", "abc"));

        List<Car> winners = winnerDecisionStrategy.decideWinners(cars);
        List<String> winnerNames = getWinnerNames(winners);

        assertThat(winnerNames).containsExactlyInAnyOrder("abc", "def", "aaa");
    }

    @Test
    void 위치가_가장_큰_차를_우승자로_리턴한다() {
        String winnerName = "abc";
        List<Car> cars = makeCarsWith(
                makeCarOfLocation("def", 0),
                makeCarOfLocation("aaa", 1),
                makeCarOfLocation(winnerName, 2)
        );

        List<Car> winners = winnerDecisionStrategy.decideWinners(cars);
        List<String> winnerNames = getWinnerNames(winners);

        assertThat(winnerNames).containsExactlyInAnyOrder(winnerName);
    }

    private List<Car> makeCarsWith(Car... cars) {
        return Arrays.stream(cars).collect(Collectors.toList());
    }

    private Car makeCarOfLocation(String name, int location) {
        Car car = Car.of("abc");
        for (int i = 0; i < location; i++) {
            car.moveDependingOn(5);
        }
        return car;
    }

    private List<Car> makeCarsWithSameLocation(List<String> names) {
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(Car.of(name));
        }

        return cars;
    }

    private List<String> getWinnerNames(List<Car> winners) {
        return winners.stream().map(Car::name).collect(Collectors.toList());
    }
}
