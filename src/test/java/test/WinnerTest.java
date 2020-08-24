package test;

import core.AlwaysMoveStrategy;
import core.Car;
import core.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    Cars cars = new Cars(new String[]{"first","second","winner"});

    @DisplayName("우승자 결정 테스트")
    @Test
    void 우승자결정테스트() {
        cars.stream().filter(car -> car.name == "winner")
                .collect(Collectors.toList())
                .get(0)
                .carAction(new AlwaysMoveStrategy());
        List<String> winnersName = Cars.getWinnersNames(cars);
        assertThat(winnersName).isEqualTo(Arrays.asList("winner"));
    }

    @DisplayName("공동 우승자 테스트")
    @Test
    void 공동우승자테스트() {
        cars.stream().filter(car -> car.name == "first" || car.name == "second")
                .collect(Collectors.toList())
                .forEach(car -> car.carAction(new AlwaysMoveStrategy()));
        List<String> winnersName = Cars.getWinnersNames(cars);
        assertThat(winnersName).isEqualTo(Arrays.asList("first","second"));

    }

}
