package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ResultViewTest {

    public ResultView resultView = new ResultView();

    @Test
    void 자동차_출력하기() {
        // Given
        List<Car> cars = Arrays.asList(
                new Car("pobi", Arrays.asList(1, 2, 3, 4, 4)),
                new Car("crong", Arrays.asList(1, 1, 2, 3, 4)),
                new Car("honux", Arrays.asList(1, 2, 3, 4, 5))
        );

        // When
        CarCollection carCollection = new CarCollection(cars);
        String results = resultView.getResults(carCollection);
        String lineSeparator = System.lineSeparator();

        // Then
        assertThat(results).isEqualTo(
                "pobi : -" + lineSeparator +
                        "crong : -" + lineSeparator +
                        "honux : -" + lineSeparator +
                        "" + lineSeparator +
                        "pobi : --" + lineSeparator +
                        "crong : -" + lineSeparator +
                        "honux : --" + lineSeparator +
                        "" + lineSeparator +
                        "pobi : ---" + lineSeparator +
                        "crong : --" + lineSeparator +
                        "honux : ---" + lineSeparator +
                        "" + lineSeparator +
                        "pobi : ----" + lineSeparator +
                        "crong : ---" + lineSeparator +
                        "honux : ----" + lineSeparator +
                        "" + lineSeparator +
                        "pobi : ----" + lineSeparator +
                        "crong : ----" + lineSeparator +
                        "honux : -----" + lineSeparator +
                        "" + lineSeparator);
    }
}