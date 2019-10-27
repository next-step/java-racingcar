package step2;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class InputViewTest {

    InputView inputView = new InputView();

    @ParameterizedTest
    @CsvSource(value={
            "3:5",
            "5:5"
    }, delimiter = ':')
    void setCarsTest(int carNum, int turn) {
        Car[] cars = inputView.setCars(carNum, turn);
        assertThat(cars.length).isEqualTo(carNum);
        assertThat(cars[0].moveCountSet.length() - 1).isEqualTo(turn);
    }
}