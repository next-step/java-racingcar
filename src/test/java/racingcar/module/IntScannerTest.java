package racingcar.module;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;

public class IntScannerTest {
    void setInputSteam(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    void 자동차수_입력_테스트() {
        setInputSteam("5");

        assertThat(IntScanner.insertCarCount()).isEqualTo(5);
    }

    @Test
    void 시도회수_입력_테스트() {
        setInputSteam("3");

        assertThat(IntScanner.insertRaceCount()).isEqualTo(3);
    }
}
