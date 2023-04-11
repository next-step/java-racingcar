package racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

public class RacingCarTest {

    @Test
    public void 문자_입력_받기() {
        // Given
        String testInput = "3\n5\n";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        // when
        RacingCar.inputView();

        // then
    }
}
