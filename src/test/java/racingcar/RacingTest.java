package racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

public class RacingTest {

    public InputView inputView = new InputView();
    public ResultView resultView = new ResultView();



    @Test
    void 전부_합친_테스트() {
        // Given
        String testInput = "3\n5\n";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        // Then
        Racing race = inputView.init();
        resultView.displayResults(race.getCars());
    }

    @Test
    void 문자_입력_받기() {
        // Given
        String testInput = "pobi,crong,honux\n5\n";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        // Then
        inputView.init();
    }

    @Test
    void 랜덤하게_전진() {
        // Given
        Racing race = new Racing("pobi,crong,honux", 5);

        // When

        // Then
        resultView.displayResults(race.getCars());
    }

    @Test
    void 자동차_출력하기() {
        // Given

        List<Car> cars = Arrays.asList(
                new Car(Arrays.asList(1, 2, 3, 4, 4)),
                new Car(Arrays.asList(1, 1, 2, 3, 4)),
                new Car(Arrays.asList(1, 2, 3, 4, 5))
        );

        // Then
        resultView.displayResults(cars);
    }
}
