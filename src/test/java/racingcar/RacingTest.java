package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


@DisplayName("레이스 테스트")
public class RacingTest {

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void 시스템_아웃_세팅() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Racing.setRace(3, 2);
    }

    @Test
    void 레이스_시작() {
        Racing.startRace();
        for (int i = 0; i < Racing.positions.size(); i++) {
            assertThat(Racing.positions.get(i)).isBetween(0, 9);
        }
    }
}
