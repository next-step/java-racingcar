package racingcar;

import org.junit.jupiter.api.Test;
import racingcar.view.InputView;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class RacingCarTest {

    @Test
    void inputTest() {

        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        int res = InputView.getInput("입력");
        assertThat(3).isEqualTo(res);
    }

    @Test
    void inputExceptionTest() {
        String input = "str";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        assertThatThrownBy(() -> InputView.getInput("입력하슝")).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("should be number");
    }

    @Test
    void carMoveLocationTest() {
        int firstLocation = 2;
        Car car = new Car(firstLocation);

        assertThat(car.move().getLocation()).isBetween(firstLocation, firstLocation + 1);
    }

    @Test
    void scoreListTest() {

        int numOfCars = 4;
        int numOfTries = 5;
        Racing racing = new Racing(numOfCars, numOfTries);

        List<MidScore> midScoreList = racing.startAndGetScoreList();

        assertThat(midScoreList.size()).isEqualTo(numOfTries);

        for (int value = 0; value < numOfTries; value++) {

            MidScore mid = midScoreList.get(value);
            assertThat(mid.getScores().length).isEqualTo(numOfCars);
            int finalValue = value;
            Arrays.stream(mid.getScores())
                    .forEach(
                            score -> assertThat(score).isBetween(0, finalValue + 1)
                    );
        }
    }


}
