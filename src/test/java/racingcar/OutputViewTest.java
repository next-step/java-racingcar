package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class OutputViewTest {

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void 시스템_아웃_세팅() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        Racing.setRace(3, 10);
        Racing.startRace();
    }

    @Test
    void 레이스_결과() {
        OutputView.endRace();
        assertThat(outputStream.toString()).containsPattern("(-{1,2}\n){3}\n((-{1,11}\n){3}\n){9}");
    }

}
