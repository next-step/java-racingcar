package race;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilTest {

    private static final StringBuilder stringBuilder = new StringBuilder();
    void 자동차_수_입력() throws Exception {
        String value = "3";

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(value.getBytes())));
        stringBuilder.append(bufferedReader.readLine());

        assertThat(stringBuilder).hasToString(value);
    }

    @Test
    void 시도_횟수_입력() throws Exception {
        String value = "5";

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(value.getBytes())));
        stringBuilder.append(bufferedReader.readLine());

        assertThat(stringBuilder).hasToString(value);
    }

    @Test
    void 랜덤값_추출() {
        int value = Util.getRandomNumber();
        assertThat(value).isBetween(0,9);
    }
}
