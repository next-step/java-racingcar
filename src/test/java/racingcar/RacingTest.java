package racingcar;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    @Test
    void 레이싱_전체_테스트() {
        // Given
        String testInput = "pobi,crong,honux\n5\n";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        // When
        // Then
        Racing racing = new Racing();
        racing.main();
    }
}
