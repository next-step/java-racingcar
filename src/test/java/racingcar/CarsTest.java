package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.InputView;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private static final List<String> CAR_NAMES = Arrays.asList("Mark", "Jaehyun", "Johnny");

    private Cars cars;
    private InputView inputView = new InputView();
    private RandomNumGenerator randomNumGenerator = new RandomNumGenerator();

    @BeforeEach
    void setUp() {
        inputView.insertCarNames("Mark,Jaehyun,Johnny");
        inputView.insertTryCount("5");
        cars = new Cars(inputView);
        for (int i = 0; i < inputView.getTryCount(); i++) {
            cars.moveOnce(randomNumGenerator);
        }
    }

    @Test
    void findWinnerTest() {
        //given
        int tryCount = inputView.getTryCount();

        //when
        List<Car> winners = cars.findWinner();

        //then
        assertThat(winners.get(0).getPosition()).isBetween(0, tryCount);
        assertThat(CAR_NAMES).contains(winners.get(0).getName());
    }
}
