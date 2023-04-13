package racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class RacingCarTest {

    public RacingResult racingResult = new RacingResult();

    @Test
    void 문자_입력_받기() {
        // Given
        String testInput = "3\n5\n";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        // When
        RacingCar.inputView();

        // Then
    }

    @Test
    void 랜덤하게_전진() {
        // Given
        int[][] car = new int[3][5];

        // When
        RacingCar.race(car);

        // Then
        racingResult.print(car);
    }

    @Test
    void 자동차_출력하기() {
        // Given
        int[][] car = {{1, 2, 3, 4, 4}
                     , {1, 1, 2, 3, 4}
                     , {1, 2, 3, 4, 5}};

        // When
        // Then
        racingResult.print(car);
    }
}
