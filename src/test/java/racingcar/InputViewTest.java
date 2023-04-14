package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class InputViewTest {

    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void 시스템_아웃_세팅() {
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
    }

    @AfterEach
    void 스캐너_초기화() {
        InputView.setScanner(null);
    }

    @Test
    void 레이스_참가_자동차_이름_입력_질문() {
        assertThat(InputView.askCarNames(
            new ByteArrayInputStream("pobi,crong,honux".getBytes(StandardCharsets.UTF_8))
        )).contains("pobi", "crong", "honux");
    }

    @Test
    void 레이스_회수_입력() {
        assertThat(InputView.askRaceCount(
            new ByteArrayInputStream("2".getBytes(StandardCharsets.UTF_8)))).isEqualTo(2);
    }

    @Test
    void 레이스_회수_입력_질문() {
        InputView.askRaceCount(new ByteArrayInputStream("2".getBytes(StandardCharsets.UTF_8)));
        assertThat(outputStream.toString()).contains("시도할 회수는 몇 회 인가요?");
    }

    @Test
    void 자동차_대수_입력() {
        assertThat(InputView.askCarCount(
            new ByteArrayInputStream("3".getBytes(StandardCharsets.UTF_8)))).isEqualTo(3);
    }

    @Test
    void 자동차_대수_입력_질문() {
        InputView.askCarCount(new ByteArrayInputStream("3".getBytes(StandardCharsets.UTF_8)));
        assertThat(outputStream.toString()).contains("자동차 대수는 몇 대 인가요?");
    }

}
