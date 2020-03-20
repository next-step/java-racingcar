package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.InputView;
import racingcar.dto.OutputView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class OutputViewTest {
    private Cars cars;
    private RandomNumGenerator randomNumGenerator;

    @BeforeEach
    void setUp() {
        InputView inputView = new InputView();
        inputView.insertCarNames("Mark,Jaehyun,Johnny");
        inputView.insertTryCount("5");
        cars = new Cars(inputView);
    }

    @Test
    void findWinnerTest() {
        //given
        OutputView outputView = new OutputView(cars, randomNumGenerator);

        //when
        List<Car> winners = outputView.findWinner();

        //then
        assertThat(winners.size()).isGreaterThan(1);
    }
}
