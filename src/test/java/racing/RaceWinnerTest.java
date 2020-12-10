package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.Racing;
import racing.domain.condition.FixedCondition;
import racing.domain.condition.RandomCondition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RaceWinnerTest {
    private final int TEST_TRY_TIME = 10;
    private final int ALWAYS_TRUE_CONDITION = 9;

    @Test
    @DisplayName("자동차 경주 게임을 완료한 후 우승자를 가려낼 수 있다")
    public void raceWinner() {
        //given
        Cars cars = new Cars(Arrays.asList("A","B","C"), new RandomCondition());
        Racing racing = new Racing(TEST_TRY_TIME, cars);

        //when
        racing.start();

        int max_position = 0;
        String winnerCarName = "";
        for (Car car : cars.getCars()) {
            if (max_position < car.position()) {
                winnerCarName = car.carName();
                max_position = car.position();
            }
        }

        ArrayList<String> winnerCarsName = new ArrayList<>();
        racing.ChooseTheWinner().getWinners().forEach(car -> {
            winnerCarsName.add(car.carName());
        });

        //then
        assertThat(winnerCarsName).contains(winnerCarName);
    }

    @Test
    @DisplayName("우승자는 한명 이상일 수 있다")
    public void raceWinners() {
        //given
        List<String> inputCars = Arrays.asList("A", "B", "C");
        Cars cars = new Cars(inputCars, new FixedCondition(ALWAYS_TRUE_CONDITION));
        Racing racing = new Racing(TEST_TRY_TIME, cars);

        //when
        racing.start();

        //then
        assertEquals(inputCars.size(), racing.ChooseTheWinner().getWinners().size());
    }
}
