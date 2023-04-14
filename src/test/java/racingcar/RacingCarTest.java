package racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class RacingCarTest {

    public InputView inputView = new InputView();
    public ResultView resultView = new ResultView();



    @Test
    void 전부_합친_테스트() {
        // Given
        String testInput = "3\n5\n";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        // Then
        RacingCar car = inputView.init();
        car.startRace();
        car.displayResults();
    }

    @Test
    void 문자_입력_받기() {
        // Given
        String testInput = "3\n5\n";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        // Then
        inputView.init();
    }

    @Test
    void 랜덤하게_전진() {
        // Given
        RacingCar car = new RacingCar(3, 5);

        // When
        car.startRace();

        // Then
        car.displayResults();
    }

    @Test
    void 자동차_출력하기() {
        // Given
        int[][] carPositions = {{1, 2, 3, 4, 4}
                     , {1, 1, 2, 3, 4}
                     , {1, 2, 3, 4, 5}};

        // Then
        resultView.displayResults(carPositions);
    }
}
