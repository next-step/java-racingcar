package test;

import core.AlwaysMoveStrategy;
import core.Car;
import core.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    Car first = Car.create("first");
    Car second = Car.create("second");
    Car winner = Car.create("winner");
    Cars cars = Cars.create(Arrays.asList(first, second, winner));

    @DisplayName("우승자 결정 테스트")
    @Test
    void 우승자결정테스트() {
        winner.carAction(new AlwaysMoveStrategy());
        List<String> winnersName = Cars.getWinnersName(cars);
        assertThat(winnersName).isEqualTo(Arrays.asList("winner"));
    }
    
    @DisplayName("공동 우승자 테스트")
    @Test
    void 공동우승자테스트() {
        first.carAction(new AlwaysMoveStrategy());
        second.carAction(new AlwaysMoveStrategy());
        List<String> winnersName = Cars.getWinnersName(cars);
        assertThat(winnersName).isEqualTo(Arrays.asList("first","second"));

    }

}
