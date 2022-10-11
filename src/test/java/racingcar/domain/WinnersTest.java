package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class WinnersTest {

    @Test
    @DisplayName("입력된 차가 없는 경우 승리자도 없음")
    void find_empty() {
        List<Car> cars = new ArrayList<>();

        Winners winners = new Winners(cars);

        assertThat(winners).hasFieldOrPropertyWithValue("winners", List.of());
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:1", "1,2,3:2", "5,3,5:0,2", "472,314,555:2"}, delimiter = ':')
    @DisplayName("여러 케이스에서 승리자를 찾는다")
    void findWinner(String carPosition, String winnerString) {
        String[] carPositionArray = carPosition.split(",");
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carPositionArray.length; i++) {
            int position = Integer.parseInt(carPositionArray[i]);
            cars.add(new Car("car" + i, position));
        }

        List<Car> inputWinners = Arrays.stream(winnerString.split(","))
                .map(Integer::parseInt)
                .map(cars::get)
                .collect(Collectors.toList());

        Winners winners = new Winners(cars);

        assertThat(winners).hasFieldOrPropertyWithValue("winners", inputWinners);
    }

    @Test
    @DisplayName("승리자의 이름을 확인한다")
    void winnerNames() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1", 3));
        cars.add(new Car("car2", 5));
        cars.add(new Car("car3", 4));

        Winners winners = new Winners(cars);

        assertThat(winners.getNames())
                .hasSize(1)
                .containsExactly("car2");
    }
}
