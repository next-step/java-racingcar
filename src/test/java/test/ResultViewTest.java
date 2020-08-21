package test;

import core.AlwaysMoveStrategy;
import core.Car;
import core.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.ResultView;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    Car first = Car.create("first");
    Car second = Car.create("second");
    Car winner = Car.create("winner");
    Cars cars = Cars.create(Arrays.asList(first, second, winner));

    @DisplayName("레이싱 게임 결과 출력 테스트")
    @Test
    void 레이싱결과출력테스트() {
        first.carAction(new AlwaysMoveStrategy());
        first.carAction(new AlwaysMoveStrategy());
        String result = ResultView.getStringFromPosition(first);
        assertThat(result).isEqualTo("--");
    }

    @DisplayName("우승자 출력 테스트")
    @Test
    void 우승자출력테스트() {
        winner.carAction(new AlwaysMoveStrategy());
        List<String> carName = ResultView.getWinnersName(cars);
        assertThat(carName).isEqualTo(Arrays.asList("winner"));
    }

}
