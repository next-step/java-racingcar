package racingcar.view;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class ResultViewTest {

    ResultView resultView = new ResultView();

    @ParameterizedTest
    @CsvSource({"3, ---"})
    @DisplayName("자동차의 위치를 표시할 수 있다.")
    void canDisplayCarPosition(int position, String displayPosition) {
        Assertions.assertThat(resultView.printEachCar(position)).isEqualTo(displayPosition);
    }
}