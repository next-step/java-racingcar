package racing;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarGameTest {

    private static final String LINE_BREAK = "\n";

    @Test
    void 자동차와_이동횟수_입력() {
        int carCount = 3;
        int moveCount = 5;
        InputStream inputStream = new ByteArrayInputStream((carCount + LINE_BREAK + moveCount + LINE_BREAK).getBytes());
        System.setIn(inputStream);

        Cars movedCars = RacingCarGame.start();
        assertThat(movedCars.values()).hasSize(carCount);
        movedCars.values().forEach(
                car -> assertThat(car.moveCount()).isEqualTo(moveCount)
        );

        System.setIn(System.in);
    }

}
