package test;

import core.AlwaysMoveStrategy;
import core.Car;
import core.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import view.ResultView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultViewTest {

    Car first = Car.create("first");
    Cars cars = new Cars(new String[]{"first","second","winner"});

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
        cars.stream().filter(car -> car.name == "winner")
                .collect(Collectors.toList())
                .get(0)
                .carAction(new AlwaysMoveStrategy());
        List<String> carName = ResultView.getWinnersName(cars);
        assertThat(carName).isEqualTo(Arrays.asList("winner"));
    }

}
