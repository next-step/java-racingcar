package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinnersTest {

    @Test
    @DisplayName("입력된 차가 없는 경우 승리자도 없음")
    void find_empty() {
        List<Car> cars = new ArrayList<>();

        List<Car> winners = Winners.find(cars);

        assertThat(winners)
                .isEmpty();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:1", "1,2,3:2", "5,3,5:0,2", "472,314,555:2"}, delimiter = ':')
    @DisplayName("여러 케이스에서 승리자를 찾는다")
    void find(String carPosition, String winnerString) {
        String[] carPositionArray = carPosition.split(",");
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < carPositionArray.length; i++) {
            int position = Integer.parseInt(carPositionArray[i]);
            cars.add(new Car("car" + i, position));
        }

        Car[] inputWinners = Arrays.stream(winnerString.split(","))
                .map(Integer::parseInt)
                .map(cars::get)
                .toArray(Car[]::new);

        List<Car> winners = Winners.find(cars);

        assertThat(winners)
                .containsOnly(inputWinners);
    }
}
