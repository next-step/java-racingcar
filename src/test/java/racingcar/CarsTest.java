package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.InputView;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private static final List<String> CAR_NAMES = Arrays.asList("Mark", "Jaehyun", "Johnny");
    private Cars cars;
    private InputView inputView;
    private RandomNumGenerator randomNumGenerator = new RandomNumGenerator();

    @BeforeEach
    void setUp() {
        inputView = new InputView("Mark,Jaehyun,Johnny", "5");
        cars = new Cars(inputView);

    }

    @Test
    void moveOnceTest() {
        //given
        int tryCount = inputView.getTryCount();

        //when
        for (int i = 0; i < inputView.getTryCount(); i++) {
            cars.moveOnce(randomNumGenerator);
        }

        //then
        assertThat(cars.getCars().get(0).getPosition()).isBetween(0, tryCount);
    }

    @Test
    void findWinnerTest() {
        //given
        int tryCount = inputView.getTryCount();
        for (int i = 0; i < inputView.getTryCount(); i++) {
            cars.moveOnce(randomNumGenerator);
        }

        //when
        List<Car> winners = cars.findWinner();

        //then
        assertThat(winners.get(0).getPosition()).isBetween(0, tryCount);
        assertThat(CAR_NAMES).contains(winners.get(0).getName());
    }
}