package step2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingTest {

    @ParameterizedTest
    @CsvSource(value={
            "3:5",
            "5:5"
    }, delimiter = ':')
    void setRacingTest(int carNum, int turn) {
        InputView inputView = new InputView();
        inputView.carNum = carNum;
        inputView.turn = turn;
        Racing racing = new Racing(inputView);
        assertThat(racing.cars.length).isEqualTo(carNum);
        assertThat(racing.turn).isEqualTo(turn);
    }
}